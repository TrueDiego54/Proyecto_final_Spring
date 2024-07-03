package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.itemventa;
import com.example.demo.repositorio.IitemventanaRepository;

@Service
public class ItemventaService {
    @Autowired
    IitemventanaRepository data;


    public ArrayList<itemventa> getitems(){
        return (ArrayList<itemventa>) data.findAll();
    }

    public itemventa setitems(itemventa aux){
        return data.save(aux);
    }
}
