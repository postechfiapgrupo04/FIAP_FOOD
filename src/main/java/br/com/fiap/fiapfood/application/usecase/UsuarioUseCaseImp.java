package br.com.fiap.fiapfood.application.usecase;

import br.com.fiap.fiapfood.domain.entity.UsuarioDomain;
import br.com.fiap.fiapfood.domain.gateway.UsuarioGateway;
import br.com.fiap.fiapfood.domain.usecase.UsuarioUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UsuarioUseCaseImp implements UsuarioUsecase {

    private final UsuarioGateway usuarioGateway;

    @Override
    public UsuarioDomain salvar(UsuarioDomain usuario) {

        return usuarioGateway.salvar(usuario);
    }

    @Override
    public UsuarioDomain buscarPorId(Long id) {
        return usuarioGateway.buscarPorId(id);
    }

    @Override
    public List<UsuarioDomain> buscarTodos() {

        return usuarioGateway.buscarTodos();
    }

    @Override
    public void apagar(Long id) {

        usuarioGateway.apagar(id);
    }

    @Override
    public UsuarioDomain buscarPorCPF(String cpf) {

        return usuarioGateway.buscarPorCPF(cpf);
    }
}
