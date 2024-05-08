package br.com.fiap.fiapfood.core.usecase.avaliacao;

import br.com.fiap.fiapfood.core.entity.AvaliacaoDomain;
import br.com.fiap.fiapfood.core.gateways.AvaliacaoRepository;
import org.springframework.stereotype.Service;

@Service
public class BuscarAvaliacaoPorCPF {
    private final AvaliacaoRepository avaliacaoRepository;

    public BuscarAvaliacaoPorCPF(AvaliacaoRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    }

    public AvaliacaoDomain call(String cpf) {
        return avaliacaoRepository.buscarPorCPF(cpf);
    }
}
