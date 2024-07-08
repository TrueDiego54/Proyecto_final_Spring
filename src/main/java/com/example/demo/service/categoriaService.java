package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.categorias;
import com.example.demo.repositorio.IcategoriasRepository;

@Service
public class categoriaService {
    @Autowired
    private IcategoriasRepository data;

    public categorias guardar(categorias aux){
        return data.save(aux);
    }

    public ArrayList<categorias> obtener(){
        return (ArrayList<categorias>)data.findAll();
    }
}
