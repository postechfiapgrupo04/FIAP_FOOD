package br.com.fiap.fiapfood.core.gateways;

import br.com.fiap.fiapfood.core.entity.AvaliacaoDomain;

import java.util.List;

public interface AvaliacaoRepository {
    AvaliacaoDomain salvar(AvaliacaoDomain avaliacao);

    AvaliacaoDomain buscarPorId(Long id);

    List<AvaliacaoDomain> buscarTodos();

    void apagar(Long id);

    AvaliacaoDomain buscarPorNomeRestaurante(String nomeRestaurante);
}
