package com.example.myhealth.refeicao_alimento;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RefeicaoAlimentoId implements Serializable {

    @Column(name = "id_refeicao")
    private Integer idRefeicao;

    @Column(name = "id_alimento")
    private Integer idAlimento;

    public Integer getIdRefeicao() {
        return idRefeicao;
    }

    public void setIdRefeicao(Integer idRefeicao) {
        this.idRefeicao = idRefeicao;
    }

    public Integer getIdAlimento() {
        return idAlimento;
    }

    public void setIdAlimento(Integer idAlimento) {
        this.idAlimento = idAlimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RefeicaoAlimentoId)) return false;
        RefeicaoAlimentoId that = (RefeicaoAlimentoId) o;
        return Objects.equals(getIdRefeicao(), that.getIdRefeicao()) && Objects.equals(getIdAlimento(), that.getIdAlimento());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdRefeicao(), getIdAlimento());
    }

}
