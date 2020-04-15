package com.ejercicioSpring.controller;

import com.ejercicioSpring.model.CategoriaModel;
import com.ejercicioSpring.model.ColorModel;
import com.ejercicioSpring.model.InsertColorDTO;
import com.ejercicioSpring.model.MensajeDTO;
import com.ejercicioSpring.service.CategoriaService;
import com.ejercicioSpring.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/color")
public class ColorController {
    @Autowired
    @Qualifier("ColorServiceImp")
    ColorService colorService;


    @PostMapping("insertColor")
    public ResponseEntity<InsertColorDTO> insertColor(@RequestBody InsertColorDTO color)  {
        return colorService.insertColor(color);
    }

    @GetMapping("/getAllColores")
    public ResponseEntity<List<ColorModel>> getAllColores(){
        return colorService.getAllColores();
    }

    @GetMapping("/getColor")
    public ResponseEntity<ColorModel> getColor(@RequestParam(name="codigo") int codigo){
        return colorService.getColor(codigo);
    }


    @GetMapping("/deleteColor")
    public ResponseEntity<MensajeDTO> deleteColor(@RequestParam(name="codigo") int codigo){
        return colorService.deleteColor(codigo);
    }


    @PostMapping("updateColor")
    public ResponseEntity<InsertColorDTO> updateColor(@RequestBody InsertColorDTO colorDTO){
        return  colorService.updateColor(colorDTO);
    }
}
