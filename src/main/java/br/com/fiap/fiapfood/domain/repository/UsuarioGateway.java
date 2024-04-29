package br.com.fiap.fiapfood.domain.repository;

import br.com.fiap.fiapfood.domain.model.UsuarioDomain;

import java.util.List;

public interface UsuarioGateway {

    public UsuarioDomain salvar(UsuarioDomain usuario);

    public UsuarioDomain buscarPorId(String id);

    public List<UsuarioDomain> findAll();

    public void deletar(Long id);

    public UsuarioDomain findByCpf(String cpf);
}
