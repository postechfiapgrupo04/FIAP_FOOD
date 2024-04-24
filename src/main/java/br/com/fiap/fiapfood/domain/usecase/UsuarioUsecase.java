package br.com.fiap.fiapfood.domain.usecase;

import br.com.fiap.fiapfood.domain.entity.UsuarioDomain;

public interface UsuarioUsecase {

    public UsuarioDomain salvar(UsuarioDomain usuario);

    public UsuarioDomain buscarPorId(String id);

    public void deletar(Long id);

}
