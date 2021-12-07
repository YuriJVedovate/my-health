package com.example.myhealth.publicacao;

import com.example.myhealth.usuario.Usuario;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Publicacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_publicacao")
    private Integer idPublicacao;

    @Size(max = 255)
    private String descricao;

    @PositiveOrZero
    private Integer curtida = 0;

    private byte[] imagem;

    @Column(name = "data_publicacao")
    private LocalDateTime dataPublicacao;

    @JoinColumn(name = "usuario_id")
    @ManyToOne
    private Usuario usuario;

    @Column(name = "tipo_publicacao")
    private String TipoPublicacao;

    public Publicacao() {
        this.dataPublicacao = LocalDateTime.now();
    }

    public Integer getIdPublicacao() {
        return idPublicacao;
    }

    public void setIdPublicacao(Integer idPublicacao) {
        this.idPublicacao = idPublicacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCurtida() {
        return curtida;
    }

    public void setCurtida(Integer curtida) {
        this.curtida = curtida;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDateTime dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public String getTipoPublicacao() {
        return TipoPublicacao;
    }

    public void setTipoPublicacao(String tipoPublicacao) {
        TipoPublicacao = tipoPublicacao;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }
}
