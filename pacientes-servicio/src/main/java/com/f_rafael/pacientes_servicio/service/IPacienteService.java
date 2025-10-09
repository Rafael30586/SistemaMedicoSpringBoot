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
}
