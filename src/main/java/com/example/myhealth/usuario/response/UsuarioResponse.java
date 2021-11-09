package com.example.myhealth.usuario.response;

import com.example.myhealth.usuario.Usuario;

public class UsuarioResponse {

    private Integer id;
    private String email;
    private String nome;
    private String avatar;

    public UsuarioResponse(Usuario entidade) {
        this.id = entidade.getIdUsuario();
        this.email = entidade.getEmail();
        this.nome =  entidade.getNome();
        this.avatar = "/usuarios/imagem/" + entidade.getIdUsuario();
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getNome() {
        return nome;
    }
}
