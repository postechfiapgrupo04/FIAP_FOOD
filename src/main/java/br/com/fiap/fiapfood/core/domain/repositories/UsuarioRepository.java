package br.com.fiap.fiapfood.core.domain.repositories;

import br.com.fiap.fiapfood.core.domain.entity.UsuarioDomain;

import java.util.List;

public interface UsuarioRepository {

    public UsuarioDomain salvar(UsuarioDomain usuario);

    public UsuarioDomain buscarPorId(Long id);

    public List<UsuarioDomain> buscarTodos();

    public void apagar(Long id);

    public UsuarioDomain buscarPorCPF(String cpf);
}
