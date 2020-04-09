package com.ejercicioSpring.model;

import com.ejercicioSpring.entity.Colores;
import com.ejercicioSpring.entity.ProductoCategoria;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

public class ProductoModel  implements Serializable {


    private int codigo;
    private String nombre;
    @JsonManagedReference
    private Colores color;
    private String fecha_creacion;

    @JsonBackReference
    private List<ProductoCategoriaModel> listaCategorias;

    public ProductoModel() {
    }

    public ProductoModel(int codigo, String nombre, Colores color, String fecha_creacion, List<ProductoCategoriaModel> listaCategorias) {
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

    public Colores getColor() {
        return color;
    }

    public void setColor(Colores colorNombre) {
        this.color = colorNombre;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public List<ProductoCategoriaModel> getListaCategorias() {
        return listaCategorias;
    }

    public void setListaCategorias(List<ProductoCategoriaModel> listaCategorias) {
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
