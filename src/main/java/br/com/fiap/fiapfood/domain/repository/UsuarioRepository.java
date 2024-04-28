package br.com.fiap.fiapfood.domain.repository;

import br.com.fiap.fiapfood.domain.model.UsuarioEntity;

import java.util.List;

public interface UsuarioRepository {

    public UsuarioEntity salvar(UsuarioEntity usuario);

    public UsuarioEntity buscarPorId(String id);

    public List<UsuarioEntity> findAll();

    public void deletar(Long id);

    public UsuarioEntity findByCpf(String cpf);
}
