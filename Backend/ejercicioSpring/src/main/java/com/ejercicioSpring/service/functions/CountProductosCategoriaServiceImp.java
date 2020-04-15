package com.ejercicioSpring.service.functions;

import com.ejercicioSpring.model.FunctionDTO;
import com.ejercicioSpring.repository.functions.CountProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("CountProductosCategoriaServiceImp")
public class CountProductosCategoriaServiceImp implements CountProductosCategoriaService {

    @Autowired
    @Qualifier("CountProductCategoryRepository")
    CountProductCategoryRepository countProductCategoryRepository;

    @Override
    public ResponseEntity<FunctionDTO> allProductosByCategoria(String categoria) {
        FunctionDTO respuesta = null;
        try {
            respuesta = new FunctionDTO(countProductCategoryRepository.functionProductosByCategory(categoria));
            return new ResponseEntity<FunctionDTO>(respuesta, HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<FunctionDTO>(new FunctionDTO(), HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
