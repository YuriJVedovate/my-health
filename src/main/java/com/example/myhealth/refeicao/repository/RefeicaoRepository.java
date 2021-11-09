package com.example.myhealth.refeicao.repository;

import com.example.myhealth.alimento.Alimento;
import com.example.myhealth.publicacao.Publicacao;
import com.example.myhealth.refeicao.Refeicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface RefeicaoRepository extends JpaRepository<Refeicao, Integer> {

}
