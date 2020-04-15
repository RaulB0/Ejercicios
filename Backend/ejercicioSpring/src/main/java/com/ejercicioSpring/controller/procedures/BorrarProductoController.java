package com.ejercicioSpring.controller.procedures;

import com.ejercicioSpring.model.MensajeDTO;
import com.ejercicioSpring.service.procedures.BorrarProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("BorrarProductoController")
@RequestMapping("/BorrarProducto")
public class BorrarProductoController {

    @Autowired
    @Qualifier("BorrarProductoServiceImp")
    BorrarProductoService borrarProducto;


    @GetMapping("borrar")
    public ResponseEntity<MensajeDTO> borrarProducto(@RequestParam(name="codigo") int codigo)  {
        return borrarProducto.borrarProducto(codigo);
    }
}
