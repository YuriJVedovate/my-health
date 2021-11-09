package com.example.myhealth.dashboard;

public class Conversao {

    private int pesoProteina;            // em gramas
    private int pesoColesterol;          // em miligramas
    private int pesoCarboidrato;         // em gramas
    private int pesoFibra;               // em miligramas
    private int pesoCalcio;              // em miligramas
    private int pesoFerro;               // em miligramas
    private int pesoSodio;               // em miligramas

    public Conversao() {
        this.pesoColesterol = 1000;
        this.pesoCarboidrato = 1;
        this.pesoFibra = 1000;
        this.pesoCalcio = 1000;
        this.pesoFerro = 1000;
        this.pesoSodio = 1000;
        this.pesoProteina = 1;
    }

    public int getPesoProteina() {
        return pesoProteina;
    }

    public void setPesoProteina(int pesoProteina) {
        this.pesoProteina = pesoProteina;
    }

    public int getPesoColesterol() {
        return pesoColesterol;
    }

    public void setPesoColesterol(int pesoColesterol) {
        this.pesoColesterol = pesoColesterol;
    }

    public int getPesoCarboidrato() {
        return pesoCarboidrato;
    }

    public void setPesoCarboidrato(int pesoCarboidrato) {
        this.pesoCarboidrato = pesoCarboidrato;
    }

    public int getPesoFibra() {
        return pesoFibra;
    }

    public void setPesoFibra(int pesoFibra) {
        this.pesoFibra = pesoFibra;
    }

    public int getPesoCalcio() {
        return pesoCalcio;
    }

    public void setPesoCalcio(int pesoCalcio) {
        this.pesoCalcio = pesoCalcio;
    }

    public int getPesoFerro() {
        return pesoFerro;
    }

    public void setPesoFerro(int pesoFerro) {
        this.pesoFerro = pesoFerro;
    }

    public int getPesoSodio() {
        return pesoSodio;
    }

    public void setPesoSodio(int pesoSodio) {
        this.pesoSodio = pesoSodio;
    }
}
