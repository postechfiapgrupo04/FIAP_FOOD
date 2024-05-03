package br.com.fiap.fiapfood.presentation.mapper;

import br.com.fiap.fiapfood.domain.entity.RestauranteDomain;
import br.com.fiap.fiapfood.infrastructure.persistence.dbmappers.DBMapperRestaurante;
import br.com.fiap.fiapfood.presentation.dto.RestauranteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestauranteMapper {

    RestauranteMapper INSTANCE = Mappers.getMapper(RestauranteMapper.class);

    DBMapperRestaurante toRestauranteEntity(RestauranteDomain restauranteDomain);

    RestauranteDomain toRestauranteDomain(DBMapperRestaurante DBMapperRestaurante);

    RestauranteDomain toRestauranteDomainFromDTO(RestauranteDTO restauranteDTO);

    RestauranteDTO toRestauranteDTO(RestauranteDomain restauranteDomain);

}
