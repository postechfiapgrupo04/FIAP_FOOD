package br.com.fiap.fiapfood.domain.usecase;

import br.com.fiap.fiapfood.domain.model.UsuarioDomain;

import java.util.List;

public interface UsuarioUsecase {

    public UsuarioDomain salvar(UsuarioDomain usuario);

    public UsuarioDomain buscarPorId(String id);

    List<UsuarioDomain> findAll();

    public void deletar(Long id);

    UsuarioDomain findByCpf(String cpf);
}
