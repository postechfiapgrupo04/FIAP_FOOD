package br.com.fiap.fiapfood.domain.gatewayrepository;

import br.com.fiap.fiapfood.domain.entity.UsuarioDomain;

import java.util.List;

public interface UsuarioGatewayRepository {

    public UsuarioDomain salvar(UsuarioDomain usuario);

    public UsuarioDomain buscarPorId(Long id);

    public List<UsuarioDomain> buscarTodos();

    public void apagar(Long id);

    public UsuarioDomain buscarPorCPF(String cpf);
}
