package br.com.queroparcelado.api.controller;

import br.com.queroparcelado.domain.model.dto.PedidoDTO;
import br.com.queroparcelado.domain.model.produto.Pedido;
import br.com.queroparcelado.domain.repository.PedidoRepository;
import br.com.queroparcelado.domain.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

import static br.com.queroparcelado.infraestructure.spec.VendaClienteSpecs.valorAVista;

@RestController
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PedidoService pedidoService;


    @GetMapping
    public List<Pedido> buscarTodos() {
        return pedidoRepository.findAll();
    }

    @GetMapping("filtrar-por-taxa")
    public List<Pedido> filtrarPorTaxa(BigDecimal taxaInicial, BigDecimal taxaFinal) {
        return pedidoRepository.filtrarPorTaxaAdministrativa(taxaInicial, taxaFinal);
    }

    @GetMapping("filtrar-por-cliente/{idCliente}")
    public List<Pedido> filtrarPorCliente(@PathVariable Long idCliente) {
        return pedidoRepository.findByClienteId(idCliente);
    }

    @PreAuthorize("permitAll()")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido salvarPedido(@Valid @RequestBody PedidoDTO pedidoDTO) {
        return pedidoService.salvarPedido(pedidoDTO);
    }

    @GetMapping("clientes-pagamento-a-vista")
    public List<Pedido> clientesParcelamentoAVista() {
        return pedidoRepository.findAll(valorAVista());
    }

}
