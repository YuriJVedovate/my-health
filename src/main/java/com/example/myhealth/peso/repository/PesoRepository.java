package com.example.myhealth.peso.repository;

import com.example.myhealth.peso.Peso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PesoRepository extends JpaRepository<Peso, Integer> {

    @Query(value = "SELECT TOP(10) * FROM Peso p where usuario_id = ?1 ORDER by data_criacao desc", nativeQuery = true)
    List<Peso> historicoPeso(int idUsuario);
}
