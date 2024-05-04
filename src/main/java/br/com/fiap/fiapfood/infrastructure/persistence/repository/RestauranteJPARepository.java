package br.com.fiap.fiapfood.infrastructure.persistence.repository;

import br.com.fiap.fiapfood.infrastructure.persistence.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RestauranteJPARepository extends JpaRepository<Restaurante, Long> {

    public Optional<Restaurante> findByNomeIsLike(String nome);

    @Query("select r from Restaurante r where r.endereco.logradouro like ?1")
    public Optional<Restaurante> findByEndereco(String endereco);

    public Optional<Restaurante> findByTipoCozinha(String tipoCozinha);

}
