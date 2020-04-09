package com.ejercicioSpring.repository;

import com.ejercicioSpring.entity.Colores;
import com.ejercicioSpring.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ColoresRepository")
public interface ColoresRepository  extends JpaRepository<Colores,Integer> {
}
