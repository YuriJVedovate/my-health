package com.example.myhealth.usuario.controller;


import com.example.myhealth.peso.Peso;
import com.example.myhealth.peso.repository.PesoRepository;
import com.example.myhealth.usuario.Usuario;
import com.example.myhealth.usuario.repository.UsuarioRepository;
import com.example.myhealth.usuario.request.ImageRequest;
import com.example.myhealth.usuario.request.UserDto;
import com.example.myhealth.usuario.response.UsuarioEdit;
import com.example.myhealth.usuario.response.UsuarioLogin;
import com.example.myhealth.usuario.response.UsuarioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PesoRepository pesoRepository;

    // @CrossOrigin(origins = "http://54.173.23.9/")
    @GetMapping()
    public ResponseEntity getUsuario(@RequestParam Integer idUsuario) {
        List<Usuario> usuario = repository.findAllById(Collections.singleton(idUsuario));
        if (usuario.isEmpty()) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(201).body(usuario.stream().map(UsuarioEdit::new).collect(Collectors.toList()));
    }

    // @CrossOrigin(origins = "http://54.173.23.9/")
    @PostMapping()
    public ResponseEntity postCadastrarUsuario(@RequestBody @Valid Usuario usuario) {
        usuario.setAvatar(repository.getOne(1).getAvatar());
        System.out.println("teste");
        repository.save(usuario);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/teste-loko")
    public ResponseEntity testeRequest() {
        return ResponseEntity.ok("OK OK");
    }

    // @CrossOrigin(origins = "http://54.173.23.9/")
    @DeleteMapping()
    public ResponseEntity deleteUsuarioById(@RequestParam Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.status(200).build();
        } else {
            return ResponseEntity.status(404).build();
        }

    }

    // @CrossOrigin(origins = "http://54.173.23.9/")
    @PostMapping("/cadastrar-imagem")
    public ResponseEntity postCadastrarImagem(@RequestParam("arquivo") MultipartFile arquivo, @RequestParam int idUsuario) throws IOException {
        if (arquivo.isEmpty()) {
            return ResponseEntity.status(400).body("Arquivo não enviado");
        }
        Usuario usuario = repository.getOne(idUsuario);
        usuario.setAvatar(arquivo.getBytes().toString());
        repository.save(usuario);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/cadastrar-imagem-mobile")
    public ResponseEntity postCadastrarImagem(@RequestParam int idUsuario, @RequestBody ImageRequest arquivo) throws IOException {
        if (arquivo.getImagem().isEmpty()) {
            return ResponseEntity.status(400).body("Arquivo não enviado");
        }
        Usuario usuario = repository.getOne(idUsuario);
        System.out.println(arquivo.getImagem());
        usuario.setAvatar(arquivo.getImagem());
        repository.save(usuario);
        return ResponseEntity.status(201).build();
    }

    // @CrossOrigin(origins = "http://54.173.23.9/")
    @GetMapping("/imagem/{id}")
    public ResponseEntity getProdutoImagem2(@PathVariable int id) {
        Usuario imagemOptional = repository.getOne(id);

        String imagem = imagemOptional.getAvatar();

        if (imagemOptional != null) {
            return ResponseEntity.status(200).header("content-type", "image/jpg").body(imagem);
        }
        return ResponseEntity.status(404).build();
    }

    // @CrossOrigin(origins = "http://54.173.23.9/")
    @PutMapping()
    public ResponseEntity alterUsuario(@RequestBody @Valid Usuario usuario, @RequestParam int id) {
        Usuario usuarioPut = repository.getOne(id);
        if (repository.existsById(id)) {
            usuarioPut.setNome(usuario.getNome());
            usuarioPut.setPeso(usuario.getPeso());
            usuarioPut.setAltura(usuario.getAltura());
            usuarioPut.setDataNascimento(usuario.getDataNascimento());
            usuarioPut.setSenha(usuario.getSenha());
            usuarioPut.setEmail(usuario.getEmail());
            usuarioPut.setId(id);

            Peso peso = new Peso();
            peso.setValor(usuario.getPeso());
            peso.setDataCriacao(LocalDateTime.now());
            peso.setIdUsuario(id);

            repository.save(usuarioPut);
            pesoRepository.save(peso);

            return ResponseEntity.status(200).body(usuarioPut);
        }
        return ResponseEntity.status(404).build();
    }

    // @CrossOrigin(origins = "http://54.173.23.9/")
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserDto usuario) {
        List<UsuarioLogin> users = repository.pesquisarLogin(usuario.getEmail(), usuario.getSenha());


        if (!users.isEmpty()) {
            UsuarioLogin usuarioLogin = users.get(0);

            Usuario userLogado = repository.findByEmailAndSenha(usuarioLogin.getEmail(), usuarioLogin.getSenha());
            userLogado.setAutenticado(true);
            repository.save(userLogado);
            UsuarioResponse response = new UsuarioResponse(userLogado);

            return ResponseEntity.status(200).body(response);
        }
        return ResponseEntity.status(404).build();
    }

    // @CrossOrigin(origins = "http://54.173.23.9/")
    @PostMapping("/logout")
    public ResponseEntity logout(@RequestBody UserDto usuario) {
        List<UsuarioLogin> users = repository.pesquisarLogin(usuario.getEmail(), usuario.getSenha());

        if (!users.isEmpty()) {
            UsuarioLogin usuarioLogin = users.get(0);

            Usuario userLogado = repository.findByEmailAndSenha(usuarioLogin.getEmail(), usuarioLogin.getSenha());
            userLogado.setAutenticado(false);
            repository.save(userLogado);

            return ResponseEntity.status(200).body(userLogado);
        }
        return ResponseEntity.status(404).build();

    }

}
