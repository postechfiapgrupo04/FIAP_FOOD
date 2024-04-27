package br.com.fiap.fiapfood.domain.repository;

import br.com.fiap.fiapfood.domain.model.RestauranteEntity;

public interface RestauranteRepository {

    public RestauranteEntity salvar(RestauranteEntity restaurante);

    public RestauranteEntity buscarPorId(Long id);

    public void deletar(Long id);

    public RestauranteEntity buscarPorNome(String nome);

    public RestauranteEntity buscarPorEndereco(String endereco);

    public RestauranteEntity buscarPorTipoCozinha(String tipoCozinha);

}
