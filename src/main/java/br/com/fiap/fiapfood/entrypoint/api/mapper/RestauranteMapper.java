package br.com.fiap.fiapfood.entrypoint.api.mapper;

import br.com.fiap.fiapfood.core.entity.RestauranteDomain;
import br.com.fiap.fiapfood.dataprovider.persistence.model.Restaurante;
import br.com.fiap.fiapfood.entrypoint.api.dto.RestauranteDTO;
import org.springframework.stereotype.Service;

@Service
public class RestauranteMapper {

    public static RestauranteDTO toRestauranteDTOFromDomain(RestauranteDomain restauranteDomain) {
        if (restauranteDomain == null) {
            return null;
        }

        return new RestauranteDTO(
                restauranteDomain.getId(),
                restauranteDomain.getNome(),
                EnderecoMapper.toEnderecoDTOFromDomain(restauranteDomain.getEndereco()),
                restauranteDomain.getTipoCozinha(),
                restauranteDomain.getHorarioFuncionamentoAbertura(),
                restauranteDomain.getHorarioFuncionamentoFechamento(),
                restauranteDomain.getCapacidade()
        );

    }

    public static RestauranteDomain toRestauranteDomainFromDTO(RestauranteDTO restauranteDTO) {
        if (restauranteDTO == null) {
            return null;
        }

        return new RestauranteDomain(
                restauranteDTO.id(),
                restauranteDTO.nome(),
                EnderecoMapper.toEnderecoDomainFromDTO(restauranteDTO.endereco()),
                restauranteDTO.tipoCozinha(),
                restauranteDTO.horarioFuncionamentoAbertura(),
                restauranteDTO.horarioFuncionamentoFechamento(),
                restauranteDTO.capacidade()
        );
    }

    public static RestauranteDomain toRestauranteDomainFromModel(Restaurante restaurante) {
        if (restaurante == null) {
            return null;
        }

        return new RestauranteDomain(
                restaurante.getId(),
                restaurante.getNome(),
                EnderecoMapper.toEnderecoDomainFromModel(restaurante.getEndereco()),
                restaurante.getTipoCozinha(),
                restaurante.getHorarioFuncionamentoAbertura(),
                restaurante.getHorarioFuncionamentoFechamento(),
                restaurante.getCapacidade()
        );
    }

    public static Restaurante toRestauranteModelFromDomain(RestauranteDomain restauranteDomain) {
        if (restauranteDomain == null) {
            return null;
        }

        return new Restaurante(
                restauranteDomain.getId(),
                restauranteDomain.getNome(),
                EnderecoMapper.toEnderecoModelFromDomain(restauranteDomain.getEndereco()),
                restauranteDomain.getTipoCozinha(),
                restauranteDomain.getHorarioFuncionamentoAbertura(),
                restauranteDomain.getHorarioFuncionamentoFechamento(),
                restauranteDomain.getCapacidade()
        );
    }
}
