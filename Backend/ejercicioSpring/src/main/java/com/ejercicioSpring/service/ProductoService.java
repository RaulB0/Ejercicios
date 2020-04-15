package com.ejercicioSpring.service;

import com.ejercicioSpring.model.InsertProductoDTO;
import com.ejercicioSpring.model.MensajeDTO;
import com.ejercicioSpring.model.ProductoModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductoService {

    public ResponseEntity<ProductoModel> getProducto(int codigo);
    public ResponseEntity<List<ProductoModel>> getAllProductos();
    public ResponseEntity<List<ProductoModel>> getProductosByCategory(int codigo);
    public ResponseEntity<InsertProductoDTO> insertProducto(InsertProductoDTO insertProductoDTO);
    public ResponseEntity<MensajeDTO> deleteProducto(int codigo);
    public ResponseEntity<InsertProductoDTO> updateProducto(InsertProductoDTO producto);



}
