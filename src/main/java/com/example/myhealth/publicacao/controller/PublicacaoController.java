package com.example.myhealth.publicacao.controller;

import com.example.myhealth.objetos.PilhaObj;
import com.example.myhealth.publicacao.Publicacao;
import com.example.myhealth.publicacao.repository.PublicacaoRepository;
import com.example.myhealth.publicacao.response.PublicacaoResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.IOUtils;

import javax.validation.Valid;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/publicacoes")
public class PublicacaoController {

    @Autowired
    private PublicacaoRepository repository;

    // @CrossOrigin(origins = "http://54.173.23.9/")
    @GetMapping
    public ResponseEntity getPublicacoes() {
        List<Publicacao> publicacoes = repository.getTudo();
        List<PublicacaoResponse> publiOrdem = new ArrayList<PublicacaoResponse>();

        if (!publicacoes.isEmpty()) {
            List<PublicacaoResponse> publiResponse = publicacoes.stream().map(PublicacaoResponse::new).collect(Collectors.toList());
            PilhaObj<PublicacaoResponse> pilhaPublicacao = new PilhaObj<PublicacaoResponse>(publiResponse.size());

            for (PublicacaoResponse pr : publiResponse) {
                pilhaPublicacao.push(pr);
            }
            for (int i = 0; i < pilhaPublicacao.getTamanho(); i++){
                publiOrdem.add(pilhaPublicacao.pop());
            }
            return ResponseEntity.status(200).body(publiOrdem);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    // @CrossOrigin(origins = "http://54.173.23.9/")
    @PostMapping()
    public ResponseEntity postCadastrarPublicacao(@RequestBody @Valid Publicacao publicacao) {
        repository.save(publicacao);
        return ResponseEntity.status(201).body(publicacao.getIdPublicacao());
    }

    // @CrossOrigin(origins = "http://54.173.23.9/")
    @PostMapping("/cadastrar-imagem")
    public ResponseEntity postCadastrarImagem(@RequestParam MultipartFile arquivo, @RequestParam int idPublicacao) throws IOException {
        if (arquivo.isEmpty()) {
            return ResponseEntity.status(400).body("Arquivo não enviado");
        }
        Publicacao publicacao = repository.getOne(idPublicacao);
        publicacao.setImagem(arquivo.getBytes());
        repository.save(publicacao);
        return ResponseEntity.status(201).build();
    }


    @GetMapping("/imagem/{id}")
    public ResponseEntity getProdutoImagem2(@PathVariable int id) {
        Publicacao imagemOptional = repository.getOne(id);
        byte[] imagem = imagemOptional.getImagem();

        if (imagemOptional != null) {
            return ResponseEntity.status(200).header("content-type", "image/jpg").body(imagem);
        }
        return ResponseEntity.status(404).build();
    }

    // @CrossOrigin(origins = "http://54.173.23.9/")
    @DeleteMapping()
    public ResponseEntity deletePublicacaoById(@RequestParam Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }

    }

    // @CrossOrigin(origins = "http://54.173.23.9/")
    @PutMapping()
    ResponseEntity alterPublicacao(@RequestBody @Valid Publicacao publicacao, @RequestParam int id) {
        if (repository.existsById(id)) {
            publicacao.setIdPublicacao(id);
            repository.save(publicacao);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

}
