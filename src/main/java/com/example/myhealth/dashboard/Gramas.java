package com.example.myhealth.dashboard;

public class Gramas {

    private Double Colesterol;          // em miligramas
    private Double Carboidrato;         // em gramas
    private Double Fibra;               // em miligramas
    private Double Calcio;              // em miligramas
    private Double Ferro;               // em miligramas
    private Double Sodio;               // em miligramas
    private Double Proteina;            // em gramas
    private Double Calorias;            // em gramas

    public Gramas(Double Colesterol, Double Carboidrato, Double Fibra, Double Calcio, Double Ferro, Double Sodio, Double Proteina, Double Calorias) {
        this.Colesterol = Colesterol;
        this.Carboidrato = Carboidrato;
        this.Fibra = Fibra;
        this.Calcio = Calcio;
        this.Ferro = Ferro;
        this.Sodio = Sodio;
        this.Proteina = Proteina;
        this.Calorias = Calorias;
    }

    public Double getColesterol() {
        return Colesterol;
    }

    public void setColesterol(Double colesterol) {
        Colesterol = colesterol;
    }

    public Double getCarboidrato() {
        return Carboidrato;
    }

    public void setCarboidrato(Double carboidrato) {
        Carboidrato = carboidrato;
    }

    public Double getFibra() {
        return Fibra;
    }

    public void setFibra(Double fibra) {
        Fibra = fibra;
    }

    public Double getCalcio() {
        return Calcio;
    }

    public void setCalcio(Double calcio) {
        Calcio = calcio;
    }

    public Double getFerro() {
        return Ferro;
    }

    public void setFerro(Double ferro) {
        Ferro = ferro;
    }

    public Double getSodio() {
        return Sodio;
    }

    public void setSodio(Double sodio) {
        Sodio = sodio;
    }

    public Double getProteina() {
        return Proteina;
    }

    public void setProteina(Double proteina) {
        Proteina = proteina;
    }

    public Double getCalorias() {
        return Calorias;
    }

    public void setCalorias(Double calorias) {
        Calorias = calorias;
    }
}
