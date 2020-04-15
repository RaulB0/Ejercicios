package com.ejercicioSpring.controller;

import com.ejercicioSpring.model.CategoriaModel;
import com.ejercicioSpring.model.MensajeDTO;
import com.ejercicioSpring.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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


    @PutMapping("insertCategoria")
    public ResponseEntity<CategoriaModel> insertCategoria(@RequestBody CategoriaModel categoriaModel)  {
        return categoriaService.insertCategoria(categoriaModel);
    }


    @GetMapping("/getAllCategorias")
    public ResponseEntity<List<CategoriaModel>> getAllCategorias(){
        return categoriaService.getAllCategorias();
    }


    @GetMapping("/getCategoria")
    public ResponseEntity<CategoriaModel> getCategoria(@RequestParam(name="codigo") int codigo){
        return categoriaService.getCategoria(codigo);
    }


    @DeleteMapping("/deleteCategoria")
    public ResponseEntity<MensajeDTO> deleteCategoria(@RequestParam(name="codigo") int codigo){
        return categoriaService.deleteCategoria(codigo);
    }


    @PutMapping("updateCategoria")
    public ResponseEntity<CategoriaModel> updateCategoria(@RequestBody CategoriaModel categoriaModel){
        return categoriaService.updateCategoria(categoriaModel);
    }


}
