package br.com.fiap.fiapfood.infrastructure.persistence.implementation;

import br.com.fiap.fiapfood.core.domain.entity.UsuarioDomain;
import br.com.fiap.fiapfood.core.domain.repositories.UsuarioRepository;
import br.com.fiap.fiapfood.infrastructure.persistence.model.Usuario;
import br.com.fiap.fiapfood.infrastructure.persistence.repository.UsuarioJPARepository;
import br.com.fiap.fiapfood.presentation.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UsuarioRepositoryImpl implements UsuarioRepository {


    UsuarioJPARepository usuarioJPARepository;

    @Override
    public UsuarioDomain salvar(UsuarioDomain usuario) {
        return UsuarioMapper.INSTANCE.toUsuarioDomain(
                usuarioJPARepository.save(UsuarioMapper.INSTANCE.toUsuarioEntity(usuario)));
    }

    @Override
    public UsuarioDomain buscarPorId(Long id) {
        Optional<Usuario> usuarioEntity = usuarioJPARepository.findById(id);
        if (usuarioEntity.isPresent()) {
            return UsuarioMapper.INSTANCE.toUsuarioDomain(usuarioEntity.get());
        }
        throw new RuntimeException("Usuário não encontrado");
    }

    @Override
    public List<UsuarioDomain> buscarTodos() {
        return usuarioJPARepository.findAll().stream().map(UsuarioMapper.INSTANCE::toUsuarioDomain).toList();
    }

    @Override
    public void apagar(Long id) {
        Optional<Usuario> usuarioEntity = usuarioJPARepository.findById(id);
        if (usuarioEntity.isPresent()) {
            usuarioJPARepository.delete(usuarioEntity.get());
        }
        throw new RuntimeException("Usuário não encontrado");
    }

    @Override
    public UsuarioDomain buscarPorCPF(String cpf) {
        Optional<Usuario> usuarioEntity = usuarioJPARepository.findByCpf(cpf);
        if (usuarioEntity.isPresent()) {
            return UsuarioMapper.INSTANCE.toUsuarioDomain(usuarioEntity.get());
        }
        throw new RuntimeException("Usuário não encontrado");
    }
}
