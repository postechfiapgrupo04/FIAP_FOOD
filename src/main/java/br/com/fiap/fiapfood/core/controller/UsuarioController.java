package br.com.fiap.fiapfood.core.controller;

import br.com.fiap.fiapfood.core.domain.entity.UsuarioDomain;

import java.util.List;

public interface UsuarioController {

    UsuarioDomain salvar(UsuarioDomain usuario);

    UsuarioDomain buscarPorId(Long id);

    List<UsuarioDomain> buscarTodos();

    void apagar(Long id);

    UsuarioDomain buscarPorCPF(String cpf);

}
