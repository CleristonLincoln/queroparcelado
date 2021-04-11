package br.com.queroparcelado.domain.service;

import br.com.queroparcelado.domain.exception.EntidadeNaoEncontrataException;
import br.com.queroparcelado.domain.exception.JaExisteException;
import br.com.queroparcelado.domain.exception.NegocioException;
import br.com.queroparcelado.domain.model.Cliente;
import br.com.queroparcelado.domain.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public List<Cliente> buscarClientes() {
        return clienteRepository.findAll();
    }

    public ResponseEntity<Cliente> buscarCliente(Long idCliente) {

        Optional<Cliente> cliente = clienteRepository.findById(idCliente);

        if (cliente.isEmpty()) {
            throw new EntidadeNaoEncontrataException(String.format("Cliente não encontrato com o código %d", idCliente));
        }
        return ResponseEntity.ok(cliente.get());
    }


    public Cliente salvar(Cliente cliente) {

        validarClienteJaExist(cliente);

        return clienteRepository.save(cliente);
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
        Optional<Cliente> cliente = clienteRepository.findById(idCliente);
        if (cliente.isEmpty()) {
            throw new EntidadeNaoEncontrataException(String.format("Cliente não encontrato com o código %d", idCliente));
        }
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

}
