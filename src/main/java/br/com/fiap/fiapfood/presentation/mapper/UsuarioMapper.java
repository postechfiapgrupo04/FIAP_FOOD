package br.com.fiap.fiapfood.presentation.mapper;

import br.com.fiap.fiapfood.core.domain.entity.UsuarioDomain;
import br.com.fiap.fiapfood.infrastructure.persistence.model.Usuario;
import br.com.fiap.fiapfood.presentation.dto.UsuarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioMapper {

    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "cpf", target = "cpf")
    @Mapping(source = "reservas", target = "reservas")
    UsuarioDTO toUsuarioDTOFromDomain(UsuarioDomain usuarioDomain);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "cpf", target = "cpf")
    @Mapping(source = "reservas", target = "reservas")
    UsuarioDomain toUsuarioModelFromDomain(UsuarioDTO usuarioDTO);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "cpf", target = "cpf")
    @Mapping(source = "reservas", target = "reservas")
    UsuarioDomain toUsuarioDomainFromModel(Usuario usuario);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "cpf", target = "cpf")
    @Mapping(source = "reservas", target = "reservas")
    Usuario toUsuarioModelFromDomain(UsuarioDomain usuarioDomain);
}
