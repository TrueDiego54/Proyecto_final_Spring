package com.example.demo.repositorio;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.boleta;
import com.example.demo.models.detalle;

import jakarta.transaction.Transactional;

@Repository
public interface IdetalleRepository extends JpaRepository <detalle, Long>{
    @Transactional
    ArrayList<detalle> findByboleta(boleta boleta);
}
