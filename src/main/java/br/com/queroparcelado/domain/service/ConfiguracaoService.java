package br.com.queroparcelado.domain.service;

import br.com.queroparcelado.domain.exception.EntidadeNaoEncontrataException;
import br.com.queroparcelado.domain.model.Configuracao;
import br.com.queroparcelado.domain.repository.ConfiguracaoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ConfiguracaoService {

    @Autowired
    private ConfiguracaoRepository configuracaoRepository;

    public ResponseEntity<?> salvar(Configuracao configuracao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(configuracaoRepository.save(configuracao));
    }

    public List<Configuracao> buscarTodas() {
        return configuracaoRepository.findAll();
    }

    public Configuracao atualizar(Long id, Configuracao configuracao) {

        Configuracao configuracaoDB = buscar(id);

        BeanUtils.copyProperties(configuracao, configuracaoDB, "id");
        return configuracaoRepository.save(configuracaoDB);

    }

    public Configuracao buscar(Long id) {
        Optional<Configuracao> configuracao = configuracaoRepository.findById(id);

        return configuracao.orElseGet(() -> {
            throw new EntidadeNaoEncontrataException("Configuracao não encontrada");
        });
    }

    public Configuracao atualizarParcial(Long id, Map<String, String> atributos) {

        Configuracao configuracao = buscar(id);

        ObjectMapper objectMapper = new ObjectMapper();

        Configuracao configuracaoDB = objectMapper.convertValue(atributos, Configuracao.class);

        atributos.forEach((k, v) -> {
            Field field = ReflectionUtils.findField(Configuracao.class, k);
            field.setAccessible(true);

            Object valorNovo = ReflectionUtils.getField(field, configuracaoDB);
            ReflectionUtils.setField(field, configuracao, valorNovo);
        });


        return atualizar(id, configuracao);

    }

    public Configuracao buscarPorId(Long id) {
        return  configuracaoRepository.findById(id).get();
    }

    public Configuracao buscarConfiguracaoPelaParcela(BigDecimal qtdParcela){
        return configuracaoRepository.findByQtdParcela(qtdParcela);

    }
}
