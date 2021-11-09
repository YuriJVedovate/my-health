package com.example.myhealth.publicacao.response;

import com.example.myhealth.publicacao.Publicacao;

public class PublicacaoResponse {

    private String descricao;
    private Integer curtida;
    private String imagem;
    private String imagemUsuario;
    private Integer usuarioId;
    private String nomeUsuario;

    public PublicacaoResponse(Publicacao entidade) {
        this.descricao = entidade.getDescricao();
        this.curtida = entidade.getCurtida();
        this.imagem = "/publicacoes/imagem/" + entidade.getIdPublicacao();
        this.imagemUsuario = "/usuarios/imagem/" + entidade.getUsuario().getIdUsuario();
        this.usuarioId = entidade.getUsuario().getIdUsuario();
        this.nomeUsuario = entidade.getUsuario().getNome();
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

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getImagemUsuario() {
        return imagemUsuario;
    }

    public void setImagemUsuario(String imagemUsuario) {
        this.imagemUsuario = imagemUsuario;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
}
