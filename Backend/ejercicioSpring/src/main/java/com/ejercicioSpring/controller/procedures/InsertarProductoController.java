package com.ejercicioSpring.controller.procedures;

import com.ejercicioSpring.model.InsertProcedureModel;
import com.ejercicioSpring.model.MensajeDTO;
import com.ejercicioSpring.service.procedures.InsertarProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("InsertarProductoController")
@RequestMapping("/InsertarProducto")
public class InsertarProductoController {

    @Autowired
    @Qualifier("InsertarProductoServiceImp")
    InsertarProductoService insertarProductoService;

    @PostMapping("/insertar")
    public ResponseEntity<MensajeDTO> insertProducto(@RequestBody InsertProcedureModel insertProcedureModel)  {
        return insertarProductoService.insertarProducto(insertProcedureModel);
    }
}
