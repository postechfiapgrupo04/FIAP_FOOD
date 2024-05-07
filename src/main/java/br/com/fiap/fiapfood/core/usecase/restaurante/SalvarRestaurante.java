package br.com.fiap.fiapfood.core.usecase.restaurante;

import br.com.fiap.fiapfood.core.entity.RestauranteDomain;
import br.com.fiap.fiapfood.core.gateways.RestauranteRepository;
import org.springframework.stereotype.Service;

@Service
public class SalvarRestaurante {

    private final RestauranteRepository restauranteRepository;

    public SalvarRestaurante(RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }

    public RestauranteDomain call(RestauranteDomain restauranteDomain) {
        return restauranteRepository.salvar(restauranteDomain);
    }
}
