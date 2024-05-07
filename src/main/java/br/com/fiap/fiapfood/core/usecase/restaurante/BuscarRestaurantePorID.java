package br.com.fiap.fiapfood.core.usecase.restaurante;

import br.com.fiap.fiapfood.core.entity.RestauranteDomain;
import br.com.fiap.fiapfood.core.gateways.RestauranteRepository;
import org.springframework.stereotype.Service;

@Service
public class BuscarRestaurantePorID {

    private final RestauranteRepository restauranteRepository;

    public BuscarRestaurantePorID(RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }

    public RestauranteDomain call(Long restauranteId) {
        return restauranteRepository.buscarPorId(restauranteId);
    }

}
