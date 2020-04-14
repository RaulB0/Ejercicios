package com.ejercicioSpring.repository;

import com.ejercicioSpring.entity.entities.Categoria;
import com.ejercicioSpring.entity.entity_extends.CategoriaExtends;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("CategoriaRepository")
public interface CategoriaRepository extends JpaRepository<CategoriaExtends,Integer> {
    @Query(value="SELECT max(u.codigo)+1 FROM CategoriaExtends u")
    int getLastCodigo();
}
