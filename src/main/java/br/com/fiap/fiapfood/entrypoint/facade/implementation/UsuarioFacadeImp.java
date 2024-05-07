package br.com.fiap.fiapfood.entrypoint.facade.implementation;

import br.com.fiap.fiapfood.core.usecase.usuario.*;
import br.com.fiap.fiapfood.entrypoint.api.dto.UsuarioDTO;
import br.com.fiap.fiapfood.entrypoint.api.mapper.UsuarioMapper;
import br.com.fiap.fiapfood.entrypoint.facade.UsuarioFacade;
import br.com.fiap.fiapfood.core.entity.UsuarioDomain;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioFacadeImp implements UsuarioFacade {

    private final SalvarUsuario salvarUsuario;
    private final BuscarUsuarioPorID buscarUsuarioPorID;
    private final BuscarTodosUsuarios buscarTodosUsuarios;
    private final BuscarUsuarioPorCPF buscarUsuarioPorCPF;
    private final ApagarUsuario apagarUsuario;

    private final UsuarioMapper usuarioMapper;

    public UsuarioFacadeImp(SalvarUsuario salvarUsuario, BuscarUsuarioPorID buscarUsuarioPorID, BuscarTodosUsuarios buscarTodosUsuarios, BuscarUsuarioPorCPF buscarUsuarioPorCPF, ApagarUsuario apagarUsuario, UsuarioMapper usuarioMapper) {
        this.salvarUsuario = salvarUsuario;
        this.buscarUsuarioPorID = buscarUsuarioPorID;
        this.buscarTodosUsuarios = buscarTodosUsuarios;
        this.buscarUsuarioPorCPF = buscarUsuarioPorCPF;
        this.apagarUsuario = apagarUsuario;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public UsuarioDTO salvar(UsuarioDTO usuarioDTO) {
        UsuarioDomain usuarioDomain = usuarioMapper.toUsuarioDomainFromUsuarioDTO(usuarioDTO);
        usuarioDomain = salvarUsuario.call(usuarioDomain);
        return usuarioMapper.toUsuarioDTOFromDomain(usuarioDomain);
    }

    @Override
    public UsuarioDTO buscarPorId(Long id) {
        UsuarioDomain usuarioDomain = buscarUsuarioPorID.call(id);
        return usuarioMapper.toUsuarioDTOFromDomain(usuarioDomain);
    }

    @Override
    public List<UsuarioDTO> buscarTodos() {
        return buscarTodosUsuarios.call().stream()
                .map(usuarioMapper::toUsuarioDTOFromDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void apagar(Long id) {
        apagarUsuario.call(id);
    }

    @Override
    public UsuarioDTO buscarPorCPF(String cpf) {
        UsuarioDomain usuarioDomain = buscarUsuarioPorCPF.call(cpf);
        return usuarioMapper.toUsuarioDTOFromDomain(usuarioDomain);
    }
}
