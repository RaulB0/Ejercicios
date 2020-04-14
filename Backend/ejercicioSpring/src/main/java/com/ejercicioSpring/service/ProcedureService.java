package com.ejercicioSpring.service;

import com.ejercicioSpring.entity.entity_extends.ProductoExtends;
import com.ejercicioSpring.model.InsertProcedureModel;
import com.ejercicioSpring.model.ProductoModel;
import com.ejercicioSpring.model.functionDTO;

import java.text.ParseException;
import java.util.List;

public interface ProcedureService {

    public String insertarProducto (InsertProcedureModel InsertProcedureModel) throws ParseException;
    public String borrarProducto(int codigo);
    public functionDTO funcionAllProductosByCategoria(String categoria);

}
