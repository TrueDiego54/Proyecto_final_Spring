package com.example.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.usuario;
import com.example.demo.service.UsuarioService;
import com.example.demo.service.jwtUtil;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@CrossOrigin(origins = ("hhtp://localhost:4200"))
@RestController
@RequestMapping("/admin")
public class controlador_seguridad {
    @Autowired
    UsuarioService servicio_usuario;
    @Autowired
    jwtUtil token_service;


    String token_actual;
    String aux;
    ArrayList<usuario>lista_usuario= new ArrayList<>();
    usuario usuario_actual= new usuario();
    @PostMapping("/login")
    public HashMap<String,Object> login(@RequestBody usuario usuario_nuevo, final HttpServletResponse response) throws IOException {
        HashMap<String,Object> respuesta=new HashMap<>();
        lista_usuario = servicio_usuario.obtenerxusuario(usuario_nuevo.getNombre());
        for (usuario usuarios : lista_usuario) {
            if (usuarios.getPassword() == usuario_nuevo.getPassword()) {
                usuario_actual = usuario_nuevo;
                break;
            }
        }
        
        return entity;
    }
    @GetMapping("/")
    public ArrayList<usuario> getMethodName() {

        return servicio_usuario.obtenerxusuario("Diego");
    }
    @GetMapping("/token")
    public String generar_token() {
        token_actual =token_service.generarToken("Diego","N00243606");
        return "as";
    }
    
    
}
