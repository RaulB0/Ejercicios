package com.ejercicioSpring.service;

import com.ejercicioSpring.entity.Producto;
import com.ejercicioSpring.model.ProductoModel;
import com.ejercicioSpring.repository.ProductoRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service("ProductoService")
public class ProductoService {

    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    @Qualifier("ProductoRepository")
    ProductoRepository productoRepository;

    public void showAll(){
        productoRepository.findAll().forEach(producto -> {
            ProductoModel productomodel = modelMapper.map(producto,ProductoModel.class);
            System.out.println("ProductoModelo");
            System.out.println(productomodel);
            System.out.println("-------------------");
        });

    }

    public void addProducto(ProductoModel productoModel){
        productoModel.setCodigo(productoRepository.getLastCodigo());
        productoRepository.save(modelMapper.map(productoModel, Producto.class));
    }

    public List<ProductoModel> getAllProductos(){
        Type tipo = new TypeToken<List<ProductoModel>>(){}.getType();
        return  modelMapper.map(productoRepository.findAll(),tipo);
    }

    public ProductoModel updateProducto(ProductoModel productoModel) {
        try{
            if(productoRepository.getOne(productoModel.getCodigo()) != null){
                System.out.println(productoRepository.getOne(productoModel.getCodigo()));
                return modelMapper.map(productoRepository.save(modelMapper.map(productoModel, Producto.class)),ProductoModel.class);
            }
        }catch(Exception e){
        }

        return null;


    }

    public ProductoModel getProducto(int codigo) {
        try {
            Producto producto = productoRepository.getOne(codigo);
            return  modelMapper.map(producto,ProductoModel.class);
        }catch(Exception e){

        }
        return null;








    }
}
