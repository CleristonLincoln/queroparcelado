package br.com.queroparcelado.domain.service;

import br.com.queroparcelado.core.webConfig.security.QueroParceladoSecurity;
import br.com.queroparcelado.domain.exception.EntidadeNaoEncontrataException;
import br.com.queroparcelado.domain.exception.NegocioException;
import br.com.queroparcelado.domain.model.Cliente;
import br.com.queroparcelado.domain.model.Configuracao;
import br.com.queroparcelado.domain.model.dto.PedidoDTO;
import br.com.queroparcelado.domain.model.login.Usuario;
import br.com.queroparcelado.domain.model.produto.Pedido;
import br.com.queroparcelado.domain.repository.ClienteRepository;
import br.com.queroparcelado.domain.repository.ConfiguracaoRepository;
import br.com.queroparcelado.domain.repository.PedidoRepository;
import br.com.queroparcelado.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ParcelaService parcelaService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private QueroParceladoSecurity queroParceladoSecurity;

    @Autowired
    private ConfiguracaoRepository configuracaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Pedido salvarPedido(PedidoDTO pedidoDTO) {


        Usuario user = usuarioRepository.findById(pedidoDTO.getIdCliente()).get();

        Cliente cliente = clienteService.getCliente(user.getCliente().getId()).get();

        Configuracao configuracao = configuracaoRepository.findById(pedidoDTO.getFormaRecebimento()).get();

        var pedido = new Pedido();

        pedido.setCliente(cliente);
        pedido.setValorFinal(pedidoDTO.getValorProposta()
                .multiply(configuracao.getTaxaAdministrativa())
                .multiply(configuracao.getTaxaCartao()));
        pedido.setValorProposta(pedidoDTO.getValorProposta());
        pedido.setQtdParcela(pedidoDTO.getQtdParcela());

        pedido.setEndereco(pedidoDTO.getEndereco());
        pedido.setNumero(pedidoDTO.getNumero());
        pedido.setBairro(pedidoDTO.getBairro());
        pedido.setCep(pedidoDTO.getCep());
        pedido.setCidade(pedidoDTO.getCidade());

        pedido.setBanco(pedidoDTO.getBanco());
        pedido.setAgencia(pedidoDTO.getAgencia());
        pedido.setConta(pedidoDTO.getConta());


        try {
            repository.save(pedido);
            parcelaService.gerarParcelas(pedido);
        } catch (Exception e){
            throw new NegocioException("Falga ao salvar pedido!");
        }

         return pedido;
    }



}
