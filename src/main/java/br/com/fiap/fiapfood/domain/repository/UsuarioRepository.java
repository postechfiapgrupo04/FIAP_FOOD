package br.com.fiap.fiapfood.domain.repository;

import br.com.fiap.fiapfood.domain.model.UsuarioEntity;

public interface UsuarioRepository {

    public UsuarioEntity salvar(UsuarioEntity usuario);

    public UsuarioEntity buscarPorId(String id);

    public void deletar(Long id);

}
