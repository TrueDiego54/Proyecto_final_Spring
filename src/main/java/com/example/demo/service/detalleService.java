package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.boleta;
import com.example.demo.models.detalle;
import com.example.demo.repositorio.IdetalleRepository;

@Service
public class detalleService {
    @Autowired
    private IdetalleRepository data;


    public detalle guardar(detalle aux){
        return data.save(aux);
    }

    public ArrayList<detalle> obtenerxid_boleta(boleta boleta){
        return data.findByboleta(boleta);
    }
}
