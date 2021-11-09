package com.example.myhealth.refeicao_alimento.response;

import com.example.myhealth.refeicao_alimento.RefeicaoAlimento;

public class RefeicaoAlimentoResponse {

    private Integer usuarioId;
    private Integer idRefeicao;
    private Integer idTipoRefeicao;
    private String tipoRefeicao;
    private Integer idAlimento;
    private String nomeAlimento;
    private Double porcaoAlimento;
    private Double calorias;
    private Double colesterol;
    private Double carboidrato;
    private Double fibra;
    private Double calcio;
    private Double ferro;
    private Double sodio;
    private Double proteina;

    public RefeicaoAlimentoResponse(RefeicaoAlimento entidade) {
        this.usuarioId = entidade.getRefeicao().getUsuario().getIdUsuario();
        this.idRefeicao = entidade.getRefeicao().getIdRefeicao();
        this.idTipoRefeicao = entidade.getRefeicao().getCategoriaRefeicao().getIdCategoriaRefeicao();
        this.tipoRefeicao = entidade.getRefeicao().getCategoriaRefeicao().getNome();
        this.idAlimento = entidade.getAlimento().getIdAlimento();
        this.nomeAlimento = entidade.getAlimento().getNome();
        this.porcaoAlimento = entidade.getPorcao();
        this.calorias = entidade.getAlimento().getCalorias();
        this.colesterol = entidade.getAlimento().getColesterol();
        this.carboidrato = entidade.getAlimento().getCarboidrato();
        this.fibra = entidade.getAlimento().getFibra();
        this.calcio = entidade.getAlimento().getCalcio();
        this.ferro = entidade.getAlimento().getFerro();
        this.sodio = entidade.getAlimento().getSodio();
        this.proteina = entidade.getAlimento().getProteina();
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public Integer getIdRefeicao() {
        return idRefeicao;
    }

    public String getTipoRefeicao() {
        return tipoRefeicao;
    }

    public Integer getIdAlimento() {
        return idAlimento;
    }

    public String getNomeAlimento() {
        return nomeAlimento;
    }

    public Double getPorcaoAlimento() {
        return porcaoAlimento;
    }

    public Double getCalorias() {
        return calorias;
    }

    public Double getColesterol() {
        return colesterol;
    }

    public Double getCarboidrato() {
        return carboidrato;
    }

    public Double getFibra() {
        return fibra;
    }

    public Double getCalcio() {
        return calcio;
    }

    public Double getFerro() {
        return ferro;
    }

    public Double getSodio() {
        return sodio;
    }

    public Double getProteina() {
        return proteina;
    }

    public Integer getIdTipoRefeicao() {
        return idTipoRefeicao;
    }
}
