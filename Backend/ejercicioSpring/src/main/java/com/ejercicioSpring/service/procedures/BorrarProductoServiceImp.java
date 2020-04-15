package com.ejercicioSpring.service.procedures;

import com.ejercicioSpring.model.MensajeDTO;
import com.ejercicioSpring.repository.procedures.BorrarProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

@Service("BorrarProductoServiceImp")
public class BorrarProductoServiceImp implements BorrarProductoService{

    @Autowired
    @Qualifier("BorrarProductoRepository")
    BorrarProductoRepository borrarProductoRepository;

    @Override
    public ResponseEntity<MensajeDTO> borrarProducto(int codigo) {
        String respuesta = null;
        try {
            respuesta = borrarProductoRepository.BORRAR_PRODUCTO(codigo);
            System.out.println(respuesta);

            if(!respuesta.equals("")){
                return new ResponseEntity<>(new MensajeDTO(respuesta,404), HttpStatus.NOT_FOUND);
            }else{
                return new ResponseEntity<>(new MensajeDTO(respuesta,200), HttpStatus.OK);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return new ResponseEntity<>(
                new MensajeDTO("Internal Server Error",500),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
