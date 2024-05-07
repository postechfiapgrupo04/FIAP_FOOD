package br.com.fiap.fiapfood.core.usecase.usuario;

import br.com.fiap.fiapfood.core.entity.UsuarioDomain;
import br.com.fiap.fiapfood.core.gateways.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarTodosUsuarios {

    private final UsuarioRepository usuarioRepository;

    public BuscarTodosUsuarios(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioDomain> call() {
        return usuarioRepository.buscarTodos();
    }
}
