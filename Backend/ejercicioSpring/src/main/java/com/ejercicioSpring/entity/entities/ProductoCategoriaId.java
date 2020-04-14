package com.ejercicioSpring.entity.entities;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class ProductoCategoriaId  implements Serializable {



    @Basic(optional = false)
    @Column(name="CODIGO_PRODUCTO")
    private Integer codigoProducto;

    @Basic(optional = false)
    @Column(name="CODIGO_CATEGORIA")
    private Integer codigoCategoria;

    public ProductoCategoriaId() {
    }

    public ProductoCategoriaId(Integer codigoProducto, Integer codigoCategoria) {
        this.codigoProducto = codigoProducto;
        this.codigoCategoria = codigoCategoria;
    }

    public Integer getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(Integer codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public Integer getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(Integer codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }
}
