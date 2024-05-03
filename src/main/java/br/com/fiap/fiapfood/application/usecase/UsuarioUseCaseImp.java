package br.com.fiap.fiapfood.application.usecase;

import br.com.fiap.fiapfood.domain.entity.UsuarioDomain;
import br.com.fiap.fiapfood.domain.gatewayrepository.UsuarioGatewayRepository;
import br.com.fiap.fiapfood.domain.usecase.UsuarioUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UsuarioUseCaseImp implements UsuarioUsecase {

    private final UsuarioGatewayRepository usuarioGatewayRepository;

    @Override
    public UsuarioDomain salvar(UsuarioDomain usuario) {

        return usuarioGatewayRepository.salvar(usuario);
    }

    @Override
    public UsuarioDomain buscarPorId(Long id) {
        return usuarioGatewayRepository.buscarPorId(id);
    }

    @Override
    public List<UsuarioDomain> buscarTodos() {

        return usuarioGatewayRepository.buscarTodos();
    }

    @Override
    public void apagar(Long id) {

        usuarioGatewayRepository.apagar(id);
    }

    @Override
    public UsuarioDomain buscarPorCPF(String cpf) {

        return usuarioGatewayRepository.buscarPorCPF(cpf);
    }
}
