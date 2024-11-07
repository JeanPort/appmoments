package br.com.isiflix.appmoments.service;

import br.com.isiflix.appmoments.dto.EventoDTO;
import br.com.isiflix.appmoments.model.Evento;

import java.util.List;

public interface IEventoService {

    Evento criar(Evento novo);
    EventoDTO recuperarPorUuid(String uudi);
    Evento alterar(Evento evento);
    List<EventoDTO> recuperarPorCliente(Integer idCliente);
}
