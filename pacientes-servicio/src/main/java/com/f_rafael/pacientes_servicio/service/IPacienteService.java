package com.f_rafael.pacientes_servicio.service;

import com.f_rafael.pacientes_servicio.dto.PacienteDto;
import com.f_rafael.pacientes_servicio.model.Paciente;

import java.util.List;

public interface IPacienteService {
    public PacienteDto buscarPorId(Long id);
    public List<PacienteDto> buscarTodos();
    public PacienteDto guardar(Paciente paciente);
    public PacienteDto actualizar(Paciente paciente);
    public void borrarPorId(Long id);
    public PacienteDto buscarPorDni(Long dni);
    public List<PacienteDto> buscarPorNombre(String nombre);
    public List<PacienteDto> buscarPorApellido(String apellido);
    public PacienteDto buscarPorEmail(String email);
    public PacienteDto buscarPorNumeroTelefonico(String numero);
    public List<PacienteDto> buscarPorIntervaloNacimiento(Integer desde, Integer hasta);
    public List<PacienteDto> buscarPorLugarNacimiento(String localidad);
    public List<PacienteDto> buscarPorDomicilio(String calle);
}
