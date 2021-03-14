package br.com.queroparcelado.api.controller;

import br.com.queroparcelado.domain.model.VendaCliente;
import br.com.queroparcelado.domain.repository.VendaClienteRepository;
import br.com.queroparcelado.domain.service.VendaClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

import static br.com.queroparcelado.infraestructure.spec.VendaClienteSpecs.valorAVista;

@RestController
@RequestMapping("vendacliente")
public class VendaClienteController {

    @Autowired
    private VendaClienteRepository vendaClienteRepository;

    @Autowired
    private VendaClienteService vendaClienteService;

    @GetMapping("filtrar-por-taxa")
    public List<VendaCliente> filtrarPorTaxa(BigDecimal taxaInicial, BigDecimal taxaFinal) {
        return vendaClienteRepository.filtrarPorTaxa(taxaInicial, taxaFinal);
    }

    @PostMapping
    public ResponseEntity<VendaCliente> salvarVenda(@Valid @RequestBody VendaCliente vendaCliente) {
        return vendaClienteService.salvarVendaCliente(vendaCliente);
    }

    @GetMapping("clientes-pagamento-a-vista")
    public List<VendaCliente> clientesParcelamentoAVista() {
        return vendaClienteRepository.findAll(valorAVista());
    }

}
