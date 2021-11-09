package com.example.myhealth.usuario.response;

import com.example.myhealth.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;

public class UsuarioLogin {

    private String email;
    private String senha;
    private boolean autenticado;

    public UsuarioLogin(Usuario usuario) {
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.autenticado = usuario.getAutenticado();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean getAutenticado() {
        return autenticado;
    }

    public void setAutenticado(boolean autenticado) {
        this.autenticado = autenticado;
    }
}
