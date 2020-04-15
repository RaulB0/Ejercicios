package com.ejercicioSpring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.List;

public class ProductoModel  implements Serializable {


    private int codigo;
    private String nombre;
    private String fecha_creacion;

    public ProductoModel() {
    }

    public ProductoModel(int codigo, String nombre, String fecha_creacion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.fecha_creacion = fecha_creacion;
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


    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }


    @Override
    public String toString() {
        return "ProductoModel{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", fecha_creacion='" + fecha_creacion + '\'' +
                '}';
    }
}
