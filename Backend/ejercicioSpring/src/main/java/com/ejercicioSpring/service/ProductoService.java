package com.ejercicioSpring.service;

import com.ejercicioSpring.model.InsertProductoDTO;
import com.ejercicioSpring.model.ProductoModel;

import java.util.List;

public interface ProductoService {

    public ProductoModel getProducto(int codigo);
    public List<ProductoModel> getAllProductos();
    public List<ProductoModel> getProductosByCategory(int codigo);
    public InsertProductoDTO insertProducto(InsertProductoDTO insertProductoDTO) throws Exception;
    public void deleteProducto(int codigo);
    public InsertProductoDTO updateProducto(InsertProductoDTO producto);



}
