package br.com.fiap.fiapfood.core.usecase.avaliacao;

import br.com.fiap.fiapfood.core.gateways.AvaliacaoRepository;
import org.springframework.stereotype.Service;

@Service
public class ApagarAvaliacao {

    private final AvaliacaoRepository avaliacaoRepository;

    public ApagarAvaliacao(AvaliacaoRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    }

    public void call(Long avaliacaoId) {
        avaliacaoRepository.apagar(avaliacaoId);
    }
}
