package br.com.fiap.fiapfood.presentation.mapper;

import br.com.fiap.fiapfood.domain.model.UsuarioEntity;
import br.com.fiap.fiapfood.presentation.dto.UsuarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    UsuarioDTO toUsuarioDTO(UsuarioEntity usuarioEntity);

    UsuarioEntity toUsuarioEntity(UsuarioDTO usuarioDTO);
}
