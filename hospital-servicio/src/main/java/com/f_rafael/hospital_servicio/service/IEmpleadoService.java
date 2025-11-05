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
    public List<EmpleadoDto> buscarPorNombre(String nombre);
    public List<EmpleadoDto> buscarPorApellido(String apellido);
    public EmpleadoDto buscarPorEmail(String email);
    public EmpleadoDto buscarPorMatriculaProfesional(String matricula);
    public List<EmpleadoDto> buscarPorRol(String rol);
    public List<EmpleadoDto> buscarPorRangoSalarial(Float minimo, Float maximo);
    public EmpleadoDto modificarDni(Long id, Long dni);
    public EmpleadoDto modificarPrimerNombre(Long id, String nombre);
    public EmpleadoDto modificarSegundoNombre(Long id, String nombre);
    public EmpleadoDto modificarApellidoPaterno(Long id, String apellido);
    public EmpleadoDto modificarApellidoMaterno(Long id, String apellido);
    public EmpleadoDto modificarEmail(Long id, String email);
    public EmpleadoDto modificarDomicilio(Long id, Long domicilioId);
    public EmpleadoDto agregarTelefono(Long id, String telefono);
    public EmpleadoDto quitarTelefono(Long id, String telefono);
    public EmpleadoDto modificarMatriculaProfesional(Long id, String matricula);
    public EmpleadoDto modificarRol(Long id, Long rolId);
    public EmpleadoDto modificarSalario(Long id, Float salario);
}
