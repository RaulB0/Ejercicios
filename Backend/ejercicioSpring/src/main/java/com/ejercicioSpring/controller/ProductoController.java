package com.ejercicioSpring.controller;

import com.ejercicioSpring.model.MensajeDTO;
import com.ejercicioSpring.model.ProductoModel;
import com.ejercicioSpring.model.InsertProductoDTO;
import com.ejercicioSpring.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    @Qualifier("ProductoServiceImp")
    ProductoService productoService;


    @PutMapping("insertProducto")
    public ResponseEntity<InsertProductoDTO> insertProducto(@RequestBody InsertProductoDTO insertProductoDTO)  {
        return productoService.insertProducto(insertProductoDTO);
    }

    @GetMapping("/getAllProductos")
    public ResponseEntity<List<ProductoModel>> getAllProductos(){
        return productoService.getAllProductos();
    }


    @GetMapping("/getProducto")
    public ResponseEntity<ProductoModel> getProducto(@RequestParam(name="codigo") int codigo){
        return productoService.getProducto(codigo);
    }


    @DeleteMapping("/deleteProducto")
    public ResponseEntity<MensajeDTO> deleteProducto(@RequestParam(name="codigo") int codigo){
        return productoService.deleteProducto(codigo);
    }


    @PutMapping("updateProducto")
    public ResponseEntity<InsertProductoDTO> updateProducto(@RequestBody InsertProductoDTO insertProductoDTO){
        return productoService.updateProducto(insertProductoDTO);
    }


    @GetMapping("categoria")
    public ResponseEntity<List<ProductoModel>> getProductosByCategoria(@RequestParam(name="codigo") int codigo){
        return productoService.getProductosByCategory(codigo);
    }

}
