package br.com.fiap.fiapfood.core.gateways;

import br.com.fiap.fiapfood.core.entity.RestauranteDomain;
import br.com.fiap.fiapfood.core.enums.TipoCozinha;

public interface RestauranteRepository {

    RestauranteDomain salvar(RestauranteDomain restaurante);

    RestauranteDomain buscarPorId(Long id);

    void apagar(Long id);

    RestauranteDomain buscarPorNome(String nome);

    RestauranteDomain buscarPorEndereco(String endereco);

    RestauranteDomain buscarPorTipoCozinha(TipoCozinha tipoCozinha);

}
