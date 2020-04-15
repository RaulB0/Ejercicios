package com.ejercicioSpring.service;

import com.ejercicioSpring.model.CategoriaModel;
import com.ejercicioSpring.model.InsertProductoDTO;
import com.ejercicioSpring.model.MensajeDTO;
import com.ejercicioSpring.model.ProductoModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoriaService {
    public ResponseEntity<CategoriaModel> getCategoria(int codigo);
    public ResponseEntity<List<CategoriaModel>> getAllCategorias();
    public ResponseEntity<CategoriaModel> insertCategoria(CategoriaModel categoriaModel);
    public ResponseEntity<MensajeDTO> deleteCategoria(int codigo);
    public ResponseEntity<CategoriaModel> updateCategoria(CategoriaModel categoria);
}
