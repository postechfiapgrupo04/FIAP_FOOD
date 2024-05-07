package br.com.fiap.fiapfood.dataprovider.persistence.implementation;

import br.com.fiap.fiapfood.core.entity.RestauranteDomain;
import br.com.fiap.fiapfood.core.gateways.RestauranteRepository;
import br.com.fiap.fiapfood.dataprovider.persistence.model.Restaurante;
import br.com.fiap.fiapfood.dataprovider.persistence.repository.RestauranteJPARepository;
import br.com.fiap.fiapfood.entrypoint.api.mapper.RestauranteMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class RestauranteRepositoryImpl implements RestauranteRepository {

    private final RestauranteJPARepository restauranteJPARepository;

    @Override
    public RestauranteDomain salvar(RestauranteDomain restaurante) {
        return RestauranteMapper.toRestauranteDomainFromModel(
                restauranteJPARepository.save(
                        RestauranteMapper.toRestauranteModelFromDomain(restaurante)));
    }

    @Override
    public RestauranteDomain buscarPorId(Long id) {
        Optional<Restaurante> restauranteEntity = restauranteJPARepository.findById(id);
        if (restauranteEntity.isPresent()) {
            return RestauranteMapper.toRestauranteDomainFromModel(restauranteEntity.get());
        }
        throw new RuntimeException("Restaurante não encontrado");
    }

    @Override
    public void apagar(Long id) {
        Optional<Restaurante> restauranteEntity = restauranteJPARepository.findById(id);
        restauranteEntity.ifPresent(restauranteJPARepository::delete);
        throw new RuntimeException("Restaurante não encontrado");
    }

    @Override
    public RestauranteDomain buscarPorNome(String nome) {
        Optional<Restaurante> restauranteEntity = restauranteJPARepository.findByNomeIsLike(nome);
        if (restauranteEntity.isPresent()) {
            return RestauranteMapper.toRestauranteDomainFromModel(restauranteEntity.get());
        }
        throw new RuntimeException("Restaurante não encontrado");
    }

    @Override
    public RestauranteDomain buscarPorEndereco(String endereco) {
        Optional<Restaurante> restauranteEntity = restauranteJPARepository.findByEndereco(endereco);
        if (restauranteEntity.isPresent()) {
            return RestauranteMapper.toRestauranteDomainFromModel(restauranteEntity.get());
        }
        throw new RuntimeException("Restaurante não encontrado");
    }

    @Override
    public RestauranteDomain buscarPorTipoCozinha(String tipoCozinha) {
        Optional<Restaurante> restauranteEntity = restauranteJPARepository.findByTipoCozinha(tipoCozinha);
        if (restauranteEntity.isPresent()) {
            return RestauranteMapper.toRestauranteDomainFromModel(restauranteEntity.get());
        }
        throw new RuntimeException("Restaurante não encontrado");
    }
}
