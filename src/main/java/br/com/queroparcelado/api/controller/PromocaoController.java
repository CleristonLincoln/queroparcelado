package br.com.queroparcelado.api.controller;

import br.com.queroparcelado.domain.model.produto.Promocao;
import br.com.queroparcelado.domain.repository.PromocaoRepository;
import br.com.queroparcelado.domain.service.PromocaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("promocao")
public class PromocaoController {

    @Autowired
    private PromocaoRepository promocaoRepository;

    @Autowired
    private PromocaoService promocaoService;

    @GetMapping
    public List<Promocao> buscarTodos(){
        return promocaoRepository.findAll();
    }

    @PostMapping
    public Promocao criarPromocao(@Valid @RequestBody Promocao promocao){
     return  promocaoService.criarPromocao(promocao);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPromocao(@PathVariable Long id ){
        promocaoService.deletar(id);
    }

    // TODO: desativar promoçao lancada

}
