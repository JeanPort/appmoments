package br.com.isiflix.appmoments.controller;

import br.com.isiflix.appmoments.dto.EventoDTO;
import br.com.isiflix.appmoments.model.Evento;
import br.com.isiflix.appmoments.service.IEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@CrossOrigin("*")
public class EventoController {

    @Autowired
    private IEventoService service;

    @PostMapping("/eventos")
    public ResponseEntity<Evento> criar(@RequestBody Evento novo) throws URISyntaxException {
        Evento res = service.criar(novo);
        if (res != null) {
            return ResponseEntity.created(new URI("/eventos/"+res.getId())).body(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/eventos/{uuid}")
    public ResponseEntity<EventoDTO> recuperaraPorUuid(@PathVariable String uuid){
        EventoDTO res = service.recuperarPorUuid(uuid);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/eventos/{uuid}")
    public ResponseEntity<Evento> alterar(@RequestBody Evento evento) {

        Evento res = service.alterar(evento);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/eventos/cliente/{id}")
    public ResponseEntity<List<EventoDTO>> recuperarPorCliente(@PathVariable Integer id) {
        List<EventoDTO> res = service.recuperarPorCliente(id);
        if (res != null) {
            return ResponseEntity.ok(res);
        }
        return ResponseEntity.notFound().build();
    }
}
