package com.ejercicioSpring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "COLORES")
public class Color implements Serializable {

    @Id
    @Column(name="CODIGO")
    private int codigo;
    @Column(name="NOMBRE")
    private String nombre;

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "color")
    private List<Producto> listaProductos;


    public Color() {
    }

    public Color(int codigo, String nombre, List<Producto> listaProductos) {
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

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
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
