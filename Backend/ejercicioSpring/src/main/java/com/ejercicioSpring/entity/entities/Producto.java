package com.ejercicioSpring.entity.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@MappedSuperclass
@Table(name="PRODUCTO")
public class Producto implements Serializable {
    @Id
    @Column(name="CODIGO")
    private int codigo;
    @Column(name="NOMBRE")
    private String nombre;
    @Column(name="FECHA_CREACION")
    private String fecha_creacion;

    public Producto() {
    }

    public Producto(int codigo, String nombre, String fecha_creacion) {
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
        return "Producto{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", fecha_creacion='" + fecha_creacion + '\'' +
                '}';
    }
}
