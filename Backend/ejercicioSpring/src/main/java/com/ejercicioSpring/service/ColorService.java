package com.ejercicioSpring.service;

import com.ejercicioSpring.model.CategoriaModel;
import com.ejercicioSpring.model.ColorModel;
import com.ejercicioSpring.model.InsertColorDTO;

import java.util.List;

public interface ColorService {
    public ColorModel getColor(int codigo);
    public List<ColorModel> getAllColores();
    public InsertColorDTO insertColor(InsertColorDTO color) throws Exception;
    public void deleteColor(int codigo);
    public InsertColorDTO updateColor(InsertColorDTO color) throws Exception;
}
