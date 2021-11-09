package com.example.myhealth.refeicao_alimento;

import com.example.myhealth.alimento.Alimento;
import com.example.myhealth.refeicao.Refeicao;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "RefeicaoAlimento")
public class RefeicaoAlimento {

    @EmbeddedId
    private RefeicaoAlimentoId id;

    @JoinColumn(name = "id_refeicao", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Refeicao refeicao;

    @JoinColumn(name = "id_alimento", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Alimento alimento;

    private Double porcao;

    public RefeicaoAlimentoId getId() {
        return id;
    }

    public void setId(RefeicaoAlimentoId id) {
        this.id = id;
    }

    public Refeicao getRefeicao() {
        return refeicao;
    }

    public void setRefeicao(Refeicao refeicao) {
        this.refeicao = refeicao;
    }

    public Alimento getAlimento() {
        return alimento;
    }

    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
    }

    public Double getPorcao() {
        return porcao;
    }

    public void setPorcao(Double porcao) {
        this.porcao = porcao;
    }
}
