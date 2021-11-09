package com.example.myhealth.usuario.response;

import com.example.myhealth.usuario.Usuario;

import java.time.LocalDate;

public class UsuarioEdit {

    private String nome;
    private Double peso;
    private Double altura;
    private LocalDate dataNascimento;
    private String email;
    private String senha;
    private String avatar;

    public UsuarioEdit(Usuario entidade) {
        this.nome = entidade.getNome();
        this.peso = entidade.getPeso();
        this.altura = entidade.getAltura();
        this.dataNascimento = entidade.getDataNascimento();
        this.email = entidade.getEmail();
        this.senha = entidade.getSenha();
        this.avatar = "/usuarios/imagem/" + entidade.getIdUsuario();
    }

    public String getNome() {
        return nome;
    }

    public Double getPeso() {
        return peso;
    }

    public Double getAltura() {
        return altura;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getAvatar() {
        return avatar;
    }
}
