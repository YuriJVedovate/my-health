package com.example.myhealth.alimento.repository;

import com.example.myhealth.alimento.Alimento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlimentoRepository extends JpaRepository<Alimento, Integer> {

    List<Alimento> findByNomeContains(String nome);

    long count();
}
