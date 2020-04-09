package com.ejercicioSpring.controller;

import com.ejercicioSpring.entity.Producto;
import com.ejercicioSpring.model.ProductoModel;
import com.ejercicioSpring.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/producto")
public class productoController {

    @Autowired
    @Qualifier("ProductoService")
    ProductoService productoService;


    @PostMapping("addProducto")
    public ResponseEntity<ProductoModel> addProducto(@RequestBody ProductoModel productoModel){

        productoService.addProducto(productoModel);

        return new ResponseEntity<ProductoModel>(productoModel, HttpStatus.OK);
    }

    @GetMapping("/getProductos")
    public ResponseEntity<List<ProductoModel>> getAllProductos(){

        return new ResponseEntity<List<ProductoModel>>(productoService.getAllProductos(), HttpStatus.OK);

    }

    @GetMapping("/getProducto")
    public ResponseEntity<ProductoModel> getProducto(@RequestParam(name="codigo") int codigo){
        ProductoModel producto = productoService.getProducto(codigo);
        System.out.println("----------------------------------------------");
        producto.getListaCategorias().forEach(categoria ->{
            System.out.println(categoria.getProductoCategoriaId().getCategoria());
        });

        System.out.println("----------------------------------------------");
        if(producto == null){
            return new ResponseEntity<ProductoModel>(producto, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ProductoModel>(producto, HttpStatus.OK);
    }


    @PostMapping("updateProducto")
    public ResponseEntity<ProductoModel> updateProducto(@RequestBody ProductoModel productoModel){


        ProductoModel producto = productoService.updateProducto(productoModel);
        if(producto == null){
            return new ResponseEntity<ProductoModel>(producto, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ProductoModel>(producto, HttpStatus.OK);
    }

}
