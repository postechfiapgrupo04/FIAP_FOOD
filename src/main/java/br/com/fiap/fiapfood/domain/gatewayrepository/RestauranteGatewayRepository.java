package br.com.fiap.fiapfood.domain.gatewayrepository;

import br.com.fiap.fiapfood.domain.entity.RestauranteDomain;

public interface RestauranteGatewayRepository {

    public RestauranteDomain salvar(RestauranteDomain restaurante);

    public RestauranteDomain buscarPorId(Long id);

    public void apagar(Long id);

    public RestauranteDomain buscarPorNome(String nome);

    public RestauranteDomain buscarPorEndereco(String endereco);

    public RestauranteDomain buscarPorTipoCozinha(String tipoCozinha);

}
