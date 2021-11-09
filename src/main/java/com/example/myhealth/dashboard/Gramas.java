package com.example.myhealth.dashboard;

public class Gramas {

    private Double totalColesterol;          // em miligramas
    private Double totalCarboidrato;         // em gramas
    private Double totalFibra;               // em miligramas
    private Double totalCalcio;              // em miligramas
    private Double totalFerro;               // em miligramas
    private Double totalSodio;               // em miligramas
    private Double totalProteina;            // em gramas
    private Double totalCalorias;            // em gramas

    public Gramas(Double totalColesterol, Double totalCarboidrato, Double totalFibra, Double totalCalcio, Double totalFerro, Double totalSodio, Double totalProteina, Double totalCalorias) {
        this.totalColesterol = totalColesterol;
        this.totalCarboidrato = totalCarboidrato;
        this.totalFibra = totalFibra;
        this.totalCalcio = totalCalcio;
        this.totalFerro = totalFerro;
        this.totalSodio = totalSodio;
        this.totalProteina = totalProteina;
        this.totalCalorias = totalCalorias;
    }

    public Double getTotalColesterol() {
        return totalColesterol;
    }

    public void setTotalColesterol(Double totalColesterol) {
        this.totalColesterol = totalColesterol;
    }

    public Double getTotalCarboidrato() {
        return totalCarboidrato;
    }

    public void setTotalCarboidrato(Double totalCarboidrato) {
        this.totalCarboidrato = totalCarboidrato;
    }

    public Double getTotalFibra() {
        return totalFibra;
    }

    public void setTotalFibra(Double totalFibra) {
        this.totalFibra = totalFibra;
    }

    public Double getTotalCalcio() {
        return totalCalcio;
    }

    public void setTotalCalcio(Double totalCalcio) {
        this.totalCalcio = totalCalcio;
    }

    public Double getTotalFerro() {
        return totalFerro;
    }

    public void setTotalFerro(Double totalFerro) {
        this.totalFerro = totalFerro;
    }

    public Double getTotalSodio() {
        return totalSodio;
    }

    public void setTotalSodio(Double totalSodio) {
        this.totalSodio = totalSodio;
    }

    public Double getTotalProteina() {
        return totalProteina;
    }

    public void setTotalProteina(Double totalProteina) {
        this.totalProteina = totalProteina;
    }

    public Double getTotalCalorias() {
        return totalCalorias;
    }

    public void setTotalCalorias(Double totalCalorias) {
        this.totalCalorias = totalCalorias;
    }
}
