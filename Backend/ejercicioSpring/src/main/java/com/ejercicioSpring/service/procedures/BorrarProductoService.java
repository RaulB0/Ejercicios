package com.ejercicioSpring.service.procedures;

import com.ejercicioSpring.model.MensajeDTO;
import org.springframework.http.ResponseEntity;

public interface BorrarProductoService {

    public ResponseEntity<MensajeDTO> borrarProducto(int codigo);
}
