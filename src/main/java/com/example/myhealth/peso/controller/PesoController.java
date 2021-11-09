package com.example.myhealth.peso.controller;

import com.example.myhealth.alimento.Alimento;
import com.example.myhealth.peso.Peso;
import com.example.myhealth.peso.repository.PesoRepository;
import com.example.myhealth.usuario.Usuario;
import com.example.myhealth.usuario.repository.UsuarioRepository;
import com.example.myhealth.usuario.response.UsuarioEdit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pesos")
public class PesoController {

    @Autowired
    private PesoRepository repository;

    // @CrossOrigin(origins = "http://54.173.23.9/")
    @GetMapping()
    public ResponseEntity getPeso() {
        List<Peso> pesos = repository.findAll();
        if (pesos.isEmpty()){
            return ResponseEntity.noContent().build();
        } else{
            return ResponseEntity.ok(pesos);
        }
    }



}
