package br.com.fiap.fiapfood.core.domain.usecase.usuario;

import br.com.fiap.fiapfood.core.domain.entity.UsuarioDomain;
import br.com.fiap.fiapfood.core.domain.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class BuscarUsuarioPorID {

    private final UsuarioRepository usuarioRepository;

    public BuscarUsuarioPorID(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioDomain call(Long usuarioId) {
        return usuarioRepository.buscarPorId(usuarioId);
    }
}
