package com.ejercicioSpring.controller;

import com.ejercicioSpring.model.ProductoModel;
import com.ejercicioSpring.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ejemplo")
public class pruebaController {

    @Autowired
    @Qualifier("ProductoService")
    ProductoService productoService;

    @GetMapping("prueba")
    public String ejemplo(@RequestParam(name="test") String testeo){
        System.out.println(testeo);
        return "Hola";
    }


    //El cliente envia un json
    @PostMapping("prueba2")
    public ResponseEntity<ProductoModel> getProducto(@RequestBody ProductoModel productoModel){
        System.out.println(productoModel);

        return new ResponseEntity<ProductoModel>(productoModel, HttpStatus.OK);
    }

    @GetMapping("prueba3")
    public ResponseEntity<String>ejemplo3(){
        productoService.showAll();

        return new ResponseEntity<String>("Todo Bien", HttpStatus.OK);
    }
}
