package com.ejercicioSpring.service;

import com.ejercicioSpring.entity.entities.Color;
import com.ejercicioSpring.entity.entity_extends.ColorExtends;
import com.ejercicioSpring.model.CategoriaModel;
import com.ejercicioSpring.model.ColorModel;
import com.ejercicioSpring.model.InsertColorDTO;
import com.ejercicioSpring.repository.ColorRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service("ColorServiceImp")
public class ColorServiceImp implements ColorService {
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    @Qualifier("ColorRepository")
    ColorRepository colorRepository;

    @Override
    public ColorModel getColor(int codigo) {
        try {
            Color color = colorRepository.getOne(codigo);
            return  modelMapper.map(color, ColorModel.class);
        }catch(Exception e){

        }
        return null;
    }

    @Override
    public List<ColorModel> getAllColores() {
        Type tipo = new TypeToken<List<CategoriaModel>>(){}.getType();
        return  modelMapper.map(colorRepository.findAll(),tipo);
    }

    @Override
    public InsertColorDTO insertColor(InsertColorDTO color) throws Exception {
        color.setCodigo(colorRepository.getLastCodigo());
        colorRepository.save(modelMapper.map(color, ColorExtends.class));
        return color;
    }

    @Override
    public void deleteColor(int codigo) {
        colorRepository.deleteById(codigo);

    }

    @Override
    public InsertColorDTO updateColor(InsertColorDTO color) throws Exception {
        if(!colorRepository.findById(color.getCodigo()).isPresent()) throw new Exception("No se encontro el color");
        colorRepository.save(modelMapper.map(color, ColorExtends.class));
        return color;
    }
}
