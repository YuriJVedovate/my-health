package com.example.myhealth.objetivo;

import com.example.myhealth.objetivo.request.ObjetivoRequest;
import com.example.myhealth.usuario.Usuario;
import com.example.myhealth.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Objetivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_objetivo")
    private Integer idObjetivo;

    @NotBlank
    @NotNull
    @Size(min = 1, max = 45)
    private String titulo;

    @NotBlank
    @NotNull
    @Size(min = 1, max = 45)
    private String descricao;

    @PastOrPresent
    @Column(name = "data_criacao")
    private LocalDate dataCriacao;

    @Positive
    @NotNull
    @Column(name = "peso_meta")
    private Double pesoMeta;

    @FutureOrPresent
    @NotNull
    @Column(name = "data_meta")
    private LocalDate dataMeta;

    public Objetivo() {
        this.dataCriacao = LocalDate.now();
    }

    @JoinColumn(name = "usuario_id")
    @OneToOne
    private Usuario usuario;

    public Integer getIdObjetivo() {
        return idObjetivo;
    }

    public void setIdObjetivo(Integer idObjetivo) {
        this.idObjetivo = idObjetivo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Double getPesoMeta() {
        return pesoMeta;
    }

    public void setPesoMeta(Double pesoMeta) {
        this.pesoMeta = pesoMeta;
    }

    public LocalDate getDataMeta() {
        return dataMeta;
    }

    public void setDataMeta(LocalDate dataMeta) {
        this.dataMeta = dataMeta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
