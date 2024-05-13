package br.com.fiap.fiapfood.entrypoint.facade;

import br.com.fiap.fiapfood.entrypoint.api.dto.ReservaDTO;
import br.com.fiap.fiapfood.entrypoint.api.dto.ReservaRequestDTO;

import java.util.List;

public interface ReservaFacade {

    ReservaDTO salvar(ReservaRequestDTO reservaRequestDTO);

    ReservaDTO buscarPorId(Long id);

    void apagar(Long id);

    List<ReservaDTO> buscarPorUsuario(Long usuarioId);
    List<ReservaDTO> buscarPorRestaurante(Long restauranteId);

    List<ReservaDTO> buscarTodos();
}
