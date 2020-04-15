package com.ejercicioSpring.entity.functions;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CountProductCategoryFunction {
    @Id
    private int cantidad;

    public CountProductCategoryFunction() {
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
