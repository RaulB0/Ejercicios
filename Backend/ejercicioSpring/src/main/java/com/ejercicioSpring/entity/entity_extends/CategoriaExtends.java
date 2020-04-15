package com.ejercicioSpring.entity.entity_extends;

import com.ejercicioSpring.entity.entities.Categoria;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CATEGORIA")
public class CategoriaExtends extends Categoria {

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "PRODUCTO_CATEGORIA",
            joinColumns = { @JoinColumn(name = "CODIGO_CATEGORIA") },
            inverseJoinColumns = { @JoinColumn(name = "CODIGO_PRODUCTO") }

    )
    private List<ProductoExtends> listaProductos;

    public CategoriaExtends() {
    }

    public List<ProductoExtends> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<ProductoExtends> listaProductos) {
        this.listaProductos = listaProductos;
    }
}
