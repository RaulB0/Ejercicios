package com.ejercicioSpring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.List;

public class ProductoModel  implements Serializable {


    private int codigo;
    private String nombre;
    private ColorModel color;
    private String fecha_creacion;

    private List<CategoriaModel> listaCategorias;

    public ProductoModel() {
    }

    public ProductoModel(int codigo, String nombre, ColorModel color, String fecha_creacion, List<CategoriaModel> listaCategorias) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.color = color;
        this.fecha_creacion = fecha_creacion;
        this.listaCategorias = listaCategorias;
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

    public ColorModel getColor() {
        return color;
    }

    public void setColor(ColorModel color) {
        this.color = color;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public List<CategoriaModel> getListaCategorias() {
        return listaCategorias;
    }

    public void setListaCategorias(List<CategoriaModel> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    @Override
    public String toString() {
        return "ProductoModel{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", color=" + color +
                ", fecha_creacion='" + fecha_creacion + '\'' +
                '}';
    }
}
