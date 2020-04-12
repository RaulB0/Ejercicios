package com.ejercicioSpring.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

public class InsertProductoDTO {

    private int codigo;
    private String nombre;
    private int color;
    private String fecha_creacion;
    private int[] listaCategorias;

    public InsertProductoDTO() {
    }

    public InsertProductoDTO(int codigo, String nombre, int color, String fecha_creacion, int[] listaCategorias) {
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

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public int[] getListaCategorias() {
        return listaCategorias;
    }

    public void setListaCategorias(int[] listaCategorias) {
        this.listaCategorias = listaCategorias;
    }
}
