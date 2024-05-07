package br.com.fiap.fiapfood.core.usecase.restaurante;

import br.com.fiap.fiapfood.core.entity.RestauranteDomain;
import br.com.fiap.fiapfood.core.gateways.RestauranteRepository;
import org.springframework.stereotype.Service;

@Service
public class ApagarRestaurante {

    private final RestauranteRepository restauranteRepository;

    public ApagarRestaurante(RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }

    public void call(Long restauranteId) {
        restauranteRepository.apagar(restauranteId);
    }

}
