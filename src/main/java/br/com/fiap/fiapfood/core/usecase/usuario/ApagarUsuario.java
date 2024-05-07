package br.com.fiap.fiapfood.core.usecase.usuario;

import br.com.fiap.fiapfood.core.gateways.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class ApagarUsuario {

    private final UsuarioRepository usuarioRepository;

    public ApagarUsuario(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void call(Long usuarioId) {
        usuarioRepository.apagar(usuarioId);
    }
}
