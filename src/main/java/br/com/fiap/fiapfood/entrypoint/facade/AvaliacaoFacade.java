package br.com.fiap.fiapfood.entrypoint.facade;

import br.com.fiap.fiapfood.entrypoint.api.dto.AvaliacaoDTO;

import java.util.List;

public interface AvaliacaoFacade {

    AvaliacaoDTO salvar(AvaliacaoDTO avaliacao);

    AvaliacaoDTO buscarPorId(Long id);

    List<AvaliacaoDTO> buscarTodos();

    void apagar(Long id);

    AvaliacaoDTO buscarPorNomeRestaurante(String nomeRestaurante);

}
