package br.com.isiflix.appmoments.service;

import br.com.isiflix.appmoments.dto.EventoDTO;
import br.com.isiflix.appmoments.model.Cliente;
import br.com.isiflix.appmoments.model.Evento;
import br.com.isiflix.appmoments.repository.EventoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Service
public class EventoServiceImpl implements IEventoService{

    @Value("${appmoments.albumfolder}")
    private String albumFolder;

    @Autowired
    private EventoRepo repo;

    @Override
    public Evento criar(Evento novo) {

        novo.setUuid(UUID.randomUUID().toString());
        novo.setDataFim(novo.getDataInicio().plusHours(4));
        Evento res = repo.save(novo);
        if (res != null){
            String folder = albumFolder + File.separator + novo.getUuid();
            try {
                if (new File(folder).mkdir()) {
                    return res;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public EventoDTO recuperarPorUuid(String uudi) {
        Evento res = repo.findByUuid(uudi);
        if (res != null) {
            return new EventoDTO(res.getUuid(), res.getTitulo(), res.getFrase(), res.getDataInicio(), res.getDataFim(), res.getLinkMoldura());
        }
        return null;
    }

    @Override
    public Evento alterar(Evento evento) {
        Evento evt = repo.findByUuid(evento.getUuid());
        if (evt == null) {
            return null;
        }
        evt.setDataInicio(evento.getDataInicio());
        evt.setDataFim(evento.getDataInicio().plusHours(4));
        evt.setFrase(evento.getFrase());
        evt.setTitulo(evento.getTitulo());
        evt.setLinkMoldura(evento.getLinkMoldura());
        return repo.save(evento);
    }

    @Override
    public List<EventoDTO> recuperarPorCliente(Integer idCliente) {
        Cliente cliente = new Cliente();
        cliente.setId(idCliente);
        List<EventoDTO> res = repo.findByCliente(cliente);
        if (!res.isEmpty()) {
            return res;
        }
        return null;
    }
}
