package com.example.myhealth.peso.repository;

import com.example.myhealth.peso.Peso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PesoRepository extends JpaRepository<Peso, Integer> {

    @Query(value = "SELECT TOP(10) * FROM Peso p where id_Usuario = ?1 ORDER by data_Criacao desc", nativeQuery = true)
    List<Peso> historicoPeso(int idUsuario);
}
