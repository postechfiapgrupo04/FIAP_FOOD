package br.com.fiap.fiapfood.entrypoint.api.mapper;

import br.com.fiap.fiapfood.core.entity.EnderecoDomain;
import br.com.fiap.fiapfood.core.entity.RestauranteDomain;
import br.com.fiap.fiapfood.core.enums.TipoCozinha;
import br.com.fiap.fiapfood.dataprovider.persistence.model.Restaurante;
import br.com.fiap.fiapfood.entrypoint.api.dto.RestauranteDTO;
import java.time.LocalTime;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-07T21:16:45-0300",
    comments = "version: 1.6.0.Beta1, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 17.0.10 (Azul Systems, Inc.)"
)
public class RestauranteMapperImpl implements RestauranteMapper {

    @Override
    public Restaurante toRestauranteEntity(RestauranteDomain restauranteDomain) {
        if ( restauranteDomain == null ) {
            return null;
        }

        Restaurante restaurante = new Restaurante();

        return restaurante;
    }

    @Override
    public RestauranteDomain toRestauranteDomain(Restaurante Restaurante) {
        if ( Restaurante == null ) {
            return null;
        }

        RestauranteDomain restauranteDomain = new RestauranteDomain();

        return restauranteDomain;
    }

    @Override
    public RestauranteDomain toRestauranteDomainFromDTO(RestauranteDTO restauranteDTO) {
        if ( restauranteDTO == null ) {
            return null;
        }

        RestauranteDomain restauranteDomain = new RestauranteDomain();

        return restauranteDomain;
    }

    @Override
    public RestauranteDTO toRestauranteDTO(RestauranteDomain restauranteDomain) {
        if ( restauranteDomain == null ) {
            return null;
        }

        Long id = null;
        String nome = null;
        EnderecoDomain endereco = null;
        TipoCozinha tipoCozinha = null;
        LocalTime horarioFuncionamentoAbertura = null;
        LocalTime horarioFuncionamentoFechamento = null;
        int capacidade = 0;

        RestauranteDTO restauranteDTO = new RestauranteDTO( id, nome, endereco, tipoCozinha, horarioFuncionamentoAbertura, horarioFuncionamentoFechamento, capacidade );

        return restauranteDTO;
    }
}
