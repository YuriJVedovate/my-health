package com.example.myhealth.categoria.repository;

import com.example.myhealth.categoria.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    List<Categoria> findByNomeContains(String nome);

    List<Categoria> findByIdCategoria(Integer id);
}
