package br.com.fiap.fiapfood.core.gateways;

import br.com.fiap.fiapfood.core.entity.UsuarioDomain;

import java.util.List;

public interface UsuarioRepository {

    UsuarioDomain salvar(UsuarioDomain usuario);

    UsuarioDomain buscarPorId(Long id);

    List<UsuarioDomain> buscarTodos();

    void apagar(Long id);

    UsuarioDomain buscarPorCPF(String cpf);
}
