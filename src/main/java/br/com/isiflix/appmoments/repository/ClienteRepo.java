package br.com.isiflix.appmoments.repository;

import br.com.isiflix.appmoments.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepo extends CrudRepository<Cliente, Integer> {
}
