package br.com.fiap.fiapfood.infrastructure.persistence;

import br.com.fiap.fiapfood.domain.model.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    UsuarioEntity findByCpf(String cpf);
}
