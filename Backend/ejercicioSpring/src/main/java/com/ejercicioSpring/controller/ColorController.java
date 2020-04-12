package com.ejercicioSpring.controller;

import com.ejercicioSpring.model.CategoriaModel;
import com.ejercicioSpring.model.ColorModel;
import com.ejercicioSpring.model.InsertColorDTO;
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
        try {
            colorService.insertColor(color);

            return new ResponseEntity<InsertColorDTO>(color, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<InsertColorDTO>(color, HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/getAllColores")
    public ResponseEntity<List<ColorModel>> getAllColores(){

        return new ResponseEntity<List<ColorModel>>(colorService.getAllColores(), HttpStatus.OK);

    }

    @GetMapping("/getColor")
    public ResponseEntity<ColorModel> getColor(@RequestParam(name="codigo") int codigo){
        ColorModel colorModel = colorService.getColor(codigo);

        if(colorModel == null){
            return new ResponseEntity<ColorModel>(colorModel, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ColorModel>(colorModel, HttpStatus.OK);
    }


    @GetMapping("/deleteColor")
    public ResponseEntity<String> deleteColor(@RequestParam(name="codigo") int codigo){
        ColorModel colorModel= colorService.getColor(codigo);


        if(colorModel == null){
            return new ResponseEntity<String>("", HttpStatus.NOT_FOUND);
        }else{
            colorService.deleteColor(codigo);
        }
        return new ResponseEntity<String>("", HttpStatus.OK);
    }




    @PostMapping("updateColor")
    public ResponseEntity<InsertColorDTO> updateColor(@RequestBody InsertColorDTO colorDTO){
        InsertColorDTO color = null;
        try{
            color = colorService.updateColor(colorDTO);
            if(color == null){

                return new ResponseEntity<InsertColorDTO>(color, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<InsertColorDTO>(color, HttpStatus.OK);

        }catch(Exception e){


        }

        return new ResponseEntity<InsertColorDTO>(color, HttpStatus.NOT_FOUND);

    }
}
