package br.com.fiap.fiapfood.infrastructure.persistence.repository;

import br.com.fiap.fiapfood.infrastructure.persistence.dbmappers.DBMapperUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<DBMapperUsuario, Long> {

    Optional<DBMapperUsuario> findByCpf(String cpf);
}
