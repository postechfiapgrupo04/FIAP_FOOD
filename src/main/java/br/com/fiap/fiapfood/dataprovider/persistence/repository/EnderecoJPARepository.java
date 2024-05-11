package br.com.fiap.fiapfood.dataprovider.persistence.repository;

import br.com.fiap.fiapfood.dataprovider.persistence.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoJPARepository extends JpaRepository<Endereco, Long> {
}
