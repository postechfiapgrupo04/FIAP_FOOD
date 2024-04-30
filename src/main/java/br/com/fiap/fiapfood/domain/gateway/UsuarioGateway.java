package br.com.fiap.fiapfood.domain.gateway;

import br.com.fiap.fiapfood.domain.entity.UsuarioDomain;

import java.util.List;

public interface UsuarioGateway {

    public UsuarioDomain salvar(UsuarioDomain usuario);

    public UsuarioDomain buscarPorId(Long id);

    public List<UsuarioDomain> buscarTodos();

    public void apagar(Long id);

    public UsuarioDomain buscarPorCPF(String cpf);
}
