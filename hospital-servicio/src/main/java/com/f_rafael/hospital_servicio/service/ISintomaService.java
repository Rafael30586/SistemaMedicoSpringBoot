package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.dto.SintomaDto;
import com.f_rafael.hospital_servicio.model.Sintoma;

import java.util.List;

public interface ISintomaService {

    public SintomaDto buscarPorId(Long id);
    public List<SintomaDto> buscarTodos();
    public SintomaDto guardar(Sintoma sintoma);
    public SintomaDto actualizar(Sintoma sintoma);
    public void borrarPorId(Long id);
    public SintomaDto buscarPorNombre(String nombre);
}
