package br.com.fiap.fiapfood.application.service;

import br.com.fiap.fiapfood.domain.model.UsuarioEntity;
import br.com.fiap.fiapfood.domain.repository.UsuarioRepository;
import br.com.fiap.fiapfood.infrastructure.persistence.JpaUsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioRepositoryImp implements UsuarioRepository {

    private final JpaUsuarioRepository jpaUsuarioRepository;

    public UsuarioRepositoryImp(JpaUsuarioRepository jpaUsuarioRepository) {
        this.jpaUsuarioRepository = jpaUsuarioRepository;
    }

    @Override
    public UsuarioEntity salvar(UsuarioEntity usuario) {
        return jpaUsuarioRepository.save(usuario);
    }

    @Override
    public UsuarioEntity buscarPorId(String id) {

        Optional<UsuarioEntity> usuario = jpaUsuarioRepository.findById(Long.parseLong(id));
        if (usuario.isPresent()) {
            return usuario.get();
        }
        throw new RuntimeException("Usuário não encontrado");

    }

    @Override
    public List<UsuarioEntity> findAll() {
        List<UsuarioEntity> usuarioEntityList = jpaUsuarioRepository.findAll();
        return usuarioEntityList;
    }

    @Override
    public void deletar(Long id) {

        Optional<UsuarioEntity> usuario = jpaUsuarioRepository.findById(id);
        if (usuario.isPresent()) {
            jpaUsuarioRepository.delete(usuario.get());
            return;
        }
        usuario.ifPresent(jpaUsuarioRepository::delete);
        throw new RuntimeException("Usuário não encontrado");

    }

    @Override
    public UsuarioEntity findByCpf(String cpf) {
        return jpaUsuarioRepository.findByCpf(cpf);
    }


}
