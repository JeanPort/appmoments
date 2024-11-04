package br.com.isiflix.appmoments.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tbl_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer id;
    @Column(name = "nome_cliente", length = 255, nullable = false)
    private String nome;
    @Column(name = "email_cliente", length = 255, nullable = false,unique = true)
    private String email;
    @Column(name = "senha_cliente", length = 100, nullable = false)
    private String senha;
    @Column(name = "telefone_cliente", length = 20,nullable = true,unique = true)
    private String telefone;

    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
    @JsonIgnoreProperties("cliente")
    private List<Evento> eventos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
}
