package br.com.queroparcelado.api.controller;

import br.com.queroparcelado.domain.model.Configuracao;
import br.com.queroparcelado.domain.service.ConfiguracaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("configuracao")
public class ConfiguracaoController {

    @Autowired
    private ConfiguracaoService configuracaoService;

    @PreAuthorize("permitAll()")
    @GetMapping
    public List<Configuracao> listarConfiguracoes(){
        return configuracaoService.buscarTodas();
    }

    @GetMapping("{id}")
    public Configuracao buscarporId(@PathVariable Long id){
        return configuracaoService.buscarPorId(id);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<?> salvar(@Valid @RequestBody Configuracao configuracao){
        return configuracaoService.salvar(configuracao);
    }

    @PutMapping("{id}")
    public Configuracao atualizar(@PathVariable Long id, @RequestBody Configuracao configuracao){
        return configuracaoService.atualizar(id, configuracao);
    }

    @PatchMapping("{id}")
    public Configuracao atualizarParcial(@PathVariable Long id, @RequestParam Map<String, String> atributos){
            return configuracaoService.atualizarParcial(id, atributos);
    }


}
