package br.com.fiap.fiapfood.application.usecase;

import br.com.fiap.fiapfood.domain.model.UsuarioEntity;

public interface UsuarioUsecase {

    public UsuarioEntity salvar(UsuarioEntity usuario);

    public UsuarioEntity buscarPorId(String id);

    public void deletar(Long id);

}
