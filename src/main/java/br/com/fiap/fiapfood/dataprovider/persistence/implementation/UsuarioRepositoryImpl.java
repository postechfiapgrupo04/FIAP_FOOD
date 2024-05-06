package br.com.fiap.fiapfood.dataprovider.persistence.implementation;

import br.com.fiap.fiapfood.core.entity.UsuarioDomain;
import br.com.fiap.fiapfood.core.repositories.UsuarioRepository;
import br.com.fiap.fiapfood.dataprovider.persistence.model.Usuario;
import br.com.fiap.fiapfood.dataprovider.persistence.repository.UsuarioJPARepository;
import br.com.fiap.fiapfood.entrypoint.api.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UsuarioRepositoryImpl implements UsuarioRepository {


    private final UsuarioJPARepository usuarioJPARepository;

    @Override
    public UsuarioDomain salvar(UsuarioDomain usuario) {
        return UsuarioMapper.INSTANCE.toUsuarioDomainFromModel(
                usuarioJPARepository.save(UsuarioMapper.INSTANCE.toUsuarioModelFromDomain(usuario)));
    }

    @Override
    public UsuarioDomain buscarPorId(Long id) {
        Optional<Usuario> usuarioEntity = usuarioJPARepository.findById(id);
        if (usuarioEntity.isPresent()) {
            return UsuarioMapper.INSTANCE.toUsuarioDomainFromModel(usuarioEntity.get());
        }
        throw new RuntimeException("Usuário não encontrado");
    }

    @Override
    public List<UsuarioDomain> buscarTodos() {
        List<Usuario> usuarios = usuarioJPARepository.findAll();
        List<UsuarioDomain> usuarioDomains = usuarios
                .stream()
                .map(UsuarioMapper.INSTANCE::toUsuarioDomainFromModel)
                .toList();
        return usuarioDomains;
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
            return UsuarioMapper.INSTANCE.toUsuarioDomainFromModel(usuarioEntity.get());
        }
        throw new RuntimeException("Usuário não encontrado");
    }
}
