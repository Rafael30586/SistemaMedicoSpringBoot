package com.f_rafael.pacientes_servicio.service;

import com.f_rafael.pacientes_servicio.dto.SedeDto;
import com.f_rafael.pacientes_servicio.model.Sede;

import java.util.List;

public interface ISedeService {
    public SedeDto buscarPorId(Long id);
    public List<SedeDto> buscarTodas();
    public SedeDto guardar(Sede sede);
    public SedeDto actualizar(Sede sede);
    public void borrarPorId(Long id);
    public List<SedeDto> buscarPorDireccion(String calle);
    public SedeDto buscarPortelefono(String telefono);

}
