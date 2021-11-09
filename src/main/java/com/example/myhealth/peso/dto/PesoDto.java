package com.example.myhealth.peso.dto;

import java.time.LocalDate;

public class PesoDto {

    private Double valor;
    private LocalDate dataCriacao;
    private Integer idUsuario;

    public PesoDto(Double valor, LocalDate dataCriacao, Integer idUsuario) {
        valor = valor;
        this.dataCriacao = dataCriacao;
        this.idUsuario = idUsuario;
    }

    public Double getvalor() {
        return valor;
    }

    public void setvalor(Double valor) {
        valor = valor;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
}
