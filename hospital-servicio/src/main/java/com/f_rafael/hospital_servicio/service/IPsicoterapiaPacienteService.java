package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.dto.PsicoterapiaPacienteDto;
import com.f_rafael.hospital_servicio.model.PsicoterapiaPaciente;

import java.time.LocalDate;
import java.util.List;

public interface IPsicoterapiaPacienteService {

    public PsicoterapiaPacienteDto buscarPorId(Long id);
    public List<PsicoterapiaPacienteDto> buscarTodas();
    public PsicoterapiaPacienteDto guardar(PsicoterapiaPaciente psicoterapiaPaciente);
    public PsicoterapiaPacienteDto actualizar(PsicoterapiaPaciente psicoterapiaPaciente);
    public void borrarPorId(Long id);
    public List<PsicoterapiaPacienteDto> buscarPorPaciente(Long idODni, String opcion);
    public List<PsicoterapiaPacienteDto> buscarPorFechaDeInicio(LocalDate desde, LocalDate hasta);
    public List<PsicoterapiaPacienteDto> buscarPorFechaDeFinal(LocalDate desde, LocalDate hasta);
}
