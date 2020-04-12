package com.ejercicioSpring.controller;

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


    @PostMapping("insertProducto")
    public ResponseEntity<InsertProductoDTO> insertProducto(@RequestBody InsertProductoDTO insertProductoDTO)  {
        try {
            productoService.insertProducto(insertProductoDTO);

            return new ResponseEntity<InsertProductoDTO>(insertProductoDTO, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<InsertProductoDTO>(insertProductoDTO, HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/getAllProductos")
    public ResponseEntity<List<ProductoModel>> getAllProductos(){

        return new ResponseEntity<List<ProductoModel>>(productoService.getAllProductos(), HttpStatus.OK);

    }

    @GetMapping("/getProducto")
    public ResponseEntity<ProductoModel> getProducto(@RequestParam(name="codigo") int codigo){
        ProductoModel producto = productoService.getProducto(codigo);

        if(producto == null){
            return new ResponseEntity<ProductoModel>(producto, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ProductoModel>(producto, HttpStatus.OK);
    }


    @GetMapping("/deleteProducto")
    public ResponseEntity<String> deleteProducto(@RequestParam(name="codigo") int codigo){
        ProductoModel producto = productoService.getProducto(codigo);


        System.out.println("----------------------------------------------");
        if(producto == null){
            return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);
        }else{
            productoService.deleteProducto(codigo);
        }
        return new ResponseEntity<String>("", HttpStatus.OK);
    }




    @PostMapping("updateProducto")
    public ResponseEntity<InsertProductoDTO> updateProducto(@RequestBody InsertProductoDTO insertProductoDTO){


        InsertProductoDTO producto = productoService.updateProducto(insertProductoDTO);
        if(producto == null){
            return new ResponseEntity<InsertProductoDTO>(insertProductoDTO, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<InsertProductoDTO>(insertProductoDTO, HttpStatus.OK);
    }

    @GetMapping("categoria")
    public ResponseEntity<List<ProductoModel>> getProductosByCategoria(@RequestParam(name="codigo") int codigo){

        return new ResponseEntity<List<ProductoModel>>(
                productoService.getProductosByCategory(codigo), HttpStatus.OK);

    }

}
