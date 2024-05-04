package br.com.fiap.fiapfood.core.domain.repositories;

import br.com.fiap.fiapfood.core.domain.entity.RestauranteDomain;

public interface RestauranteRepository {

    public RestauranteDomain salvar(RestauranteDomain restaurante);

    public RestauranteDomain buscarPorId(Long id);

    public void apagar(Long id);

    public RestauranteDomain buscarPorNome(String nome);

    public RestauranteDomain buscarPorEndereco(String endereco);

    public RestauranteDomain buscarPorTipoCozinha(String tipoCozinha);

}
