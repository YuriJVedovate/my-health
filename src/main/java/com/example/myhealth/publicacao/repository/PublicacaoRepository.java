package com.example.myhealth.publicacao.repository;

import com.example.myhealth.publicacao.Publicacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PublicacaoRepository extends JpaRepository<Publicacao, Integer> {
     @Query(value = "Select * from Publicacao order by id_publicacao",nativeQuery = true)
    List<Publicacao> getTudo();


}
