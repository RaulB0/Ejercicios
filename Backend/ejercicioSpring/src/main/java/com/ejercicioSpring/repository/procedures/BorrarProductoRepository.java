package com.ejercicioSpring.repository.procedures;


import com.ejercicioSpring.entity.procedures.BorrarProductoProcedure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("BorrarProductoRepository")
public interface BorrarProductoRepository extends JpaRepository<BorrarProductoProcedure,String> {

    @Procedure(name = "BORRAR_PRODUCTO")
    String BORRAR_PRODUCTO(@Param("PARAMCODIGO") int PARAMCODIGO);
}
