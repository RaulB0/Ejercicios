package com.ejercicioSpring.service;

import com.ejercicioSpring.entity.entity_extends.ProductoExtends;
import com.ejercicioSpring.model.InsertProcedureModel;
import com.ejercicioSpring.model.ProductoModel;
import com.ejercicioSpring.model.functionDTO;
import com.ejercicioSpring.repository.ProductoRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service("ProcedureServiceImp")
public class ProcedureServiceImp implements ProcedureService {

    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    @Qualifier("ProductoRepository")
    ProductoRepository productoRepository;

    @Override
    public String insertarProducto(InsertProcedureModel InsertProcedureModel) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String respuesta = null;
        try {
            respuesta = productoRepository.INSERTAR_PRODUCTO(
                    InsertProcedureModel.getCodigo(),
                    InsertProcedureModel.getNombre(),
                    InsertProcedureModel.getColor(),
                    sdf.parse(InsertProcedureModel.getFecha_creacion()));
            return respuesta;
        }catch (Exception e){
            e.printStackTrace();
        }

        return respuesta;


    }

    @Override
    public String borrarProducto(int codigo) {
        return productoRepository.BORRAR_PRODUCTO(codigo);
    }

    @Override
    public functionDTO funcionAllProductosByCategoria(String categoria) {


        return  new functionDTO(productoRepository.functionProductosByCategory(categoria));
    }


}
