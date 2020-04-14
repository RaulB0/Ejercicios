package com.ejercicioSpring.entity.entity_extends;

import com.ejercicioSpring.entity.entities.Color;
import com.ejercicioSpring.entity.entities.Producto;
import com.ejercicioSpring.entity.entities.ProductoCategoria;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="PRODUCTO")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "BORRAR_PRODUCTO",
                procedureName = "BORRAR_PRODUCTO",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name="PARAMCODIGO", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name="MSGERROR", type = String.class)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "INSERTAR_PRODUCTO",
                procedureName = "INSERTAR_PRODUCTO",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name="PARAMCODIGO", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name="PARAMNOMBRE", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name="PARAMCOLOR", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name="FECHA_CREACION", type = Date.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name="MSGERROR", type = String.class)
                }
        )
})
public class ProductoExtends extends Producto {

    @JoinColumn(name = "COLOR", referencedColumnName = "CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ColorExtends color;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productoCategoriaId.codigoProducto")
    private List<ProductoCategoriaExtends> listaCategorias;


    public ProductoExtends() {
    }

    public ColorExtends getColor() {
        return color;
    }

    public void setColor(ColorExtends color) {
        this.color = color;
    }

    public List<ProductoCategoriaExtends> getListaCategorias() {
        return listaCategorias;
    }

    public void setListaCategorias(List<ProductoCategoriaExtends> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    @Override
    public void setFecha_creacion(String fecha_creacion) {
        String year = fecha_creacion.split("/")[2];
        if(Integer.parseInt(year)< 1990){
            super.setFecha_creacion(null);
        }
        super.setFecha_creacion(fecha_creacion);
    }
}
