package br.com.fiap.fiapfood.core.usecase.avaliacao;
import br.com.fiap.fiapfood.core.entity.AvaliacaoDomain;
import br.com.fiap.fiapfood.core.gateways.AvaliacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarTodasAvaliacaos {

    private final AvaliacaoRepository avaliacaoRepository;

    public BuscarTodasAvaliacaos(AvaliacaoRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    }

    public List<AvaliacaoDomain> call() {
        return avaliacaoRepository.buscarTodos();
    }
}
