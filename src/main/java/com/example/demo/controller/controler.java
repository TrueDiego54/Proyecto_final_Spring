package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.itemventa;
import com.example.demo.service.ItemventaService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin(origins = ("hhtp://localhost:4200"))
@RestController
@RequestMapping("/user")
public class controler {

    @Autowired
    ItemventaService service_item;

    @GetMapping("/")
    public ArrayList<itemventa> getMethodName() {

        return this.service_item.getitems();
    }
    @PostMapping("/envia")
    public itemventa Metodo_enviar(@RequestBody itemventa aux) {

        return  this.service_item.setitems(aux);
    } 
}
