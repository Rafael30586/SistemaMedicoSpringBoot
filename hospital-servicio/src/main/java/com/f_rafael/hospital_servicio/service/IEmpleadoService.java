package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.dto.EmpleadoDto;
import com.f_rafael.hospital_servicio.model.Empleado;

import java.util.List;

public interface IEmpleadoService {
    public EmpleadoDto buscarPorId(Long id);
    public List<EmpleadoDto> buscarTodos();
    public EmpleadoDto guardar(Empleado empleado);
    public EmpleadoDto actualizar(Empleado empleado);
    public void borrarPorId(Long id);
    public EmpleadoDto buscarPorDni(Long dni);
    
}
