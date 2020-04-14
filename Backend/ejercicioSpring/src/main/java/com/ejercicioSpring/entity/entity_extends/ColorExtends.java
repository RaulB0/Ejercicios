package com.ejercicioSpring.entity.entity_extends;

import com.ejercicioSpring.entity.entities.Color;
import com.ejercicioSpring.entity.entities.Producto;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "COLORES")
public class ColorExtends extends Color {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "color")
    private List<ProductoExtends> listaProductos;

    public ColorExtends() {
    }

    public List<ProductoExtends> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<ProductoExtends> listaProductos) {
        this.listaProductos = listaProductos;
    }




}
