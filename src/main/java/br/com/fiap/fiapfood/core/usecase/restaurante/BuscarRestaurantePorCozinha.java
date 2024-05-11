package br.com.fiap.fiapfood.core.usecase.restaurante;

import br.com.fiap.fiapfood.core.entity.RestauranteDomain;
import br.com.fiap.fiapfood.core.enums.TipoCozinha;
import br.com.fiap.fiapfood.core.gateways.RestauranteRepository;
import org.springframework.stereotype.Service;

@Service
public class BuscarRestaurantePorCozinha {

    private final RestauranteRepository restauranteRepository;

    public BuscarRestaurantePorCozinha(RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }

    public RestauranteDomain call(TipoCozinha cozinha) {
        return restauranteRepository.buscarPorTipoCozinha(cozinha);
    }

}
