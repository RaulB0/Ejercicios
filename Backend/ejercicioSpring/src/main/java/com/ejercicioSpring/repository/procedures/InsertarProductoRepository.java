package com.ejercicioSpring.repository.procedures;


import com.ejercicioSpring.entity.procedures.InsertarProductoProcedure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository("InsertarProductoRepository")
public interface InsertarProductoRepository extends JpaRepository<InsertarProductoProcedure,String> {

    @Procedure(name = "INSERTAR_PRODUCTO")
    String INSERTAR_PRODUCTO(
            @Param("PARAMCODIGO")int PARAMCODIGO,
            @Param("PARAMNOMBRE")String PARAMNOMBRE,
            @Param("PARAMCOLOR")int PARAMCOLOR,
            @Param("FECHA_CREACION") Date FECHA_CREACION);
}
