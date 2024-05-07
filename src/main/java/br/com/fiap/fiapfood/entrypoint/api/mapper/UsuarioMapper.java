package br.com.fiap.fiapfood.entrypoint.api.mapper;

import br.com.fiap.fiapfood.core.entity.UsuarioDomain;
import br.com.fiap.fiapfood.dataprovider.persistence.model.Usuario;
import br.com.fiap.fiapfood.entrypoint.api.dto.UsuarioDTO;
import org.springframework.stereotype.Service;

@Service
public class UsuarioMapper {

    public static UsuarioDTO toUsuarioDTOFromDomain(UsuarioDomain usuarioDomain) {
        if (usuarioDomain == null) {
            return null;
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO(
                usuarioDomain.getId(),
                usuarioDomain.getNome(),
                usuarioDomain.getEmail(),
                usuarioDomain.getCpf(),
                null);

        return usuarioDTO;
    }

    public static UsuarioDomain toUsuarioDomainFromDTO(UsuarioDTO usuarioDTO) {
        if (usuarioDTO == null) {
            return null;
        }

        UsuarioDomain usuarioDomain = new UsuarioDomain(
                usuarioDTO.getId(),
                usuarioDTO.getNome(),
                usuarioDTO.getEmail(),
                usuarioDTO.getCpf(),
                null);

        return usuarioDomain;
    }

    public static UsuarioDomain toUsuarioDomainFromModel(Usuario usuario) {
        if (usuario == null) {
            return null;
        }

        UsuarioDomain usuarioDomain = new UsuarioDomain(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getCpf(), null);

        return usuarioDomain;
    }

    public static Usuario toUsuarioModelFromDomain(UsuarioDomain usuarioDomain) {
        if (usuarioDomain == null) {
            return null;
        }

        Usuario usuario = new Usuario(
                usuarioDomain.getId(),
                usuarioDomain.getNome(),
                usuarioDomain.getEmail(),
                usuarioDomain.getCpf(),
                null);

        return usuario;
    }
}
