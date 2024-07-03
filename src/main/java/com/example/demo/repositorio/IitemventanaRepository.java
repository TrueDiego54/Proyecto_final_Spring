package com.example.demo.repositorio;


import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.itemventa;

import jakarta.transaction.Transactional;

@Repository
public interface IitemventanaRepository extends JpaRepository<itemventa,Long>{
    
}
