package com.f_rafael.pacientes_servicio.service;

import com.f_rafael.pacientes_servicio.dto.SubSedeDto;
import com.f_rafael.pacientes_servicio.model.Sede;

import java.util.List;

public interface ISedeService {
    public SubSedeDto buscarPorId(Long id);
    public List<SubSedeDto> buscarTodas();
    public SubSedeDto guardar(Sede sede);
    public SubSedeDto actualizar(Sede sede);
    public void borrarPorId(Long id);
    public List<SubSedeDto> buscarPorDireccion(String calle);
    public SubSedeDto buscarPortelefono(String telefono);

}
