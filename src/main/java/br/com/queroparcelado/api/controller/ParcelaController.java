package br.com.queroparcelado.api.controller;

import br.com.queroparcelado.domain.model.dto.RecebimentosDTO;
import br.com.queroparcelado.domain.model.produto.Parcela;
import br.com.queroparcelado.domain.repository.ParcelaRepository;
import br.com.queroparcelado.domain.service.ParcelaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("parcela")
public class ParcelaController {

    @Autowired
    private ParcelaRepository repository;

    @Autowired
    private ParcelaService service;

    @GetMapping
    public List<Parcela> buscarParcela(){
        return repository.findAll();
    }

    @GetMapping("filtrar-parcelas")
    public RecebimentosDTO buscarParcela(@RequestParam Map<String, String> filters) {
        return service.filtrarParcelas(filters);
    }



}
