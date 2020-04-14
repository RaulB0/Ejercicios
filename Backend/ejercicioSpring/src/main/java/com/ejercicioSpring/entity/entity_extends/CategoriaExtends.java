package com.ejercicioSpring.entity.entity_extends;

import com.ejercicioSpring.entity.entities.Categoria;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORIA")
public class CategoriaExtends extends Categoria {

    public CategoriaExtends() {
    }
}
