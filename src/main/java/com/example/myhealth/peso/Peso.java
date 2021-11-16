package com.example.myhealth.peso;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Peso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_peso")
    private Integer idPeso;

    private Double valor;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "usuario_id")
    private Integer idUsuario;

    public Integer getIdPeso() {
        return idPeso;
    }

    public void setIdPeso(Integer idPeso) {
        this.idPeso = idPeso;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
}
