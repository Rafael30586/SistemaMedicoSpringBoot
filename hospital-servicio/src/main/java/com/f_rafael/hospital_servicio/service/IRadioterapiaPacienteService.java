package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.dto.RadioTerapiaPacienteDto;
import com.f_rafael.hospital_servicio.model.RadioterapiaPaciente;

import java.time.LocalDate;
import java.util.List;

public interface IRadioterapiaPacienteService {

    public RadioTerapiaPacienteDto buscarPorId(Long id);
    public List<RadioTerapiaPacienteDto> buscarTodas();
    public RadioTerapiaPacienteDto guardar(RadioterapiaPaciente radioTerapiaPaciente);
    public RadioTerapiaPacienteDto actualizar(RadioterapiaPaciente radioTerapiaPaciente);
    public void borrarPorId(Long id);
    public List<RadioTerapiaPacienteDto> buscarPorPaciente(Long idODni, String opcion);
    public List<RadioTerapiaPacienteDto> buscarPorFechaInicio(LocalDate desde, LocalDate hasta);
    public List<RadioTerapiaPacienteDto> buscarPorFechaFinal(LocalDate desde, LocalDate hasta);
    public RadioTerapiaPacienteDto modificarPaciente(Long id, Long pacienteIdODni, String opcion);
    public RadioTerapiaPacienteDto modificarFechaDeInicio(Long id, LocalDate inicio);
    public RadioTerapiaPacienteDto modificarFechaDeFinal(Long id, LocalDate fin);
}
