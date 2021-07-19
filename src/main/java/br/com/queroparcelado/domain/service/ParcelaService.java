package br.com.queroparcelado.domain.service;

import br.com.queroparcelado.domain.model.dto.RecebimentosDTO;
import br.com.queroparcelado.domain.model.produto.Parcela;
import br.com.queroparcelado.domain.model.produto.Pedido;
import br.com.queroparcelado.domain.repository.ParcelaRepository;
import br.com.queroparcelado.infraestructure.utils.UtilsQueroParcelado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ParcelaService {

    @Autowired
    private ParcelaRepository repository;

    @Autowired
    private ConfiguracaoService configuracaoService;


    public List<Parcela> gerarParcelas(Pedido pedido) {

        List<Parcela> parcelas = new ArrayList<>();

        for (int i = 1; i <= pedido.getQtdParcela().intValue(); i++) {

            LocalDate localDate = pedido.getDataTransacao().toLocalDate().plusMonths(i);

            Parcela parcela = Parcela.builder()
                    .dataVencimento(localDate)
                    .ordem(i)
                    .pedido(pedido)
                    .valor(pedido.getValorFinal().divide(pedido.getQtdParcela(), 2, RoundingMode.HALF_DOWN))
                    .build();

            parcelas.add(parcela);
        }
        return repository.saveAll(parcelas);
    }

    public RecebimentosDTO filtrarParcelas(Map<String, String> filters) {

        LocalDate dataInicial = UtilsQueroParcelado.converterMilisegundosLocalDate(filters.get("dataInicial"));
        LocalDate dataFinal = UtilsQueroParcelado.converterMilisegundosLocalDate(filters.get("dataFinal"));

        List<Parcela> parcelas = repository.findParcelaByDataVencimentoBetween(dataInicial, dataFinal);


        return RecebimentosDTO.builder()
                .parcelas(parcelas)
                .qtdTotalRecebimentos(new BigInteger(String.valueOf(parcelas.size())))
                .totalAReceber(parcelas.stream().map(Parcela::getValor).reduce(BigDecimal.ZERO, BigDecimal::add))
                .build();
    }
}
