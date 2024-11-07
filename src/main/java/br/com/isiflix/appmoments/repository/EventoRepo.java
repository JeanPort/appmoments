package br.com.isiflix.appmoments.repository;

import br.com.isiflix.appmoments.dto.EventoDTO;
import br.com.isiflix.appmoments.model.Cliente;
import br.com.isiflix.appmoments.model.Evento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventoRepo extends CrudRepository<Evento, Integer> {

    @Query(   " SELECT new br.com.isiflix.appmoments.dto.EventoDTO(e.uuid, e.titulo, e.frase, e.dataInicio, e.dataFim, e.linkMoldura)"
            + " FROM Evento e WHERE e.cliente = :c")
    List<EventoDTO> findByCliente(Cliente c);
    Evento findByUuid(String uuid);
}
