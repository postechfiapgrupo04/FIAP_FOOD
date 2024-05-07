package br.com.fiap.fiapfood.entrypoint.facade;

import br.com.fiap.fiapfood.core.entity.UsuarioDomain;
import br.com.fiap.fiapfood.entrypoint.api.dto.UsuarioDTO;

import java.util.List;

public interface UsuarioFacade {

    UsuarioDTO salvar(UsuarioDTO usuario);

    UsuarioDTO buscarPorId(Long id);

    List<UsuarioDTO> buscarTodos();

    void apagar(Long id);

    UsuarioDTO buscarPorCPF(String cpf);

}
