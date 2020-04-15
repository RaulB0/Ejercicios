package com.ejercicioSpring.service.procedures;

import com.ejercicioSpring.model.InsertProcedureModel;
import com.ejercicioSpring.model.MensajeDTO;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;

public interface InsertarProductoService {

    public ResponseEntity<MensajeDTO> insertarProducto (InsertProcedureModel InsertProcedureModel) ;
}
