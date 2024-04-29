package br.com.fiap.fiapfood.infrastructure;

import br.com.fiap.fiapfood.domain.model.UsuarioDomain;
import br.com.fiap.fiapfood.domain.repository.UsuarioGateway;
import br.com.fiap.fiapfood.infrastructure.persistence.repository.JpaUsuarioRepository;
import br.com.fiap.fiapfood.presentation.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class UsuarioGatewayImpl implements UsuarioGateway {


    JpaUsuarioRepository jpaUsuarioRepository;

    UsuarioMapper usuarioMapper;

    @Override
    public UsuarioDomain salvar(UsuarioDomain usuario) {
        return UsuarioMapper.INSTANCE.toUsuarioDomain(
                jpaUsuarioRepository.save( UsuarioMapper.INSTANCE.toUsuarioEntity(usuario)));
    }

    @Override
    public UsuarioDomain buscarPorId(String id) {
        return null;
    }

    @Override
    public List<UsuarioDomain> findAll() {
        return null;
    }

    @Override
    public void deletar(Long id) {

    }

    @Override
    public UsuarioDomain findByCpf(String cpf) {
        return null;
    }
}
