package com.example.myhealth.usuario.controller;


import com.example.myhealth.peso.Peso;
import com.example.myhealth.peso.repository.PesoRepository;
import com.example.myhealth.usuario.Usuario;
import com.example.myhealth.usuario.repository.UsuarioRepository;
import com.example.myhealth.usuario.request.UserDto;
import com.example.myhealth.usuario.response.UsuarioEdit;
import com.example.myhealth.usuario.response.UsuarioLogin;
import com.example.myhealth.usuario.response.UsuarioResponse;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Base64;
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
    public ResponseEntity postCadastrarImagem(@RequestParam MultipartFile arquivo, @RequestParam int idUsuario) throws IOException {
        if (arquivo.isEmpty()) {
            return ResponseEntity.status(400).body("Arquivo n??o enviado");
        }
        Usuario usuario = repository.getOne(idUsuario);
        usuario.setAvatar(arquivo.getBytes());
        repository.save(usuario);
        return ResponseEntity.status(201).build();
    }

    // @CrossOrigin(origins = "http://54.173.23.9/")
    @GetMapping("/imagem/{id}")
    public ResponseEntity getProdutoImagem2(@PathVariable int id) {
        Usuario imagemOptional = repository.getOne(id);
        byte[] imagem = imagemOptional.getAvatar();

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
            peso.setValor(usuario.getPeso().doubleValue());
            peso.setDataCriacao(LocalDateTime.now());
            peso.setIdUsuario(id);
            pesoRepository.save(peso);
            repository.save(usuarioPut);

            Usuario user = new Usuario();
            user.setIdUsuario(usuario.getIdUsuario());
            user.setNome(usuario.getNome());
            user.setSenha(usuario.getSenha());
            user.setEmail(usuario.getEmail());
            user.setPeso(usuario.getPeso());
            user.setAltura(usuario.getAltura());
            user.setAutenticado(usuario.getAutenticado());
            user.setDataNascimento(usuario.getDataNascimento());
            user.setAvatar(usuarioPut.getAvatar());
            user.setTipoUsuario(usuario.getTipoUsuario());

            return ResponseEntity.status(200).body(user);
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
