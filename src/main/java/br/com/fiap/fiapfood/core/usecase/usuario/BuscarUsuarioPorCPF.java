package br.com.fiap.fiapfood.core.usecase.usuario;

import br.com.fiap.fiapfood.core.entity.UsuarioDomain;
import br.com.fiap.fiapfood.core.gateways.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class BuscarUsuarioPorCPF {

    private final UsuarioRepository usuarioRepository;

    public BuscarUsuarioPorCPF(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioDomain call(String cpf) {
        return usuarioRepository.buscarPorCPF(cpf);
    }
}
