package com.example.myhealth.refeicao;

import com.example.myhealth.categoriaRefeicao.CategoriaRefeicao;
import com.example.myhealth.usuario.Usuario;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Refeicao {

    @Id
    @Column(name = "id_refeicao")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRefeicao;


    @Column(name = "data_refeicao")
    private LocalDateTime dataRefeicao;

    @JoinColumn(name = "categoria_refeicao_id")
    @ManyToOne
    private CategoriaRefeicao categoriaRefeicao;

    @JoinColumn(name = "usuario_id")
    @ManyToOne
    private Usuario usuario;

    public Refeicao() {
        this.dataRefeicao = LocalDateTime.now();
    }

    public Integer getIdRefeicao() {
        return idRefeicao;
    }

    public void setIdRefeicao(Integer idRefeicao) {
        this.idRefeicao = idRefeicao;
    }

    public CategoriaRefeicao getCategoriaRefeicao() {
        return categoriaRefeicao;
    }

    public void setCategoriaRefeicao(CategoriaRefeicao categoriaRefeicao) {
        this.categoriaRefeicao = categoriaRefeicao;
    }

    public LocalDateTime getDataRefeicao() {
        return dataRefeicao;
    }

    public void setDataRefeicao(LocalDateTime dataRefeicao) {
        this.dataRefeicao = dataRefeicao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
