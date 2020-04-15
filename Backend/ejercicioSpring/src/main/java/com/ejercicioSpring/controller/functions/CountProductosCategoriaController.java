package com.ejercicioSpring.controller.functions;

import com.ejercicioSpring.model.FunctionDTO;
import com.ejercicioSpring.service.functions.CountProductosCategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("CountProductosCategoriaController")
@RequestMapping("countProductos")
public class CountProductosCategoriaController {

    @Autowired
    @Qualifier("CountProductosCategoriaServiceImp")
    CountProductosCategoriaService countProductosCategoriaService;

    @GetMapping("contar")
    public ResponseEntity<FunctionDTO> getProductoCategoria(@RequestParam(name="nombreCategoria") String categoria)  {
        return countProductosCategoriaService.allProductosByCategoria(categoria);
    }
}
