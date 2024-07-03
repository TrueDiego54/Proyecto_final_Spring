package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.usuario;
import com.example.demo.repositorio.IusuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    IusuarioRepository data;

    public ArrayList<usuario> obtenerxusuario(String nombre){
        return (ArrayList<usuario>) data.findByNombre(nombre);
    }

    public ArrayList<usuario> obterner_todos(){
        return (ArrayList<usuario>) data.findAll();
    }
}
