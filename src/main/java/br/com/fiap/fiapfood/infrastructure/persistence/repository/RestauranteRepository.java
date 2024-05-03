package br.com.fiap.fiapfood.infrastructure.persistence.repository;

import br.com.fiap.fiapfood.infrastructure.persistence.dbmappers.DBMapperRestaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RestauranteRepository extends JpaRepository<DBMapperRestaurante, Long> {

    public Optional<DBMapperRestaurante> findByNomeIsLike(String nome);

    @Query("select r from DBMapperRestaurante r where r.endereco.logradouro like ?1")
    public Optional<DBMapperRestaurante> findByEndereco(String endereco);

    public Optional<DBMapperRestaurante> findByTipoCozinha(String tipoCozinha);

}
