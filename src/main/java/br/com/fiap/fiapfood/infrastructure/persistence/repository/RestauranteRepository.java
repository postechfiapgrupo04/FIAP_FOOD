package br.com.fiap.fiapfood.infrastructure.persistence.repository;

import br.com.fiap.fiapfood.infrastructure.persistence.entity.RestauranteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RestauranteRepository extends JpaRepository<RestauranteEntity, Long> {

    public Optional<RestauranteEntity> findByNomeIsLike(String nome);

    @Query("select r from RestauranteEntity r where r.endereco.logradouro like ?1")
    public Optional<RestauranteEntity> findByEndereco(String endereco);

    public Optional<RestauranteEntity> findByTipoCozinha(String tipoCozinha);

}
