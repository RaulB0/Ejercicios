package com.ejercicioSpring.service.procedures;

import com.ejercicioSpring.model.InsertProcedureModel;
import com.ejercicioSpring.model.MensajeDTO;
import com.ejercicioSpring.repository.procedures.InsertarProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service("InsertarProductoServiceImp")
public class InsertarProductoServiceImp implements  InsertarProductoService{
    @Autowired
    @Qualifier("InsertarProductoRepository")
    InsertarProductoRepository insertarProductoRepository;


    @Override
    public ResponseEntity<MensajeDTO> insertarProducto(InsertProcedureModel InsertProcedureModel) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String respuesta = null;
        try {
            respuesta = insertarProductoRepository.INSERTAR_PRODUCTO(
                    InsertProcedureModel.getCodigo(),
                    InsertProcedureModel.getNombre(),
                    InsertProcedureModel.getColor(),
                    sdf.parse(InsertProcedureModel.getFecha_creacion()));

            if(!respuesta.equals("")){
                return new ResponseEntity<>(new MensajeDTO(respuesta,404), HttpStatus.NOT_FOUND);
            }else{
                return new ResponseEntity<>(new MensajeDTO(respuesta,200), HttpStatus.OK);
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            sdf = null;
        }

        return new ResponseEntity<>(
                new MensajeDTO("Internal Server Error",500),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
