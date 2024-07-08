package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.boleta;
import com.example.demo.models.categorias;
import com.example.demo.models.detalle;
import com.example.demo.models.itemventa;
import com.example.demo.service.ItemventaService;
import com.example.demo.service.boletaService;
import com.example.demo.service.categoriaService;
import com.example.demo.service.detalleService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin(origins = ("http://localhost:4200"))
@RestController
@RequestMapping("/user")
public class controler {

    @Autowired
    ItemventaService service_item;
    @Autowired
    categoriaService service_categoria;
    @Autowired
    detalleService service_detalle;
    @Autowired
    boletaService service_boleta;

    @GetMapping("/imprimir_items")
    public ArrayList<itemventa> Metodo_Imprimir_items() {

        return this.service_item.getitems();
    }
    @GetMapping("/imprimir_categorias")
    public ArrayList<categorias> Metodo_Imprimir_categorias() {

        return this.service_categoria.obtener();
    }
    @PostMapping("/enviarproduc")
    public ResponseEntity<itemventa>  Metodo_enviar_producto(@RequestBody itemventa aux ) {
        try {
            itemventa guarda = service_item.setitems(aux);
            return ResponseEntity.created(new URI("/item/"+guarda.getId_item())).body(guarda);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    } 
    @PutMapping("/enviarproduc")
    public ResponseEntity<itemventa>  Metodo_actualizar_producto(@RequestBody itemventa aux) {
        try {
            itemventa guarda = service_item.setitems(aux);
            return ResponseEntity.created(new URI("/item/"+guarda.getId_item())).body(guarda);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    } 
    @PostMapping("/enviarcateg")
    public ResponseEntity<categorias> Metodo_enviar_categoria(@RequestBody categorias aux) {
        try {
            categorias guarda = service_categoria.guardar(aux);
            return ResponseEntity.created(new URI("/categorias/"+guarda.getId_categoria())).body(guarda);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        
    } 
    @PutMapping("/enviarcateg")
    public ResponseEntity<categorias> Metodo_actualizar_categoria(@RequestBody categorias aux) {

        try {
            categorias guarda = service_categoria.guardar(aux);
            return ResponseEntity.created(new URI("/categorias/"+guarda.getId_categoria())).body(guarda);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }    } 
    @PostMapping("/boleta")
    public detalle Metodo_recibir_boleta(@RequestBody detalle entity) {
        boleta aux = new boleta();
        Date date = new Date();
        aux.setFecha(date); 
        service_boleta.guardar(aux);
        aux = service_boleta.obtenerxfecha(date);
        entity.setBoleta(aux);
        return service_detalle.guardar(entity);
    }

}
