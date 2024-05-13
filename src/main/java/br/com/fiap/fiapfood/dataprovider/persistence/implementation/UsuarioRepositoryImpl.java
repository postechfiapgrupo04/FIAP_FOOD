package br.com.fiap.fiapfood.dataprovider.persistence.implementation;

import br.com.fiap.fiapfood.core.entity.UsuarioDomain;
import br.com.fiap.fiapfood.core.exception.NotFoundException;
import br.com.fiap.fiapfood.core.gateways.UsuarioRepository;
import br.com.fiap.fiapfood.dataprovider.persistence.model.Usuario;
import br.com.fiap.fiapfood.dataprovider.persistence.repository.UsuarioJPARepository;
import br.com.fiap.fiapfood.entrypoint.api.mapper.UsuarioMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UsuarioRepositoryImpl implements UsuarioRepository {


    private final UsuarioJPARepository usuarioJPARepository;

    private final UsuarioMapper usuarioMapper;

    @Override
    public UsuarioDomain salvar(UsuarioDomain usuario) {
        return UsuarioMapper.toUsuarioDomainFromModel(
                usuarioJPARepository.save(UsuarioMapper.toUsuarioModelFromDomain(usuario)));
    }

    @Override
    public UsuarioDomain buscarPorId(Long id) {
        Optional<Usuario> usuarioEntity = usuarioJPARepository.findById(id);
        if (usuarioEntity.isPresent()) {
            return UsuarioMapper.toUsuarioDomainFromModel(usuarioEntity.get());
        }
        throw new RuntimeException("Usuário não encontrado");
    }

    @Override
    public List<UsuarioDomain> buscarTodos() {
        List<Usuario> usuarios = usuarioJPARepository.findAll();
        List<UsuarioDomain> usuarioDomains = usuarios
                .stream()
                .map(UsuarioMapper::toUsuarioDomainFromModel)
                .toList();
        return usuarioDomains;
    }

    @Override
    public void apagar(Long id) {
        Optional<Usuario> usuarioEntity = usuarioJPARepository.findById(id);
        usuarioEntity.ifPresentOrElse(usuario -> usuarioJPARepository.deleteById(usuario.getId()), () -> {
            throw new NotFoundException("Usuário não encontrado");
        });
    }

    @Override
    public UsuarioDomain buscarPorCPF(String cpf) {
        Optional<Usuario> usuarioEntity = usuarioJPARepository.findByCpf(cpf);
        if (usuarioEntity.isPresent()) {
            return UsuarioMapper.toUsuarioDomainFromModel(usuarioEntity.get());
        }
        throw new RuntimeException("Usuário não encontrado");
    }
}
