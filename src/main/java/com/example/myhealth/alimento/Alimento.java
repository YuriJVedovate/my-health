package com.example.myhealth.alimento;

import com.example.myhealth.categoria.Categoria;

import javax.persistence.*;

@Entity
public class Alimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alimento")
    private Integer idAlimento;
    private String nome;
    private Double porcao;              //100 gramas cada
    private Double calorias;            // em Kcal
    private Double colesterol;          // em miligramas
    private Double carboidrato;         // em gramas
    private Double fibra;               // em miligramas
    private Double calcio;              // em miligramas
    private Double ferro;               // em miligramas
    private Double sodio;               // em miligramas
    private Double proteina;            // em gramas

    @JoinColumn(name = "categoria_id")
    @ManyToOne
    private Categoria categoria;


    public Integer getIdAlimento() {
        return idAlimento;
    }

    public void setIdAlimento(Integer idAlimento) {
        this.idAlimento = idAlimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPorcao() {
        return porcao;
    }

    public void setPorcao(Double porcao) {
        this.porcao = porcao;
    }

    public Double getCalorias() {
        return calorias;
    }

    public void setCalorias(Double calorias) {
        this.calorias = calorias;
    }

    public Double getColesterol() {
        return colesterol;
    }

    public void setColesterol(Double colesterol) {
        this.colesterol = colesterol;
    }

    public Double getCarboidrato() {
        return carboidrato;
    }

    public void setCarboidrato(Double carboidrato) {
        this.carboidrato = carboidrato;
    }

    public Double getFibra() {
        return fibra;
    }

    public void setFibra(Double fibra) {
        this.fibra = fibra;
    }

    public Double getCalcio() {
        return calcio;
    }

    public void setCalcio(Double calcio) {
        this.calcio = calcio;
    }

    public Double getFerro() {
        return ferro;
    }

    public void setFerro(Double ferro) {
        this.ferro = ferro;
    }

    public Double getSodio() {
        return sodio;
    }

    public void setSodio(Double sodio) {
        this.sodio = sodio;
    }

    public Double getProteina() {
        return proteina;
    }

    public void setProteina(Double proteina) {
        this.proteina = proteina;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
