package com.ejercicioSpring.controller;

import com.ejercicioSpring.model.*;
import com.ejercicioSpring.service.ProcedureService;
import com.ejercicioSpring.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/procedure")
public class ProcedureController {

    @Autowired
    @Qualifier("ProcedureServiceImp")
    ProcedureService procedureService;


    @PostMapping("insertProducto")
    public ResponseEntity<MensajeDTO> insertProducto(@RequestBody InsertProcedureModel insertProcedureModel)  {
        try {
            String respuesta = procedureService.insertarProducto(insertProcedureModel);
            if(respuesta == null || !respuesta.equals("")){
                return new ResponseEntity<MensajeDTO>(new MensajeDTO(respuesta,404), HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<MensajeDTO>(new MensajeDTO("Se inserto correctamente",200), HttpStatus.OK);
        }catch (Exception e){

            return new ResponseEntity<MensajeDTO>(new MensajeDTO("Se producto un error inesperado",404), HttpStatus.NOT_FOUND);
        }

    }


    @GetMapping("borrarProducto")
    public ResponseEntity<MensajeDTO> borrarProducto(@RequestParam(name="codigo") int codigo)  {
        try {
            String respuesta = procedureService.borrarProducto(codigo);
            if(!respuesta.equals("")){
                return new ResponseEntity<MensajeDTO>(new MensajeDTO(respuesta,404), HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<MensajeDTO>(new MensajeDTO("Se borro correctamente",200), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<MensajeDTO>(new MensajeDTO("Se producto un error inesperado",404), HttpStatus.NOT_FOUND);
        }

    }


    @GetMapping("productoCategoria")
    public ResponseEntity<functionDTO> getProductoCategoria(@RequestParam(name="codigo") String categoria)  {

        return new ResponseEntity<functionDTO>(
                procedureService.funcionAllProductosByCategoria(categoria),
                HttpStatus.OK);





    }
}
