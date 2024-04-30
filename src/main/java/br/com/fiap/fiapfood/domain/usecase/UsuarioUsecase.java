package br.com.fiap.fiapfood.domain.usecase;

import br.com.fiap.fiapfood.domain.entity.UsuarioDomain;

import java.util.List;

public interface UsuarioUsecase {

    public UsuarioDomain salvar(UsuarioDomain usuario);

    public UsuarioDomain buscarPorId(Long id);

    List<UsuarioDomain> buscarTodos();

    public void apagar(Long id);

    UsuarioDomain buscarPorCPF(String cpf);
}
