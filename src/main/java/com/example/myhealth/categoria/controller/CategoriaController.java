package com.example.myhealth.categoria.controller;

import com.example.myhealth.categoria.Categoria;
import com.example.myhealth.categoria.repository.CategoriaRepository;
import com.example.myhealth.publicacao.Publicacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository repository;

    // @CrossOrigin(origins = "http://54.173.23.9/")
    @GetMapping()
    public ResponseEntity getCategorias(){
        List<Categoria> categorias = repository.findAll();
        if (categorias.isEmpty()){
           return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.ok(categorias);
        }
    }

    // @CrossOrigin(origins = "http://54.173.23.9/")
    @GetMapping("/nome")
    public ResponseEntity getByName(@RequestParam String nome){
        return ResponseEntity.status(200).body(repository.findByNomeContains(nome));
    }

    // @CrossOrigin(origins = "http://54.173.23.9/")
    @GetMapping("/id")
    public ResponseEntity getCategoriaById(@RequestParam int id) {
        return ResponseEntity.ok().body(repository.findByIdCategoria(id));
    }


    // @CrossOrigin(origins = "http://54.173.23.9/")
    @PostMapping()
    public ResponseEntity postCadastrarCategoria(@RequestBody @Valid Categoria categoria) {
        repository.save(categoria);
        return ResponseEntity.status(201).build();
    }

    // @CrossOrigin(origins = "http://54.173.23.9/")
    @DeleteMapping()
    public ResponseEntity deleteCategoriaById(@RequestParam Integer id) {
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
    ResponseEntity alterCategoria(@RequestBody @Valid Categoria categoria, @RequestParam int id) {
        if (repository.existsById(id)){
            categoria.setIdCategoria(id);
            repository.save(categoria);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

}
