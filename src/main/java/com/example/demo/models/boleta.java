package com.example.demo.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "boleta")
public class boleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long num_boleta;
    private Date fecha;
}
