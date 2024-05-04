package br.com.fiap.fiapfood.core.domain.usecase.usuario;

import br.com.fiap.fiapfood.core.domain.entity.UsuarioDomain;
import br.com.fiap.fiapfood.core.domain.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class SalvarUsuario {

    private final UsuarioRepository usuarioRepository;

    public SalvarUsuario(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioDomain call(UsuarioDomain usuario) {
        return usuarioRepository.salvar(usuario);
    }
}
