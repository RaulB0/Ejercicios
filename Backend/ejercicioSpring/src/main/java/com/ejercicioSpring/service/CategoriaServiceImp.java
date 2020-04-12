package com.ejercicioSpring.service;

import com.ejercicioSpring.entity.Categoria;
import com.ejercicioSpring.entity.Producto;
import com.ejercicioSpring.model.CategoriaModel;
import com.ejercicioSpring.model.ProductoModel;
import com.ejercicioSpring.repository.CategoriaRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service("CategoriaServiceImp")
public class CategoriaServiceImp implements CategoriaService{
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    @Qualifier("CategoriaRepository")
    CategoriaRepository categoriaRepository;

    @Override
    public CategoriaModel getCategoria(int codigo) {
        try {
            Categoria categoria = categoriaRepository.getOne(codigo);
            return  modelMapper.map(categoria,CategoriaModel.class);
        }catch(Exception e){

        }
        return null;
    }

    @Override
    public List<CategoriaModel> getAllCategorias() {
        Type tipo = new TypeToken<List<CategoriaModel>>(){}.getType();
        return  modelMapper.map(categoriaRepository.findAll(),tipo);
    }

    @Override
    public CategoriaModel insertCategoria(CategoriaModel categoriaModel) throws Exception {
        categoriaModel.setCodigo(categoriaRepository.getLastCodigo());
        categoriaRepository.save(modelMapper.map(categoriaModel, Categoria.class));
        return categoriaModel;

    }

    @Override
    public void deleteCategoria(int codigo) {
        categoriaRepository.deleteById(codigo);
    }

    @Override
    public CategoriaModel updateCategoria(CategoriaModel categoria) throws Exception {
        if(!categoriaRepository.findById(categoria.getCodigo()).isPresent()) throw new Exception("No se encontro la categoria");
        categoriaRepository.save(modelMapper.map(categoria, Categoria.class));
        return categoria;
    }
}
