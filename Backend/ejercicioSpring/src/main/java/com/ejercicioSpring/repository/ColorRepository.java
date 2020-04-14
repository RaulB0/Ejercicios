package com.ejercicioSpring.repository;

import com.ejercicioSpring.entity.entities.Color;
import com.ejercicioSpring.entity.entity_extends.ColorExtends;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("ColorRepository")
public interface ColorRepository extends JpaRepository<ColorExtends,Integer> {
    @Query(value="SELECT max(u.codigo)+1 FROM ColorExtends u")
    int getLastCodigo();
}
