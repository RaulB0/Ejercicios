package com.ejercicioSpring.model;

import javax.persistence.Column;
import java.io.Serializable;

public class CategoriaModel implements Serializable {
    private int codigo;
    private String nombre;

    public CategoriaModel() {
    }

    public CategoriaModel(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
