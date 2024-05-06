package br.com.fiap.fiapfood.entrypoint.facade;

import br.com.fiap.fiapfood.core.entity.UsuarioDomain;

import java.util.List;

public interface UsuarioFacade {

    UsuarioDomain salvar(UsuarioDomain usuario);

    UsuarioDomain buscarPorId(Long id);

    List<UsuarioDomain> buscarTodos();

    void apagar(Long id);

    UsuarioDomain buscarPorCPF(String cpf);

}
