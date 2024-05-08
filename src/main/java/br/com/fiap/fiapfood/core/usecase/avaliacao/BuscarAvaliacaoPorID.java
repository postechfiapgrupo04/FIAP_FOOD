package br.com.fiap.fiapfood.core.usecase.avaliacao;

import br.com.fiap.fiapfood.core.entity.AvaliacaoDomain;
import br.com.fiap.fiapfood.core.gateways.AvaliacaoRepository;
import org.springframework.stereotype.Service;

@Service
public class BuscarAvaliacaoPorID {
    private final AvaliacaoRepository avaliacaoRepository;

    public BuscarAvaliacaoPorID(AvaliacaoRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    }

    public AvaliacaoDomain call(Long avaliacaoId) {
        return avaliacaoRepository.buscarPorId(avaliacaoId);
    }
}
