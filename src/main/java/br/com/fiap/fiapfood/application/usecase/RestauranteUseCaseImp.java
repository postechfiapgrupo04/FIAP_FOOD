package br.com.fiap.fiapfood.application.usecase;

import br.com.fiap.fiapfood.domain.entity.RestauranteDomain;
import br.com.fiap.fiapfood.domain.gatewayrepository.RestauranteGatewayRepository;
import br.com.fiap.fiapfood.domain.usecase.RestauranteUsecase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RestauranteUseCaseImp implements RestauranteUsecase {

    private final RestauranteGatewayRepository restauranteGatewayRepository;

    @Override
    public RestauranteDomain salvar(RestauranteDomain restaurante) {
        return restauranteGatewayRepository.salvar(restaurante);
    }

    @Override
    public RestauranteDomain buscarPorId(Long id) {
        return restauranteGatewayRepository.buscarPorId(id);
    }

    @Override
    public void apagar(Long id) {
        restauranteGatewayRepository.apagar(id);
    }

    @Override
    public RestauranteDomain buscarPorNome(String nome) {
        return restauranteGatewayRepository.buscarPorNome(nome);
    }

    @Override
    public RestauranteDomain buscarPorEndereco(String endereco) {
        return restauranteGatewayRepository.buscarPorEndereco(endereco);
    }

    @Override
    public RestauranteDomain buscarPorTipoCozinha(String tipoCozinha) {
        return restauranteGatewayRepository.buscarPorTipoCozinha(tipoCozinha);
    }
}
