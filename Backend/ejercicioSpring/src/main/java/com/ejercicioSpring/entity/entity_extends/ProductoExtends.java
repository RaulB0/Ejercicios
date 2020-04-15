package com.ejercicioSpring.entity.entity_extends;

import com.ejercicioSpring.entity.entities.Categoria;
import com.ejercicioSpring.entity.entities.Color;
import com.ejercicioSpring.entity.entities.Producto;
import com.ejercicioSpring.entity.entities.ProductoCategoria;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="PRODUCTO")
public class ProductoExtends extends Producto {

    @JoinColumn(name = "COLOR", referencedColumnName = "CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ColorExtends color;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "PRODUCTO_CATEGORIA",
            joinColumns = { @JoinColumn(name = "CODIGO_PRODUCTO") },
            inverseJoinColumns = { @JoinColumn(name = "CODIGO_CATEGORIA") }

    )
    private List<CategoriaExtends> listaCategorias;


    public ProductoExtends() {
    }

    public ColorExtends getColor() {
        return color;
    }

    public void setColor(ColorExtends color) {
        this.color = color;
    }

    public List<CategoriaExtends> getListaCategorias() {
        return listaCategorias;
    }

    public void setListaCategorias(List<CategoriaExtends> listaCategorias) {
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
