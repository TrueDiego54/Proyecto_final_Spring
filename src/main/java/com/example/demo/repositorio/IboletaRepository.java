package com.example.demo.repositorio;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.boleta;
import com.example.demo.models.detalle;

import jakarta.transaction.Transactional;

@Repository
public interface IboletaRepository extends JpaRepository<boleta,Long>{
    @Transactional
    boleta findByFecha(Date fecha);
}
