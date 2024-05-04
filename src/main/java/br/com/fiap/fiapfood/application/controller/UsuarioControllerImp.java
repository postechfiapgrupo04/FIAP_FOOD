package br.com.fiap.fiapfood.application.controller;

import br.com.fiap.fiapfood.core.controller.UsuarioController;
import br.com.fiap.fiapfood.core.domain.entity.UsuarioDomain;
import br.com.fiap.fiapfood.core.domain.usecase.usuario.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioControllerImp implements UsuarioController {

    private final SalvarUsuario salvarUsuario;
    private final BuscarUsuarioPorID buscarUsuarioPorID;
    private final BuscarTodosUsuarios buscarTodosUsuarios;
    private final BuscarUsuarioPorCPF buscarUsuarioPorCPF;
    private final ApagarUsuario apagarUsuario;

    public UsuarioControllerImp(SalvarUsuario salvarUsuario, BuscarUsuarioPorID buscarUsuarioPorID, BuscarTodosUsuarios buscarTodosUsuarios, BuscarUsuarioPorCPF buscarUsuarioPorCPF, ApagarUsuario apagarUsuario) {
        this.salvarUsuario = salvarUsuario;
        this.buscarUsuarioPorID = buscarUsuarioPorID;
        this.buscarTodosUsuarios = buscarTodosUsuarios;
        this.buscarUsuarioPorCPF = buscarUsuarioPorCPF;
        this.apagarUsuario = apagarUsuario;
    }

    @Override
    public UsuarioDomain salvar(UsuarioDomain usuario) {
        return salvarUsuario.call(usuario);
    }

    @Override
    public UsuarioDomain buscarPorId(Long id) {
        return buscarUsuarioPorID.call(id);
    }

    @Override
    public List<UsuarioDomain> buscarTodos() {
        return buscarTodosUsuarios.call();
    }

    @Override
    public void apagar(Long id) {
        apagarUsuario.call(id);
    }

    @Override
    public UsuarioDomain buscarPorCPF(String cpf) {
        return buscarPorCPF(cpf);
    }
}
