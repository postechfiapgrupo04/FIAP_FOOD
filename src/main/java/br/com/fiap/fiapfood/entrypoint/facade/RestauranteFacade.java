package br.com.fiap.fiapfood.entrypoint.facade;

import br.com.fiap.fiapfood.core.enums.TipoCozinha;
import br.com.fiap.fiapfood.entrypoint.api.dto.RestauranteDTO;

public interface RestauranteFacade {

    RestauranteDTO salvar(RestauranteDTO restaurante);

    RestauranteDTO buscarPorId(Long id);

    void apagar(Long id);

    RestauranteDTO buscarPorNome(String nome);

    RestauranteDTO buscarPorEndereco(String endereco);

    RestauranteDTO buscarPorTipoCozinha(TipoCozinha tipoCozinha);

}
