package com.example.demo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.categorias;

@Repository

public interface IcategoriasRepository extends JpaRepository<categorias,Long>{
    
}
