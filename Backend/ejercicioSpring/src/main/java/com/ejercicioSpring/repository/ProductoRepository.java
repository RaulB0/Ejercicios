package com.ejercicioSpring.repository;

import com.ejercicioSpring.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("ProductoRepository")
public interface ProductoRepository extends JpaRepository<Producto,Integer> {

    @Query(value="SELECT max(u.codigo)+1 FROM Producto u")
    int getLastCodigo();
}
