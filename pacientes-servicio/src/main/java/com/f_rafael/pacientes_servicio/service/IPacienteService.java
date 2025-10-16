package com.f_rafael.pacientes_servicio.service;

import com.f_rafael.pacientes_servicio.dto.PacienteDto;
import com.f_rafael.pacientes_servicio.model.Paciente;

import java.time.LocalDate;
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
    public PacienteDto actulizarDni(Long id, Long dni);
    public PacienteDto actulizarPrimerNombre(Long idODni,String opcion, String primerNombre);
    public PacienteDto actulizarSegundoNombre(Long idODni,String opcion, String segundoNombre);
    public PacienteDto actulizarApellidoPaterno(Long idODni,String opcion, String apellidoPaterno);
    public PacienteDto actualizarApellidoMaterno(Long idODni,String opcion, String apellidoMaterno);
    public PacienteDto actualizarEmail(Long idODni,String opcion, String email);
    public PacienteDto agregarNumeroTelefonico(Long id, Long telefonoId);
    public PacienteDto quitarNumeroTelefonico(Long id, Long telefonoId);
    public PacienteDto actualizarFechaNacimiento(Long idODni,String opcion, LocalDate fechaNacimiento);
    public PacienteDto actualizarLugarNacimiento(Long idODni,String opcion, Long localidadId);
    public PacienteDto actualizarDomicilio(Long idODni,String opcion, Long direccionId);
    public PacienteDto actualizarObraSocial(Long idODni,String opcion, Long obraSocialId);
}
