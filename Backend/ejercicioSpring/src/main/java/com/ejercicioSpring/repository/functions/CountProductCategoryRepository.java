package com.ejercicioSpring.repository.functions;

import com.ejercicioSpring.entity.functions.CountProductCategoryFunction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("CountProductCategoryRepository")
public interface CountProductCategoryRepository  extends JpaRepository<CountProductCategoryFunction,Integer> {

    @Query(value="SELECT DISTINCT COUNT_PRODUCTO_CATEGORY(:categoria) FROM PRODUCTO", nativeQuery = true)
    int functionProductosByCategory(@Param("categoria") String categoria);
}
