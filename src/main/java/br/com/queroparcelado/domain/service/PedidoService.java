package br.com.queroparcelado.domain.service;

import br.com.queroparcelado.domain.model.produto.Pedido;
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
    private ParcelaService parcelaService;


    @Transactional(propagation = Propagation.REQUIRED)
    public Pedido salvarPedido(Pedido pedido) {

         repository.save(pedido);
         pedido.setParcelas(parcelaService.gerarParcelas(pedido));

         return pedido;
    }



}
