package com.ejercicioSpring.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name="Producto")
public class Producto implements Serializable {
    @Id
    @Column(name="CODIGO")
    private int codigo;
    @Column(name="NOMBRE")
    private String nombre;
    @ManyToOne
    @JoinColumn(name="COLOR")
    private Color color;
    @Column(name="FECHA_CREACION")
    private String fecha_creacion;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productoCategoriaId.producto")
    private List<ProductoCategoria> listaCategorias;

    public Producto() {
    }

    public Producto(int codigo, String nombre, Color color, String fecha_creacion, List<ProductoCategoria> listaCategorias) {
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public List<ProductoCategoria> getListaCategorias() {
        return listaCategorias;
    }

    public void setListaCategorias(List<ProductoCategoria> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", color=" + color +
                ", fecha_creacion='" + fecha_creacion + '\'' +
                '}';
    }
}
