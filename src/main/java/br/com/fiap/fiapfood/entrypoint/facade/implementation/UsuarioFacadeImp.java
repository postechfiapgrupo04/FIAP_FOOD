package br.com.fiap.fiapfood.entrypoint.facade.implementation;

import br.com.fiap.fiapfood.core.usecase.usuario.*;
import br.com.fiap.fiapfood.entrypoint.api.dto.UsuarioDTO;
import br.com.fiap.fiapfood.entrypoint.api.mapper.UsuarioMapper;
import br.com.fiap.fiapfood.entrypoint.facade.UsuarioFacade;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioFacadeImp implements UsuarioFacade {

    private final SalvarUsuario salvarUsuario;
    private final BuscarUsuarioPorID buscarUsuarioPorID;
    private final BuscarTodosUsuarios buscarTodosUsuarios;
    private final BuscarUsuarioPorCPF buscarUsuarioPorCPF;
    private final ApagarUsuario apagarUsuario;

    public UsuarioFacadeImp(SalvarUsuario salvarUsuario, BuscarUsuarioPorID buscarUsuarioPorID, BuscarTodosUsuarios buscarTodosUsuarios, BuscarUsuarioPorCPF buscarUsuarioPorCPF, ApagarUsuario apagarUsuario) {
        this.salvarUsuario = salvarUsuario;
        this.buscarUsuarioPorID = buscarUsuarioPorID;
        this.buscarTodosUsuarios = buscarTodosUsuarios;
        this.buscarUsuarioPorCPF = buscarUsuarioPorCPF;
        this.apagarUsuario = apagarUsuario;
    }


    @Override
    public UsuarioDTO salvar(UsuarioDTO usuarioDTO) {
        return UsuarioMapper.toUsuarioDTOFromDomain(
                salvarUsuario.call(
                        UsuarioMapper.toUsuarioDomainFromDTO(usuarioDTO)));
    }

    @Override
    public UsuarioDTO buscarPorId(Long id) {
        return UsuarioMapper.toUsuarioDTOFromDomain(buscarUsuarioPorID.call(id));
    }

    @Override
    public List<UsuarioDTO> buscarTodos() {
        return buscarTodosUsuarios.call().stream()
                .map(UsuarioMapper::toUsuarioDTOFromDomain)
                .toList();
    }

    @Override
    public void apagar(Long id) {
        apagarUsuario.call(id);
    }

    @Override
    public UsuarioDTO buscarPorCPF(String cpf) {
        return UsuarioMapper.toUsuarioDTOFromDomain(buscarUsuarioPorCPF.call(cpf));
    }
}
