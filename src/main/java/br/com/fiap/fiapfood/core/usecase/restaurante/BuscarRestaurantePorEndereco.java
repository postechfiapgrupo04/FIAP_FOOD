package br.com.fiap.fiapfood.core.usecase.restaurante;

import br.com.fiap.fiapfood.core.entity.RestauranteDomain;
import br.com.fiap.fiapfood.core.gateways.RestauranteRepository;
import org.springframework.stereotype.Service;

@Service
public class BuscarRestaurantePorEndereco {

    private final RestauranteRepository restauranteRepository;

    public BuscarRestaurantePorEndereco(RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }

    public RestauranteDomain call(String endereco) {
        return restauranteRepository.buscarPorEndereco(endereco);
    }

}
