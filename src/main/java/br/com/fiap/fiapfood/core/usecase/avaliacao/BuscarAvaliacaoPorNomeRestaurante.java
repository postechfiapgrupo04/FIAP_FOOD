package br.com.fiap.fiapfood.core.usecase.avaliacao;

import br.com.fiap.fiapfood.core.entity.AvaliacaoDomain;
import br.com.fiap.fiapfood.core.gateways.AvaliacaoRepository;
import org.springframework.stereotype.Service;

@Service
public class BuscarAvaliacaoPorNomeRestaurante {
    private final AvaliacaoRepository avaliacaoRepository;

    public BuscarAvaliacaoPorNomeRestaurante(AvaliacaoRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    }

    public AvaliacaoDomain call(String nomeRestaurante) {
        return avaliacaoRepository.buscarPorNomeRestaurante(nomeRestaurante);
    }
}
