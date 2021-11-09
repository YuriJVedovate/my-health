package com.example.myhealth.categoriaRefeicao.repository;

import com.example.myhealth.categoriaRefeicao.CategoriaRefeicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoriaRefeicaoRepository extends JpaRepository<CategoriaRefeicao, Integer> {

    List<CategoriaRefeicao> findByNomeContains(String nome);

    @Query("Select u from CategoriaRefeicao u")
    List<CategoriaRefeicao> findAllCategoriaRefeicao();

    List<CategoriaRefeicao> findByIdCategoriaRefeicao(Integer id);

}
