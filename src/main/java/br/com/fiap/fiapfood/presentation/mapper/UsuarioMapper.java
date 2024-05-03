package br.com.fiap.fiapfood.presentation.mapper;

import br.com.fiap.fiapfood.domain.entity.UsuarioDomain;
import br.com.fiap.fiapfood.infrastructure.persistence.dbmappers.DBMapperUsuario;
import br.com.fiap.fiapfood.presentation.dto.UsuarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    UsuarioDTO toUsuarioDTO(UsuarioDomain usuarioDomain);

    UsuarioDomain toUsuarioEntity(UsuarioDTO usuarioDTO);

    UsuarioDomain toUsuarioDomain(DBMapperUsuario DBMapperUsuario);

    DBMapperUsuario toUsuarioEntity(UsuarioDomain usuarioDomain);
}
