package com.ejercicioSpring.repository;

import com.ejercicioSpring.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("CategoriaRepository")
public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {
}
