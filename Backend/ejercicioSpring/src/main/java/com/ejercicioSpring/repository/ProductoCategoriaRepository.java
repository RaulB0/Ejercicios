package com.ejercicioSpring.repository;

import com.ejercicioSpring.entity.entities.ProductoCategoria;
import com.ejercicioSpring.entity.entities.ProductoCategoriaId;
import com.ejercicioSpring.entity.entity_extends.ProductoCategoriaExtends;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ProductoCategoriaRepository")
public interface ProductoCategoriaRepository extends JpaRepository<ProductoCategoriaExtends, ProductoCategoriaId> {


}
