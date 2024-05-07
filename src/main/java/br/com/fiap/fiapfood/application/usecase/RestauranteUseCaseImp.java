package br.com.fiap.fiapfood.application.usecase;

import br.com.fiap.fiapfood.core.entity.RestauranteDomain;
import br.com.fiap.fiapfood.core.gateways.RestauranteRepository;
import br.com.fiap.fiapfood.core.usecase.RestauranteUsecase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RestauranteUseCaseImp implements RestauranteUsecase {

    private final RestauranteRepository restauranteRepository;

    @Override
    public RestauranteDomain salvar(RestauranteDomain restaurante) {
        return restauranteRepository.salvar(restaurante);
    }

    @Override
    public RestauranteDomain buscarPorId(Long id) {
        return restauranteRepository.buscarPorId(id);
    }

    @Override
    public void apagar(Long id) {
        restauranteRepository.apagar(id);
    }

    @Override
    public RestauranteDomain buscarPorNome(String nome) {
        return restauranteRepository.buscarPorNome(nome);
    }

    @Override
    public RestauranteDomain buscarPorEndereco(String endereco) {
        return restauranteRepository.buscarPorEndereco(endereco);
    }

    @Override
    public RestauranteDomain buscarPorTipoCozinha(String tipoCozinha) {
        return restauranteRepository.buscarPorTipoCozinha(tipoCozinha);
    }
}
