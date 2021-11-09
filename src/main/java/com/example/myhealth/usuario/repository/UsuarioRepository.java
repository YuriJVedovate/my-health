package com.example.myhealth.usuario.repository;

import com.example.myhealth.usuario.Usuario;
import com.example.myhealth.usuario.response.UsuarioLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query("Select u from Usuario u")
    List<UsuarioLogin> findAllSimples();

    @Query("select u from Usuario u where u.email = ?1 and u.senha = ?2")
    List<UsuarioLogin> pesquisarLogin(String email,String senha);

    @Query(value = "update u Usuario u where u.autenticado = ?1", nativeQuery = true)
    List<UsuarioLogin> updateAutenticado(Boolean autenticado);

    Usuario findByEmailAndSenha(String email, String senha);

}
