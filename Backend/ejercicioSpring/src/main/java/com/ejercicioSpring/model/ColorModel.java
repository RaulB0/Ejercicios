package com.ejercicioSpring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;

public class ColorModel implements Serializable {
    private int codigo;
    private String nombre;
    @JsonBackReference
    private List<ProductoModel> listaProductos;


    public ColorModel() {
    }

    public ColorModel(int codigo, String nombre, List<ProductoModel> listaProductos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.listaProductos = listaProductos;
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

    public List<ProductoModel> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<ProductoModel> listaProductos) {
        this.listaProductos = listaProductos;
    }

    @Override
    public String toString() {
        return "Color{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
