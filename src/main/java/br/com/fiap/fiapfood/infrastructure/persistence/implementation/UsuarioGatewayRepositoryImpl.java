package br.com.fiap.fiapfood.infrastructure.persistence.implementation;

import br.com.fiap.fiapfood.domain.entity.UsuarioDomain;
import br.com.fiap.fiapfood.domain.gatewayrepository.UsuarioGatewayRepository;
import br.com.fiap.fiapfood.infrastructure.persistence.dbmappers.DBMapperUsuario;
import br.com.fiap.fiapfood.infrastructure.persistence.repository.UsuarioRepository;
import br.com.fiap.fiapfood.presentation.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UsuarioGatewayRepositoryImpl implements UsuarioGatewayRepository {


    UsuarioRepository usuarioRepository;

    @Override
    public UsuarioDomain salvar(UsuarioDomain usuario) {
        return UsuarioMapper.INSTANCE.toUsuarioDomain(
                usuarioRepository.save(UsuarioMapper.INSTANCE.toUsuarioEntity(usuario)));
    }

    @Override
    public UsuarioDomain buscarPorId(Long id) {
        Optional<DBMapperUsuario> usuarioEntity = usuarioRepository.findById(id);
        if (usuarioEntity.isPresent()) {
            return UsuarioMapper.INSTANCE.toUsuarioDomain(usuarioEntity.get());
        }
        throw new RuntimeException("Usuário não encontrado");
    }

    @Override
    public List<UsuarioDomain> buscarTodos() {
        return usuarioRepository.findAll().stream().map(UsuarioMapper.INSTANCE::toUsuarioDomain).toList();
    }

    @Override
    public void apagar(Long id) {
        Optional<DBMapperUsuario> usuarioEntity = usuarioRepository.findById(id);
        if (usuarioEntity.isPresent()) {
            usuarioRepository.delete(usuarioEntity.get());
        }
        throw new RuntimeException("Usuário não encontrado");
    }

    @Override
    public UsuarioDomain buscarPorCPF(String cpf) {
        Optional<DBMapperUsuario> usuarioEntity = usuarioRepository.findByCpf(cpf);
        if (usuarioEntity.isPresent()) {
            return UsuarioMapper.INSTANCE.toUsuarioDomain(usuarioEntity.get());
        }
        throw new RuntimeException("Usuário não encontrado");
    }
}
