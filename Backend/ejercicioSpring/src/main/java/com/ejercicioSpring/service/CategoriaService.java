package com.ejercicioSpring.service;

import com.ejercicioSpring.model.CategoriaModel;
import com.ejercicioSpring.model.InsertProductoDTO;
import com.ejercicioSpring.model.ProductoModel;

import java.util.List;

public interface CategoriaService {

    public CategoriaModel getCategoria(int codigo);
    public List<CategoriaModel> getAllCategorias();
    public CategoriaModel insertCategoria(CategoriaModel categoriaModel) throws Exception;
    public void deleteCategoria(int codigo);
    public CategoriaModel updateCategoria(CategoriaModel categoria) throws Exception;
}
