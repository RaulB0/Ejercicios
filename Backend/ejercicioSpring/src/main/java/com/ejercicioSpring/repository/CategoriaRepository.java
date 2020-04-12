package com.ejercicioSpring.repository;

import com.ejercicioSpring.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("CategoriaRepository")
public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {
    @Query(value="SELECT max(u.codigo)+1 FROM Categoria u")
    int getLastCodigo();
}
