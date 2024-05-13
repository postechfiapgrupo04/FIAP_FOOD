package br.com.fiap.fiapfood.entrypoint.facade.implementation;

import br.com.fiap.fiapfood.core.enums.TipoCozinha;
import br.com.fiap.fiapfood.core.usecase.restaurante.*;
import br.com.fiap.fiapfood.entrypoint.api.dto.RestauranteDTO;
import br.com.fiap.fiapfood.entrypoint.api.mapper.RestauranteMapper;
import br.com.fiap.fiapfood.entrypoint.facade.RestauranteFacade;
import org.springframework.stereotype.Component;

@Component
public class RestauranteFacadeImp implements RestauranteFacade {

    private final SalvarRestaurante salvarRestaurante;
    private final BuscarRestaurantePorID buscarRestaurantePorID;
    private final BuscarRestaurantePorNome buscarRestaurantePorNome;
    private final BuscarRestaurantePorEndereco buscarRestaurantePorEndereco;
    private final BuscarRestaurantePorCozinha buscarRestaurantePorCozinha;
    private final ApagarRestaurante apagarRestaurante;

    public RestauranteFacadeImp(SalvarRestaurante salvarRestaurante, BuscarRestaurantePorID buscarRestaurantePorID, BuscarRestaurantePorNome buscarRestaurantePorNome, BuscarRestaurantePorEndereco buscarRestaurantePorEndereco, BuscarRestaurantePorCozinha buscarRestaurantePorCozinha, ApagarRestaurante apagarRestaurante) {
        this.salvarRestaurante = salvarRestaurante;
        this.buscarRestaurantePorID = buscarRestaurantePorID;
        this.buscarRestaurantePorNome = buscarRestaurantePorNome;
        this.buscarRestaurantePorEndereco = buscarRestaurantePorEndereco;
        this.buscarRestaurantePorCozinha = buscarRestaurantePorCozinha;
        this.apagarRestaurante = apagarRestaurante;
    }


    @Override
    public RestauranteDTO salvar(RestauranteDTO restaurante) {
        return RestauranteMapper.toRestauranteDTOFromDomain(
                salvarRestaurante.call(
                        RestauranteMapper.toRestauranteDomainFromDTO(restaurante)));
    }

    @Override
    public RestauranteDTO buscarPorId(Long id) {
        return RestauranteMapper.toRestauranteDTOFromDomain(buscarRestaurantePorID.call(id));
    }

    @Override
    public void apagar(Long id) {
        apagarRestaurante.call(id);
    }

    @Override
    public RestauranteDTO buscarPorNome(String nome) {
        return RestauranteMapper.toRestauranteDTOFromDomain(buscarRestaurantePorNome.call(nome));
    }

    @Override
    public RestauranteDTO buscarPorEndereco(String endereco) {
        return RestauranteMapper.toRestauranteDTOFromDomain(buscarRestaurantePorEndereco.call(endereco));
    }

    @Override
    public RestauranteDTO buscarPorTipoCozinha(TipoCozinha tipoCozinha) {
        return RestauranteMapper.toRestauranteDTOFromDomain(buscarRestaurantePorCozinha.call(tipoCozinha));
    }
}
