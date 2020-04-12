package com.ejercicioSpring.repository;

import com.ejercicioSpring.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("ColorRepository")
public interface ColorRepository extends JpaRepository<Color,Integer> {
    @Query(value="SELECT max(u.codigo)+1 FROM Color u")
    int getLastCodigo();
}
