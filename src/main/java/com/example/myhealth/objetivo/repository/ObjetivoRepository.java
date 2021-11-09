package com.example.myhealth.objetivo.repository;

import com.example.myhealth.objetivo.Objetivo;
import com.example.myhealth.objetivo.response.ObjetivoResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ObjetivoRepository extends JpaRepository<Objetivo, Integer> {

    @Query(value = "select * from Objetivo o where o.usuario_id = ?1", nativeQuery = true)
    List<Objetivo> pesquisarPorUser(Integer idUsuario);

}
