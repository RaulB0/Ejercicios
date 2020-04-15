package com.ejercicioSpring.service.functions;


import com.ejercicioSpring.model.FunctionDTO;
import org.springframework.http.ResponseEntity;

public interface CountProductosCategoriaService {

    public ResponseEntity<FunctionDTO> allProductosByCategoria(String categoria);
}
