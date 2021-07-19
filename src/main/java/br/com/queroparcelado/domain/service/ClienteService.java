package br.com.queroparcelado.domain.service;

import br.com.queroparcelado.domain.exception.EntidadeNaoEncontrataException;
import br.com.queroparcelado.domain.exception.JaExisteException;
import br.com.queroparcelado.domain.model.Cliente;
import br.com.queroparcelado.domain.model.dto.ValidarClienteDTO;
import br.com.queroparcelado.domain.model.login.Permissao;
import br.com.queroparcelado.domain.model.login.Usuario;
import br.com.queroparcelado.domain.repository.ClienteRepository;
import br.com.queroparcelado.domain.repository.PermissaoRepository;
import br.com.queroparcelado.domain.repository.UsuarioRepository;
import br.com.queroparcelado.domain.utils.EnviarSMS;
import br.com.queroparcelado.domain.utils.GerarSenhaUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PermissaoRepository permissaoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository usuarioRepository;


    public List<Cliente> buscarClientes() {
        return clienteRepository.findAll();
    }

    public ResponseEntity<Cliente> buscarCliente(Long idCliente) {
        Optional<Cliente> cliente = getCliente(idCliente);
        return ResponseEntity.ok(cliente.get());
    }

    public Optional<Cliente> getCliente(Long idCliente) {
        Optional<Cliente> cliente = clienteRepository.findById(idCliente);

        if (cliente.isEmpty()) {
            throw new EntidadeNaoEncontrataException(String.format("Cliente não encontrato com o código %d", idCliente));
        }
        return cliente;
    }


    public Cliente salvar(Cliente cliente) {

        validarClienteJaExist(cliente);

        // gera um codigo aleatorio
        cliente.setCodigoConfirmacao(GerarSenhaUtil.gerarSenha());
        cliente.setAtivo(false);

        // envia o sms para o celular do cliente para confirmacao de sua conta
        String senha = EnviarSMS.sendSMS(cliente.getFone());

        cliente.setCodigoConfirmacao(senha);

        Usuario usuario = new Usuario();
        usuario.setLogin(cliente.getEmail());
        usuario.setSenha(passwordEncoder.encode(cliente.getSenha()));


        Permissao permissao = permissaoRepository.findById(2L).get();
        usuario.setPermissao(permissao);

        Cliente clienteSalvo = clienteRepository.save(cliente);
        usuario.setCliente(clienteSalvo);

        usuarioRepository.save(usuario);
        return clienteSalvo;
    }

    private void validarClienteJaExist(Cliente cliente) {

        if (clienteRepository.findByCpf(cliente.getCpf()).isPresent()) {
            throw new JaExisteException("CPF já cadastrado no sistema");
        }

        if (clienteRepository.findByEmail(cliente.getEmail()).isPresent()) {
            throw new JaExisteException("Email já cadastrado no sistema");
        }
    }

    public ResponseEntity<Cliente> updateCliente(Long idCliente, Cliente cliente) {

        Cliente clienteBanco = validarCliente(idCliente);

        BeanUtils.copyProperties(cliente, clienteBanco, "id", "dataCadastro");
        return ResponseEntity.ok(clienteRepository.save(clienteBanco));
    }

    Cliente validarCliente(Long idCliente) {
        Optional<Cliente> cliente = getCliente(idCliente);
        return cliente.get();
    }


    public ResponseEntity<List<Cliente>> buscarClientePorNome(String nomeCliente) {
        Optional<List<Cliente>> clientes = clienteRepository.findByNomeContaining(nomeCliente);
        return clientes
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    public ResponseEntity<Cliente> buscarClientePorCpf(String cpfCliente) {
        Optional<Cliente> cliente = clienteRepository.findByCpf(cpfCliente);
        return cliente
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public void deletarCliente(Long id) {
        validarCliente(id);
        clienteRepository.deleteById(id);
    }

    public Boolean validarSeClienteAtivo(Long idCliente) {
        Optional<Cliente> c = clienteRepository.findById(idCliente);
        return c.isPresent() && c.get().getAtivo();
    }

    public Boolean validarSenhaCliente(String cpf, String senha) {
        Cliente c = clienteRepository
                .findByCpfAndCodigoConfirmacao(cpf, senha);
        return c != null;
    }

    /**gera uma nova senha de acesso e reenvia para o cliente
     *
     * @param cpf Strinh
     * @return boolean
     */
    public Boolean gerarNovaSenha(String cpf) {
        return null;
    }

}
