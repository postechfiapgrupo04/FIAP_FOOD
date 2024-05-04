package br.com.fiap.fiapfood.presentation.mapper;

import br.com.fiap.fiapfood.core.domain.entity.RestauranteDomain;
import br.com.fiap.fiapfood.infrastructure.persistence.model.Restaurante;
import br.com.fiap.fiapfood.presentation.dto.RestauranteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestauranteMapper {

    RestauranteMapper INSTANCE = Mappers.getMapper(RestauranteMapper.class);

    Restaurante toRestauranteEntity(RestauranteDomain restauranteDomain);

    RestauranteDomain toRestauranteDomain(Restaurante Restaurante);

    RestauranteDomain toRestauranteDomainFromDTO(RestauranteDTO restauranteDTO);

    RestauranteDTO toRestauranteDTO(RestauranteDomain restauranteDomain);

}
