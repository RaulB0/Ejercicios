package com.ejercicioSpring.model;

public class FunctionDTO {

    private int cantidad;

    public FunctionDTO() {
    }

    public FunctionDTO(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
