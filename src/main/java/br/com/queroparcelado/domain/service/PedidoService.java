package br.com.queroparcelado.domain.service;

import br.com.queroparcelado.core.webConfig.security.QueroParceladoSecurity;
import br.com.queroparcelado.domain.exception.EntidadeNaoEncontrataException;
import br.com.queroparcelado.domain.exception.NegocioException;
import br.com.queroparcelado.domain.model.Cliente;
import br.com.queroparcelado.domain.model.Configuracao;
import br.com.queroparcelado.domain.model.dto.PedidoDTO;
import br.com.queroparcelado.domain.model.produto.Pedido;
import br.com.queroparcelado.domain.repository.ClienteRepository;
import br.com.queroparcelado.domain.repository.ConfiguracaoRepository;
import br.com.queroparcelado.domain.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    public Pedido salvarPedido(PedidoDTO pedidoDTO) {

        Cliente cliente = clienteService.getCliente(queroParceladoSecurity.getUsuarioId()).get();

        Optional<Configuracao> configuracao = configuracaoRepository.findById(pedidoDTO.getFormaRecebimento());

        Pedido pedido = new Pedido().builder()
                .valorFinal(pedidoDTO.getValorProposta()
                        .multiply(configuracao.get().getTaxaAdministrativa())
                        .multiply(configuracao.get().getTaxaCartao())
                )
                .valorProposta(pedidoDTO.getValorProposta())
                .qtdParcela(configuracao.get().getQtdParcela())

                .endereco(pedidoDTO.getEndereco())
                .numero(pedidoDTO.getNumero())
                .bairro(pedidoDTO.getBairro())
                .cep(pedidoDTO.getCep())
                .cidade(pedidoDTO.getCidade())

                .banco(pedidoDTO.getBanco())
                .agencia(pedidoDTO.getAgencia())
                .conta(pedidoDTO.getConta())
                .cliente(cliente)
                .build();


         repository.save(pedido);
         pedido.setParcelas(parcelaService.gerarParcelas(pedido));

         return pedido;
    }



}
