package com.example.demo.repositorio;


import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.usuario;

import jakarta.transaction.Transactional;


@Repository
public interface IusuarioRepository extends JpaRepository<usuario,Long>{
    @Transactional
    ArrayList<usuario> findByNombre(String nombre);
}
