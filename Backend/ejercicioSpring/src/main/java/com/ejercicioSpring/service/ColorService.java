package com.ejercicioSpring.service;

import com.ejercicioSpring.model.CategoriaModel;
import com.ejercicioSpring.model.ColorModel;
import com.ejercicioSpring.model.InsertColorDTO;
import com.ejercicioSpring.model.MensajeDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ColorService {
    public ResponseEntity<ColorModel> getColor(int codigo);
    public ResponseEntity<List<ColorModel>> getAllColores();
    public ResponseEntity<InsertColorDTO> insertColor(InsertColorDTO color);
    public ResponseEntity<MensajeDTO> deleteColor(int codigo);
    public ResponseEntity<InsertColorDTO> updateColor(InsertColorDTO color);
}
