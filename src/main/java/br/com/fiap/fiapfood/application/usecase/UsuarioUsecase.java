package br.com.fiap.fiapfood.application.usecase;

import br.com.fiap.fiapfood.domain.model.UsuarioEntity;
import br.com.fiap.fiapfood.presentation.dto.UsuarioDTO;

import java.util.List;

public interface UsuarioUsecase {

    public UsuarioEntity salvar(UsuarioEntity usuario);

    public UsuarioEntity buscarPorId(String id);

    List<UsuarioEntity> findAll();

    public void deletar(Long id);

    UsuarioEntity findByCpf(String cpf);
}
