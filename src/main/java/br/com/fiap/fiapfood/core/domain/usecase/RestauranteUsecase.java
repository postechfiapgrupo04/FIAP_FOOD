package br.com.fiap.fiapfood.core.domain.usecase;

import br.com.fiap.fiapfood.core.domain.entity.RestauranteDomain;

public interface RestauranteUsecase {

    public RestauranteDomain salvar(RestauranteDomain restaurante);

    public RestauranteDomain buscarPorId(Long id);

    public void apagar(Long id);

    public RestauranteDomain buscarPorNome(String nome);

    public RestauranteDomain buscarPorEndereco(String endereco);

    public RestauranteDomain buscarPorTipoCozinha(String tipoCozinha);
}
