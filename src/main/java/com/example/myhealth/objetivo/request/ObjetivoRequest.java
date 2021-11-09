package com.example.myhealth.objetivo.request;

import com.example.myhealth.objetivo.Objetivo;

import java.time.LocalDate;

public class ObjetivoRequest {

    private String titulo;
    private String descricao;
    private LocalDate dataMeta;
    private Double pesoMeta;
    private Integer usuarioId;

    public ObjetivoRequest(Objetivo entidade) {
        this.titulo = entidade.getTitulo();
        this.descricao = entidade.getDescricao();
        this.dataMeta = entidade.getDataMeta();
        this.pesoMeta = entidade.getPesoMeta();
        this.usuarioId = entidade.getUsuario().getIdUsuario();
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

    public LocalDate getDataMeta() {
        return dataMeta;
    }

    public void setDataMeta(LocalDate dataMeta) {
        this.dataMeta = dataMeta;
    }

    public Double getPesoMeta() {
        return pesoMeta;
    }

    public void setPesoMeta(Double pesoMeta) {
        this.pesoMeta = pesoMeta;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }
}
