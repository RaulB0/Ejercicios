package com.ejercicioSpring.model;

import com.ejercicioSpring.entity.ProductoCategoriaId;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;

public class ProductoCategoriaModel  implements Serializable {

    @JsonBackReference
    private ProductoCategoriaIdModel productoCategoriaId;

    public ProductoCategoriaModel() {
    }

    public ProductoCategoriaModel(ProductoCategoriaIdModel productoCategoriaId) {
        this.productoCategoriaId = productoCategoriaId;
    }

    public ProductoCategoriaIdModel getProductoCategoriaId() {
        return productoCategoriaId;
    }

    public void setProductoCategoriaId(ProductoCategoriaIdModel productoCategoriaId) {
        this.productoCategoriaId = productoCategoriaId;
    }
}
