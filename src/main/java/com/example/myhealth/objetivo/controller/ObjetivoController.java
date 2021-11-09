package com.example.myhealth.objetivo.controller;

import com.example.myhealth.objetivo.Objetivo;
import com.example.myhealth.objetivo.repository.ObjetivoRepository;
import com.example.myhealth.objetivo.request.ObjetivoRequest;
import com.example.myhealth.objetivo.response.ObjetivoResponse;
import com.example.myhealth.publicacao.Publicacao;
import com.example.myhealth.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/objetivos")
public class ObjetivoController {

    @Autowired
    private ObjetivoRepository repository;

    // @CrossOrigin(origins = "http://54.173.23.9/")
    @GetMapping
    public ResponseEntity getObjetivos(@RequestParam Integer idUsuario){
        List<Objetivo> objetivos = repository.pesquisarPorUser(idUsuario);

        if (!objetivos.isEmpty()){
            return ResponseEntity.status(200).body
                    (objetivos.stream().map(ObjetivoResponse::new).collect(Collectors.toList()));
        }
        else {
            return ResponseEntity.noContent().build();
        }
    }

    // @CrossOrigin(origins = "http://54.173.23.9/")
    @PostMapping()
    public ResponseEntity postCadastrarObjetivo(@RequestBody @Valid Objetivo objetivo) {
        repository.save(objetivo);
        return ResponseEntity.status(201).build();
    }

    // @CrossOrigin(origins = "http://54.173.23.9/")
    @DeleteMapping()
    public ResponseEntity deleteObjetivoById(@RequestParam Integer id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        else{
            return ResponseEntity.status(404).build();
        }

    }

    // @CrossOrigin(origins = "http://54.173.23.9/")
    @PutMapping()
    ResponseEntity alterObjetivo(@RequestBody @Valid Objetivo objetivo, @RequestParam int id) {
        if (repository.existsById(id)){
            objetivo.setIdObjetivo(id);
            repository.save(objetivo);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }



}
