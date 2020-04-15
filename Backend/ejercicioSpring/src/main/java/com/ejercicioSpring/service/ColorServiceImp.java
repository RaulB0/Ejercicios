package com.ejercicioSpring.service;

import com.ejercicioSpring.entity.entities.Color;
import com.ejercicioSpring.entity.entity_extends.ColorExtends;
import com.ejercicioSpring.model.CategoriaModel;
import com.ejercicioSpring.model.ColorModel;
import com.ejercicioSpring.model.InsertColorDTO;
import com.ejercicioSpring.model.MensajeDTO;
import com.ejercicioSpring.repository.ColorRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service("ColorServiceImp")
public class ColorServiceImp implements ColorService {
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    @Qualifier("ColorRepository")
    ColorRepository colorRepository;

    @Override
    public ResponseEntity<ColorModel> getColor(int codigo) {
        Color color = null;
        try {
            color = colorRepository.getOne(codigo);
            if(color == null){
                return new ResponseEntity<ColorModel>(modelMapper.map(color, ColorModel.class), HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<ColorModel>(modelMapper.map(color, ColorModel.class), HttpStatus.OK);
        }catch(Exception e){

        }finally {
            color = null;
        }
        return new ResponseEntity<ColorModel>(modelMapper.map(color, ColorModel.class), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @Override
    public ResponseEntity<List<ColorModel>> getAllColores() {
        Type tipo = new TypeToken<List<CategoriaModel>>(){}.getType();
        List<ColorModel> listaColores;
        try {
            listaColores = modelMapper.map(colorRepository.findAll(),tipo);
            return new ResponseEntity<List<ColorModel>>(listaColores,HttpStatus.OK);
        }catch (Exception e){

        }finally {
            tipo = null;
            listaColores = null;
        }
        return new ResponseEntity<List<ColorModel>>(new ArrayList<ColorModel>(),HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @Override
    public ResponseEntity<InsertColorDTO> insertColor(InsertColorDTO color){
        color.setCodigo(colorRepository.getLastCodigo());
        try {
            colorRepository.save(modelMapper.map(color, ColorExtends.class));
            return new ResponseEntity<InsertColorDTO>(color,HttpStatus.OK);
        }catch (Exception e){
        }
        return new ResponseEntity<InsertColorDTO>(color,HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @Override
    public ResponseEntity<MensajeDTO> deleteColor(int codigo) {
        try {
            colorRepository.deleteById(codigo);
            return new ResponseEntity<MensajeDTO>(new MensajeDTO("Borrado correctamente",200), HttpStatus.OK);
        }catch(Exception e){

        }
        return new ResponseEntity<MensajeDTO>(new MensajeDTO("No se encontro el color",404), HttpStatus.NOT_FOUND);
    }


    @Override
    public ResponseEntity<InsertColorDTO> updateColor(InsertColorDTO color){
        try {
            if(!colorRepository.findById(color.getCodigo()).isPresent()) {
                throw new Exception("No se encontro el color");
            }
            colorRepository.save(modelMapper.map(color, ColorExtends.class));
            return new ResponseEntity<InsertColorDTO>(color,HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<InsertColorDTO>(color,HttpStatus.NOT_FOUND);
        }
    }
}
