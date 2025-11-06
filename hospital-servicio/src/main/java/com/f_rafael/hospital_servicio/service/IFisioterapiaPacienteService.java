package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.dto.FisioterapiaPacienteDto;
import com.f_rafael.hospital_servicio.model.FisioterapiaPaciente;

import java.time.LocalDate;
import java.util.List;

public interface IFisioterapiaPacienteService {

    public FisioterapiaPacienteDto buscarPorId(Long id);
    public List<FisioterapiaPacienteDto> buscarTodas();
    public FisioterapiaPacienteDto guardar(FisioterapiaPaciente fisioterapiaPaciente);
    public FisioterapiaPacienteDto actualizar(FisioterapiaPaciente fisioterapiaPaciente);
    public void borrarPorId(Long id);
    public List<FisioterapiaPacienteDto> buscarPorPaciente(Long idODni, String opcion);
    public List<FisioterapiaPacienteDto> buscarPorFechaDeInicio(LocalDate desde, LocalDate hasta);
    public List<FisioterapiaPacienteDto> buscarPorFechaDeFinal(LocalDate desde, LocalDate hasta);
    public FisioterapiaPacienteDto modificarPaciente(Long id, Long idODni, String opcion);
    public FisioterapiaPacienteDto modificarFechaDeInicio(Long id, LocalDate inicio);
    public FisioterapiaPacienteDto modificareFechaDeFinal(Long id, LocalDate fin);
}
