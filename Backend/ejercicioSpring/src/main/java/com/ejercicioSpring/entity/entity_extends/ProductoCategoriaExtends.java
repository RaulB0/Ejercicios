package com.ejercicioSpring.entity.entity_extends;

import com.ejercicioSpring.entity.entities.Producto;
import com.ejercicioSpring.entity.entities.ProductoCategoria;
import com.ejercicioSpring.entity.entities.ProductoCategoriaId;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCTO_CATEGORIA")
public class ProductoCategoriaExtends extends ProductoCategoria {

    @JoinColumn(name = "CODIGO_PRODUCTO", referencedColumnName = "CODIGO", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProductoExtends producto;

    @JoinColumn(name = "CODIGO_CATEGORIA", referencedColumnName = "CODIGO", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CategoriaExtends categoria;

    public ProductoCategoriaExtends() {
    }

    public ProductoCategoriaExtends(ProductoCategoriaId productoCategoriaId) {
        super(productoCategoriaId);
    }

    public ProductoExtends getProducto() {
        return producto;
    }

    public void setProducto(ProductoExtends producto) {
        this.producto = producto;
    }

    public CategoriaExtends getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaExtends categoria) {
        this.categoria = categoria;
    }
}
