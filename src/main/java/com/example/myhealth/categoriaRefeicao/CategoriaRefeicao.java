package com.example.myhealth.categoriaRefeicao;

import javax.persistence.*;

@Entity
@Table(name = "CategoriaRefeicao")
public class CategoriaRefeicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria_refeicao")
    private Integer idCategoriaRefeicao;
    private String nome;

    public Integer getIdCategoriaRefeicao() {
        return idCategoriaRefeicao;
    }

    public void setIdCategoriaRefeicao(Integer idCategoriaRefeicao) {
        this.idCategoriaRefeicao = idCategoriaRefeicao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

