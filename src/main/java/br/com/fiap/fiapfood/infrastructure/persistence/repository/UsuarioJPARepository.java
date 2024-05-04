package br.com.fiap.fiapfood.infrastructure.persistence.repository;

import br.com.fiap.fiapfood.infrastructure.persistence.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioJPARepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByCpf(String cpf);
}
