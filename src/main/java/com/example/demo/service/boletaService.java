package com.example.demo.service;


import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.boleta;
import com.example.demo.repositorio.IboletaRepository;

@Service
public class boletaService {
    @Autowired
    private IboletaRepository data;
    public boleta guardar(boleta aux){
        return data.save(aux);
    }

    public Optional<boleta> obtenerxid(Long id_boleta){
        return  data.findById(id_boleta);
    }
    public boleta obtenerxfecha(Date fecha){
        return  data.findByFecha(fecha);
    }
}
