package com.ejercicioSpring.service;

import com.ejercicioSpring.entity.entities.*;
import com.ejercicioSpring.entity.entity_extends.ColorExtends;
import com.ejercicioSpring.entity.entity_extends.ProductoExtends;
import com.ejercicioSpring.model.InsertProductoDTO;
import com.ejercicioSpring.model.ProductoModel;
import com.ejercicioSpring.repository.CategoriaRepository;
import com.ejercicioSpring.repository.ColorRepository;
import com.ejercicioSpring.repository.ProductoRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service("ProductoServiceImp")
public class ProductoServiceImp  implements ProductoService{

    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    @Qualifier("ProductoRepository")
    ProductoRepository productoRepository;

    @Autowired
    @Qualifier("CategoriaRepository")
    CategoriaRepository categoriaRepository;

    @Autowired
    @Qualifier("ColorRepository")
    ColorRepository colorRepository;




    public InsertProductoDTO insertProducto(InsertProductoDTO insertProductoDTO) throws Exception {
        insertProductoDTO.setCodigo(productoRepository.getLastCodigo());
        ProductoExtends producto = new ProductoExtends();


        if(insertProductoDTO.getColor() != 0){
            Optional<ColorExtends> color = colorRepository.findById(insertProductoDTO.getColor());
            if(!color.isPresent()) throw new Exception("No se encontro el color");
            producto.setColor(color.get());
        }

        producto.setNombre(insertProductoDTO.getNombre());
        producto.setFecha_creacion(insertProductoDTO.getFecha_creacion());
        producto.setCodigo(insertProductoDTO.getCodigo());

        productoRepository.save(producto);


        return insertProductoDTO;
    }



    @Override
    public void deleteProducto(int codigo) {
        productoRepository.deleteById(codigo);
    }

    public List<ProductoModel> getAllProductos(){
        Type tipo = new TypeToken<List<ProductoModel>>(){}.getType();
        return  modelMapper.map(productoRepository.findAll(),tipo);
    }

    @Override
    public List<ProductoModel> getProductosByCategory(int codigo) {

        Type tipo = new TypeToken<List<ProductoModel>>(){}.getType();
        List<ProductoExtends> listaProductos = productoRepository.getProductosByCategory(codigo);
        return  modelMapper.map(listaProductos,tipo);
    }

    public InsertProductoDTO updateProducto(InsertProductoDTO productoDTO) {
        try{
            if(productoRepository.getOne(productoDTO.getCodigo()) == null) throw new Exception("No se encontro el producto");

            ProductoExtends producto = new ProductoExtends();
            if(productoDTO.getColor() != 0){
                Optional<ColorExtends> color = colorRepository.findById(productoDTO.getColor());
                if(!color.isPresent()) throw new Exception("No se encontro el color");
                producto.setColor(color.get());
            }

            producto.setNombre(productoDTO.getNombre());
            producto.setFecha_creacion(productoDTO.getFecha_creacion());
            producto.setCodigo(productoDTO.getCodigo());

            productoRepository.save(producto);



            return productoDTO;
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