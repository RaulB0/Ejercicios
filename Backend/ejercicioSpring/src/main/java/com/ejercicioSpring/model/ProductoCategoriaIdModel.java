package com.ejercicioSpring.model;

import com.ejercicioSpring.entity.Categoria;
import com.ejercicioSpring.entity.Producto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

public class ProductoCategoriaIdModel implements Serializable {

    private ProductoModel producto;

    private CategoriaModel categoria;

    public ProductoCategoriaIdModel() {
    }

    public ProductoCategoriaIdModel(ProductoModel producto, CategoriaModel categoria) {
        this.producto = producto;
        this.categoria = categoria;
    }

    public ProductoModel getProducto() {
        return producto;
    }

    public void setProducto(ProductoModel producto) {
        this.producto = producto;
    }

    public CategoriaModel getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaModel categoria) {
        this.categoria = categoria;
    }
}
