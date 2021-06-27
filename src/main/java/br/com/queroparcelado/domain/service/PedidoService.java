package br.com.queroparcelado.domain.service;

import br.com.queroparcelado.core.webConfig.security.QueroParceladoSecurity;
import br.com.queroparcelado.domain.model.Cliente;
import br.com.queroparcelado.domain.model.produto.Pedido;
import br.com.queroparcelado.domain.repository.ClienteRepository;
import br.com.queroparcelado.domain.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ParcelaService parcelaService;

    @Autowired
    private QueroParceladoSecurity queroParceladoSecurity;

    @Transactional(propagation = Propagation.REQUIRED)
    public Pedido salvarPedido(Pedido pedido) {

        Cliente cliente = clienteRepository.findById(queroParceladoSecurity.getUsuarioId())
                .orElseThrow();
        pedido.setCliente(cliente);

         repository.save(pedido);
         pedido.setParcelas(parcelaService.gerarParcelas(pedido));

         return pedido;
    }



}
