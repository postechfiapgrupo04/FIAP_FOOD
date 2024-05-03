package br.com.fiap.fiapfood.infrastructure.persistence.implementation;

import br.com.fiap.fiapfood.domain.entity.RestauranteDomain;
import br.com.fiap.fiapfood.domain.gatewayrepository.RestauranteGatewayRepository;
import br.com.fiap.fiapfood.infrastructure.persistence.dbmappers.DBMapperRestaurante;
import br.com.fiap.fiapfood.infrastructure.persistence.repository.RestauranteRepository;
import br.com.fiap.fiapfood.presentation.mapper.RestauranteMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class RestauranteGatewayRepositoryImpl implements RestauranteGatewayRepository {

    private final RestauranteRepository restauranteRepository;

    @Override
    public RestauranteDomain salvar(RestauranteDomain restaurante) {
        return RestauranteMapper.INSTANCE.toRestauranteDomain(
                restauranteRepository.save(
                        RestauranteMapper.INSTANCE.toRestauranteEntity(restaurante)));
    }

    @Override
    public RestauranteDomain buscarPorId(Long id) {
        Optional<DBMapperRestaurante> restauranteEntity = restauranteRepository.findById(id);
        if (restauranteEntity.isPresent()) {
            return RestauranteMapper.INSTANCE.toRestauranteDomain(restauranteEntity.get());
        }
        throw new RuntimeException("Restaurante não encontrado");
    }

    @Override
    public void apagar(Long id) {
        Optional<DBMapperRestaurante> restauranteEntity = restauranteRepository.findById(id);
        if (restauranteEntity.isPresent()) {
            restauranteRepository.delete(restauranteEntity.get());
        }
        throw new RuntimeException("Restaurante não encontrado");
    }

    @Override
    public RestauranteDomain buscarPorNome(String nome) {
        Optional<DBMapperRestaurante> restauranteEntity = restauranteRepository.findByNomeIsLike(nome);
        if (restauranteEntity.isPresent()) {
            return RestauranteMapper.INSTANCE.toRestauranteDomain(restauranteEntity.get());
        }
        throw new RuntimeException("Restaurante não encontrado");
    }

    @Override
    public RestauranteDomain buscarPorEndereco(String endereco) {
        Optional<DBMapperRestaurante> restauranteEntity = restauranteRepository.findByEndereco(endereco);
        if (restauranteEntity.isPresent()) {
            return RestauranteMapper.INSTANCE.toRestauranteDomain(restauranteEntity.get());
        }
        throw new RuntimeException("Restaurante não encontrado");
    }

    @Override
    public RestauranteDomain buscarPorTipoCozinha(String tipoCozinha) {
        Optional<DBMapperRestaurante> restauranteEntity = restauranteRepository.findByTipoCozinha(tipoCozinha);
        if (restauranteEntity.isPresent()) {
            return RestauranteMapper.INSTANCE.toRestauranteDomain(restauranteEntity.get());
        }
        throw new RuntimeException("Restaurante não encontrado");
    }
}
