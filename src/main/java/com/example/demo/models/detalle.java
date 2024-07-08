package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "detalle")
public class detalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_detalle;

    private long cantidad;
    @ManyToOne
    @JoinColumn(name = "id_item")
    itemventa itemventa;
    @ManyToOne
    @JoinColumn(name = "num_boleta")
    boleta boleta;
}
