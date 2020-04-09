package com.ejercicioSpring.repository;

import com.ejercicioSpring.entity.ProductoCategoria;
import com.ejercicioSpring.entity.ProductoCategoriaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ProductoCategoriaRepository")
public interface ProductoCategoriaRepository extends JpaRepository<ProductoCategoria, ProductoCategoriaId> {
}
