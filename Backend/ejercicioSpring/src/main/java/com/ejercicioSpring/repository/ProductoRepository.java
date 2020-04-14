package com.ejercicioSpring.repository;

import com.ejercicioSpring.entity.entities.Producto;
import com.ejercicioSpring.entity.entity_extends.ProductoExtends;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import java.util.Date;
import java.util.List;

@Repository("ProductoRepository")
public interface ProductoRepository extends JpaRepository<ProductoExtends,Integer> {

    @Query(value="" +
            "SELECT max(u.codigo)+1 " +
            "FROM ProductoExtends u")
    int getLastCodigo();

    @Query(value="" +
            "SELECT u " +
            "FROM ProductoExtends u JOIN u.listaCategorias d " +
            "WHERE d.categoria.codigo = :categoria")
    List<ProductoExtends> getProductosByCategory(@Param("categoria") int categoria);

    @Procedure(name = "INSERTAR_PRODUCTO")
    String INSERTAR_PRODUCTO(
            @Param("PARAMCODIGO")int PARAMCODIGO,
            @Param("PARAMNOMBRE")String PARAMNOMBRE,
            @Param("PARAMCOLOR")int PARAMCOLOR,
            @Param("FECHA_CREACION") Date FECHA_CREACION);

    @Procedure(name = "BORRAR_PRODUCTO")
    String BORRAR_PRODUCTO(@Param("PARAMCODIGO") int PARAMCODIGO);

    @Query(value="SELECT DISTINCT COUNT_PRODUCTO_CATEGORY(:categoria) FROM PRODUCTO", nativeQuery = true)
    int functionProductosByCategory(@Param("categoria") String categoria);


}
