package br.com.fiap.fiapfood.entrypoint.api.mapper;

import br.com.fiap.fiapfood.core.entity.UsuarioDomain;
import br.com.fiap.fiapfood.dataprovider.persistence.model.Usuario;
import br.com.fiap.fiapfood.entrypoint.api.dto.UsuarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioDTO toUsuarioDTOFromDomain(UsuarioDomain usuarioDomain);

    UsuarioDomain toUsuarioModelFromDomain(UsuarioDTO usuarioDTO);

    UsuarioDomain toUsuarioDomainFromModel(Usuario usuario);

    Usuario toUsuarioModelFromDomain(UsuarioDomain usuarioDomain);

    UsuarioDomain toUsuarioDomainFromUsuarioDTO(UsuarioDTO usuarioDTO);
}
