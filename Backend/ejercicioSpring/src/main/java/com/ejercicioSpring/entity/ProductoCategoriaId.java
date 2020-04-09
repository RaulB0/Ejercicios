package com.ejercicioSpring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ProductoCategoriaId  implements Serializable {



    @ManyToOne
    @JoinColumn(name="CODIGO_PRODUCTO")
    private Producto producto;


    @ManyToOne
    @JoinColumn(name="CODIGO_CATEGORIA")
    private Categoria categoria;

    public ProductoCategoriaId() {
    }

    public ProductoCategoriaId(Producto producto, Categoria categoria) {
        this.producto = producto;
        this.categoria = categoria;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }






                      
}
