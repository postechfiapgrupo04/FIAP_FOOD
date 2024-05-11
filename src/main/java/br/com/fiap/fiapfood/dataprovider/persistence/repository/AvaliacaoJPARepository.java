package br.com.fiap.fiapfood.dataprovider.persistence.repository;

import br.com.fiap.fiapfood.dataprovider.persistence.model.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AvaliacaoJPARepository extends JpaRepository<Avaliacao, Long> {

    Optional<Avaliacao> findByNomeRestaurante(String nomeRestaurante);

}
