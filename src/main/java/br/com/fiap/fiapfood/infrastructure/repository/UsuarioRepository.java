package br.com.fiap.fiapfood.infrastructure.repository;

import br.com.fiap.fiapfood.infrastructure.entity.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<UsuarioEntity, Long>{
}
