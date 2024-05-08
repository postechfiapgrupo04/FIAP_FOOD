package br.com.fiap.fiapfood.core.usecase.avaliacao;

import br.com.fiap.fiapfood.core.entity.AvaliacaoDomain;
import br.com.fiap.fiapfood.core.gateways.AvaliacaoRepository;
import org.springframework.stereotype.Service;

@Service
public class SalvarAvaliacao {

    private final AvaliacaoRepository avaliacaoRepository;

    public SalvarAvaliacao(AvaliacaoRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    }

    public AvaliacaoDomain call(AvaliacaoDomain avaliacao) {
        return avaliacaoRepository.salvar(avaliacao);
    }
}
