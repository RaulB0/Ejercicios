package com.ejercicioSpring.controller;

import com.ejercicioSpring.model.CategoriaModel;
import com.ejercicioSpring.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    @Qualifier("CategoriaServiceImp")
    CategoriaService categoriaService;


    @PostMapping("insertCategoria")
    public ResponseEntity<CategoriaModel> insertCategoria(@RequestBody CategoriaModel categoriaModel)  {
        try {
            categoriaService.insertCategoria(categoriaModel);

            return new ResponseEntity<CategoriaModel>(categoriaModel, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<CategoriaModel>(categoriaModel, HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/getAllCategorias")
    public ResponseEntity<List<CategoriaModel>> getAllCategorias(){

        return new ResponseEntity<List<CategoriaModel>>(categoriaService.getAllCategorias(), HttpStatus.OK);

    }

    @GetMapping("/getCategoria")
    public ResponseEntity<CategoriaModel> getCategoria(@RequestParam(name="codigo") int codigo){
        CategoriaModel categoriaModel = categoriaService.getCategoria(codigo);

        if(categoriaModel == null){
            return new ResponseEntity<CategoriaModel>(categoriaModel, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CategoriaModel>(categoriaModel, HttpStatus.OK);
    }


    @GetMapping("/deleteCategoria")
    public ResponseEntity<String> deleteCategoria(@RequestParam(name="codigo") int codigo){
        CategoriaModel categoriaModel= categoriaService.getCategoria(codigo);


        if(categoriaModel == null){
            return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);
        }else{
            categoriaService.deleteCategoria(codigo);
        }
        return new ResponseEntity<String>("", HttpStatus.OK);
    }




    @PostMapping("updateCategoria")
    public ResponseEntity<CategoriaModel> updateCategoria(@RequestBody CategoriaModel categoriaModel){
        CategoriaModel categoria = null;
        try{
            categoria = categoriaService.updateCategoria(categoriaModel);
            if(categoria == null){

                return new ResponseEntity<CategoriaModel>(categoria, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<CategoriaModel>(categoria, HttpStatus.OK);

        }catch(Exception e){


        }

        return new ResponseEntity<CategoriaModel>(categoria, HttpStatus.NOT_FOUND);

    }


}
