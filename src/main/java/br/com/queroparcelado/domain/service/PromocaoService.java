package br.com.queroparcelado.domain.service;

import br.com.queroparcelado.domain.exception.EntidadeNaoEncontrataException;
import br.com.queroparcelado.domain.model.produto.Promocao;
import br.com.queroparcelado.domain.repository.PromocaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromocaoService {

    @Autowired
    private PromocaoRepository promocaoRepository;


    public Promocao criarPromocao(Promocao promocao) {
        promocao.setCodigo(gerarCodigo());
        return promocaoRepository.save(promocao);
    }

    private String gerarCodigo() {
        StringBuilder codigo = new StringBuilder();
        String[] carct ={"0","1","2","3","4","5","6","7","8","9",
                         "a","b","c","d","e","f","g","h","i","j",
                         "k","l","m","n","p","q","r","s","t","u",
                         "w","x","y","z",};

        for (int i = 0; i <=4; i++){
            int x = (int) (Math.random() * carct.length);
            codigo.append(carct[x]);
        }
        return codigo.toString();
    }

    public void deletar(Long id) {
        if(promocaoRepository.findById(id).isEmpty()){
            throw new EntidadeNaoEncontrataException(String.format("Não foi possivel encontrat a promoção com o id = %d", id));
        }
        promocaoRepository.deleteById(id);
    }
}
