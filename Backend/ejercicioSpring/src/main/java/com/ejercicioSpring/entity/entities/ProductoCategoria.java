package com.ejercicioSpring.entity.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import java.io.Serializable;

@MappedSuperclass
public class ProductoCategoria  implements Serializable {

    @EmbeddedId
    private ProductoCategoriaId productoCategoriaId;

    public ProductoCategoria() {

    }

    public ProductoCategoria(ProductoCategoriaId productoCategoriaId) {
        this.productoCategoriaId = productoCategoriaId;
    }

    public ProductoCategoriaId getProductoCategoriaId() {
        return productoCategoriaId;
    }

    public void setProductoCategoriaId(ProductoCategoriaId productoCategoriaId) {
        this.productoCategoriaId = productoCategoriaId;
    }


}
