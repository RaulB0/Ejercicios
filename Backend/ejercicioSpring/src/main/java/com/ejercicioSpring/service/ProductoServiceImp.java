package com.ejercicioSpring.service;

import com.ejercicioSpring.entity.*;
import com.ejercicioSpring.model.InsertProductoDTO;
import com.ejercicioSpring.model.ProductoModel;
import com.ejercicioSpring.repository.CategoriaRepository;
import com.ejercicioSpring.repository.ColorRepository;
import com.ejercicioSpring.repository.ProductoCategoriaRepository;
import com.ejercicioSpring.repository.ProductoRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Autowired
    @Qualifier("ProductoCategoriaRepository")
    ProductoCategoriaRepository productoCategoriaRepository;



    public InsertProductoDTO insertProducto(InsertProductoDTO insertProductoDTO) throws Exception {
        insertProductoDTO.setCodigo(productoRepository.getLastCodigo());
        Producto producto = new Producto();


        if(insertProductoDTO.getColor() != 0){
            Optional<Color> color = colorRepository.findById(insertProductoDTO.getColor());
            if(!color.isPresent()) throw new Exception("No se encontro el color");
            producto.setColor(color.get());
        }

        producto.setNombre(insertProductoDTO.getNombre());
        producto.setFecha_creacion(insertProductoDTO.getFecha_creacion());
        producto.setCodigo(insertProductoDTO.getCodigo());

        productoRepository.save(producto);

        if(insertProductoDTO.getListaCategorias() != null){
            List<ProductoCategoria> listaProductoCategoria = CheckAndGetProductoCategorias(insertProductoDTO.getListaCategorias(), producto);

            productoCategoriaRepository.saveAll(listaProductoCategoria);

        }



        return insertProductoDTO;
    }

    private List<ProductoCategoria> CheckAndGetProductoCategorias(int[] ListaidCategorias, Producto producto) throws Exception {
        List<Categoria> listaCategoria = new ArrayList<>();
        for (int categoriaCodigo:ListaidCategorias ) {
            Optional<Categoria> categoria = categoriaRepository.findById(categoriaCodigo);
            if(!categoria.isPresent()) throw new Exception("No se encontro la categoria");
            listaCategoria.add(categoria.get());

        }
        List<ProductoCategoria> listaProductoCategoria = new ArrayList<>();
        for (Categoria categoria : listaCategoria) {
            listaProductoCategoria.add(
                    new ProductoCategoria(
                            new ProductoCategoriaId(producto,categoria)));
        }
        return listaProductoCategoria;
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
        List<Producto> listaProductos = productoRepository.findAll();
        List<Producto> productosFiltrados = new ArrayList<>();
        for (Producto producto : listaProductos){
            for(ProductoCategoria proCat: producto.getListaCategorias()){
                if(proCat.getProductoCategoriaId().getCategoria().getCodigo() == codigo){
                    productosFiltrados.add(producto);
                    break;
                }
            }
        }

        return  modelMapper.map(productosFiltrados,tipo);
    }

    public InsertProductoDTO updateProducto(InsertProductoDTO productoDTO) {
        try{
            if(productoRepository.getOne(productoDTO.getCodigo()) == null) throw new Exception("No se encontro el producto");

            Producto producto = new Producto();
            if(productoDTO.getColor() != 0){
                Optional<Color> color = colorRepository.findById(productoDTO.getColor());
                if(!color.isPresent()) throw new Exception("No se encontro el color");
                producto.setColor(color.get());
            }

            producto.setNombre(productoDTO.getNombre());
            producto.setFecha_creacion(productoDTO.getFecha_creacion());
            producto.setCodigo(productoDTO.getCodigo());

            productoRepository.save(producto);

            if(productoDTO.getListaCategorias() != null){
                List<ProductoCategoria> listaProductoCategoria = CheckAndGetProductoCategorias(productoDTO.getListaCategorias(), producto);

                productoCategoriaRepository.saveAll(listaProductoCategoria);

            }else{
                productoCategoriaRepository.deleteAll(producto.getListaCategorias());
            }

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
