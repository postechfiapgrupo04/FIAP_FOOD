package br.com.fiap.fiapfood.infrastructure.persistence.repository;

import br.com.fiap.fiapfood.infrastructure.persistence.entity.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ReservaRepository extends JpaRepository<ReservaEntity, Long> {

    public Optional<ReservaEntity> findByNomeIsLike(String nome);

}
