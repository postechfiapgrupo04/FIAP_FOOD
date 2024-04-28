package br.com.fiap.fiapfood.application.usecase.implementation;

import br.com.fiap.fiapfood.application.service.UsuarioRepositoryImp;
import br.com.fiap.fiapfood.application.usecase.UsuarioUsecase;
import br.com.fiap.fiapfood.domain.model.UsuarioEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioUseCaseImp implements UsuarioUsecase {

    private final UsuarioRepositoryImp usuarioRepositoryImp;

    public UsuarioUseCaseImp(UsuarioRepositoryImp usuarioRepositoryImp) {
        this.usuarioRepositoryImp = usuarioRepositoryImp;
    }

    @Override
    public UsuarioEntity salvar(UsuarioEntity usuario) {
        return usuarioRepositoryImp.salvar(usuario);
    }

    @Override
    public UsuarioEntity buscarPorId(String id) {
        return usuarioRepositoryImp.buscarPorId(id);
    }

    @Override
    public List<UsuarioEntity> findAll() {
        return usuarioRepositoryImp.findAll();
    }

    @Override
    public void deletar(Long id) {
        usuarioRepositoryImp.deletar(id);
    }

    @Override
    public UsuarioEntity findByCpf(String cpf) {
        return usuarioRepositoryImp.findByCpf(cpf);
    }
}
