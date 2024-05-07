package br.com.fiap.fiapfood.entrypoint.api.mapper;

import br.com.fiap.fiapfood.core.entity.UsuarioDomain;
import br.com.fiap.fiapfood.dataprovider.persistence.model.Usuario;
import br.com.fiap.fiapfood.entrypoint.api.dto.UsuarioDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    UsuarioDTO toUsuarioDTOFromDomain(UsuarioDomain usuarioDomain);

    UsuarioDomain toUsuarioDomainFromDTO(UsuarioDTO usuarioDTO);

    UsuarioDomain toUsuarioDomainFromModel(Usuario usuario);

    Usuario toUsuarioModelFromDomain(UsuarioDomain usuarioDomain);

}
