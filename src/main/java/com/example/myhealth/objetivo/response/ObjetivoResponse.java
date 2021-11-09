package com.example.myhealth.objetivo.response;

import com.example.myhealth.objetivo.Objetivo;

import java.time.LocalDate;

public class ObjetivoResponse {

    private Integer idObjetivo;
    private String titulo;
    private String descricao;
    private LocalDate dataCriacao;
    private LocalDate dataMeta;
    private Double pesoMeta;
    private Integer usuarioId;
    private String nomeUsuario;
    private Double pesoAtual;

    public ObjetivoResponse(Objetivo entidade) {
        this.idObjetivo = entidade.getIdObjetivo();
        this.titulo = entidade.getTitulo();
        this.descricao = entidade.getDescricao();
        this.dataCriacao = entidade.getDataCriacao();
        this.dataMeta = entidade.getDataMeta();
        this.pesoMeta = entidade.getPesoMeta();
        this.usuarioId = entidade.getUsuario().getIdUsuario();
        this.nomeUsuario = entidade.getUsuario().getNome();
        this.pesoAtual = entidade.getUsuario().getPeso();
    }

    public Integer getIdObjetivo() {
        return idObjetivo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public LocalDate getDataMeta() {
        return dataMeta;
    }

    public Double getPesoMeta() {
        return pesoMeta;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public Double getPesoAtual() {
        return pesoAtual;
    }
}
