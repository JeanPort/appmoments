package br.com.isiflix.appmoments.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evento")
    private Integer id;
    @Column(name = "uuid_evento", length = 45,nullable = false)
    private String uuid;
    @Column(name = "titulo_evento", length = 100,nullable = false)
    private String titulo;
    @Column(name = "data_hora_inicio", nullable = false)
    private LocalDateTime dataInicio;
    @Column(name = "data_hora_fim", nullable = false)
    private LocalDateTime dataFim;
    @Column(name = "frase_evento", length = 100,nullable = false)
    private String frase;
    @Column(name = "status_financeiro",nullable = true)
    private Integer status;
    @Column(name = "comprovante_transacao", columnDefinition = "TEXT",nullable = true)
    private String comprovante;
    @Column(name = "link_moldura", length = 255,nullable = true)
    private String linkMoldura;
    @Column(name = "nome_fonte",length = 100)
    private String nomeFonte;

    @ManyToOne()
    @JoinColumn(name = "tbl_cliente_id_cliente")
    @JsonIgnoreProperties("eventos")
    private Cliente cliente;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getComprovante() {
        return comprovante;
    }

    public void setComprovante(String comprovante) {
        this.comprovante = comprovante;
    }

    public String getLinkMoldura() {
        return linkMoldura;
    }

    public void setLinkMoldura(String linkMoldura) {
        this.linkMoldura = linkMoldura;
    }

    public String getNomeFonte() {
        return nomeFonte;
    }

    public void setNomeFonte(String nomeFonte) {
        this.nomeFonte = nomeFonte;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
