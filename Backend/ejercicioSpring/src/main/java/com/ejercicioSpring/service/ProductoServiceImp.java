package com.ejercicioSpring.service;

import com.ejercicioSpring.entity.entities.*;
import com.ejercicioSpring.entity.entity_extends.CategoriaExtends;
import com.ejercicioSpring.entity.entity_extends.ColorExtends;
import com.ejercicioSpring.entity.entity_extends.ProductoExtends;
import com.ejercicioSpring.model.*;
import com.ejercicioSpring.repository.CategoriaRepository;
import com.ejercicioSpring.repository.ColorRepository;
import com.ejercicioSpring.repository.ProductoRepository;
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




    public ResponseEntity<InsertProductoDTO> insertProducto(InsertProductoDTO insertProductoDTO){
        insertProductoDTO.setCodigo(productoRepository.getLastCodigo());
        ProductoExtends producto = new ProductoExtends();
        try {
            if(insertProductoDTO.getColor() != 0){
                Optional<ColorExtends> color = colorRepository.findById(insertProductoDTO.getColor());
                if(!color.isPresent()) throw new Exception("No se encontro el color");
                producto.setColor(color.get());
                color = null;
            }

            producto.setNombre(insertProductoDTO.getNombre());
            producto.setFecha_creacion(insertProductoDTO.getFecha_creacion());
            producto.setCodigo(insertProductoDTO.getCodigo());

            productoRepository.save(producto);
            return new ResponseEntity<InsertProductoDTO>(insertProductoDTO, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<InsertProductoDTO>(insertProductoDTO, HttpStatus.NOT_FOUND);

        }finally {
            producto = null;
        }
    }


    @Override
    public ResponseEntity<MensajeDTO> deleteProducto(int codigo) {
        try {
            productoRepository.deleteById(codigo);
            return new ResponseEntity<MensajeDTO>(new MensajeDTO("Borrado correctamente",200), HttpStatus.OK);
        }catch(Exception e){

        }
        return new ResponseEntity<MensajeDTO>(new MensajeDTO("No se encontro el producto",404), HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List<ProductoModel>> getAllProductos(){
        Type tipo = new TypeToken<List<ProductoModel>>(){}.getType();
        List<ProductoModel> listaProductos;

        try {
            listaProductos = modelMapper.map(productoRepository.findAll(),tipo);
            return new ResponseEntity<List<ProductoModel>>(listaProductos,HttpStatus.OK);
        }catch (Exception e){
        }finally {
            tipo = null;
            listaProductos = null;
        }
        return new ResponseEntity<List<ProductoModel>>(new ArrayList<ProductoModel>(),HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @Override
    public ResponseEntity<List<ProductoModel>> getProductosByCategory(int codigo) {
        Type tipo = new TypeToken<List<ProductoModel>>(){}.getType();
        List<ProductoExtends> listaProductos;
        List<ProductoModel> lista;
        try {
            listaProductos = productoRepository.getProductosByCategory(codigo);
            lista = modelMapper.map(listaProductos,tipo);
            return new ResponseEntity<List<ProductoModel>>(lista,HttpStatus.OK);
        }catch (Exception e){
        }finally {
            tipo = null;
            listaProductos = null;
            lista = null;
        }
        return new ResponseEntity<List<ProductoModel>>(new ArrayList<ProductoModel>(),HttpStatus.INTERNAL_SERVER_ERROR);
    }


    public ResponseEntity<InsertProductoDTO> updateProducto(InsertProductoDTO productoDTO) {
        ProductoExtends producto;
        List<CategoriaExtends> listaCategorias;
        try{
            producto = productoRepository.getOne(productoDTO.getCodigo());
            listaCategorias = new ArrayList<>();

            if(producto == null) throw new Exception("No se encontro el producto");

            if(productoDTO.getColor() != 0){
                Optional<ColorExtends> color = colorRepository.findById(productoDTO.getColor());
                if(!color.isPresent()) throw new Exception("No se encontro el color");
                producto.setColor(color.get());
                color = null;
            }
            if(producto.getListaCategorias() != null){
                for (int codigoCategoria: productoDTO.getListaCategorias()){
                    listaCategorias.add(categoriaRepository.getOne(codigoCategoria));
                }
            }

            producto.setNombre(productoDTO.getNombre());
            producto.setFecha_creacion(productoDTO.getFecha_creacion());
            producto.setCodigo(productoDTO.getCodigo());
            producto.setListaCategorias(listaCategorias);

            productoRepository.save(producto);


            return new ResponseEntity<InsertProductoDTO>(productoDTO, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<InsertProductoDTO>(productoDTO, HttpStatus.NOT_FOUND);
        }finally {
            producto = null;
            listaCategorias = null;
        }
    }


    public ResponseEntity<ProductoModel> getProducto(int codigo) {
        Producto producto = null;
        try {
            producto = productoRepository.getOne(codigo);
            if(producto == null){
                return new ResponseEntity<ProductoModel>(modelMapper.map(new ProductoModel(),ProductoModel.class),HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<ProductoModel>(modelMapper.map(producto,ProductoModel.class),HttpStatus.OK);
        }catch(Exception e){

        }finally {
            producto = null;
        }
        return new ResponseEntity<ProductoModel>(modelMapper.map(new ProductoModel(),ProductoModel.class),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}