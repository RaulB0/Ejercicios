package com.ejercicioSpring.service;

import com.ejercicioSpring.entity.entities.Categoria;
import com.ejercicioSpring.entity.entity_extends.CategoriaExtends;
import com.ejercicioSpring.model.CategoriaModel;
import com.ejercicioSpring.model.MensajeDTO;
import com.ejercicioSpring.repository.CategoriaRepository;
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

@Service("CategoriaServiceImp")
public class CategoriaServiceImp implements CategoriaService{
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    @Qualifier("CategoriaRepository")
    CategoriaRepository categoriaRepository;

    @Override
    public ResponseEntity<CategoriaModel> getCategoria(int codigo) {
        Categoria categoria = null;
        try {
            categoria = categoriaRepository.getOne(codigo);
            if(categoria != null){
                return new ResponseEntity<CategoriaModel>(modelMapper.map(categoria,CategoriaModel.class), HttpStatus.OK);
            }else{
                return new ResponseEntity<CategoriaModel>(new CategoriaModel(), HttpStatus.NOT_FOUND);
            }
        }catch(Exception e){

        }finally {
            categoria = null;
        }
        return new ResponseEntity<CategoriaModel>(new CategoriaModel(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<List<CategoriaModel>> getAllCategorias() {
        Type tipo = new TypeToken<List<CategoriaModel>>(){}.getType();
        List<CategoriaModel> listaCategorias;

        try {
            listaCategorias = modelMapper.map(categoriaRepository.findAll(),tipo);
            return new ResponseEntity<List<CategoriaModel>>(listaCategorias, HttpStatus.OK);

        }catch(Exception e){

        }finally {
            tipo = null;
            listaCategorias = null;
        }
        return new ResponseEntity<List<CategoriaModel>>(new ArrayList<CategoriaModel>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<CategoriaModel> insertCategoria(CategoriaModel categoriaModel) {
        categoriaModel.setCodigo(categoriaRepository.getLastCodigo());
        try {
            categoriaRepository.save(modelMapper.map(categoriaModel, CategoriaExtends.class));
            return new ResponseEntity<CategoriaModel>(categoriaModel, HttpStatus.OK);
        }catch(Exception e){

        }
        return new ResponseEntity<CategoriaModel>(new CategoriaModel(), HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @Override
    public ResponseEntity<MensajeDTO> deleteCategoria(int codigo) {
        try {
            categoriaRepository.deleteById(codigo);
            return new ResponseEntity<MensajeDTO>(new MensajeDTO("Borrado correctamente",200), HttpStatus.OK);
        }catch(Exception e){

        }
        return new ResponseEntity<MensajeDTO>(new MensajeDTO("No se encontro la categoria",404), HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<CategoriaModel> updateCategoria(CategoriaModel categoria) {

        try {
            if(!categoriaRepository.findById(categoria.getCodigo()).isPresent()) throw new Exception("No se encontro la categoria");
            categoriaRepository.save(modelMapper.map(categoria, CategoriaExtends.class));

            return new ResponseEntity<CategoriaModel>(categoria, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<CategoriaModel>(categoria, HttpStatus.NOT_FOUND);

        }

    }
}
