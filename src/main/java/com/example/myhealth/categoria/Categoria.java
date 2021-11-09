package com.example.myhealth.categoria;

import javax.persistence.*;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer idCategoria;
    private String nome;

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer id) {
        this.idCategoria = idCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
