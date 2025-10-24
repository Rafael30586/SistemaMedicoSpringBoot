package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.dto.FisioterapiaPacienteDto;
import com.f_rafael.hospital_servicio.model.FisioterapiaPaciente;

import java.util.List;

public interface IFisioterapiaPacienteService {

    public FisioterapiaPacienteDto buscarPorId(Long id);
    public List<FisioterapiaPacienteDto> buscarTodas();
    public FisioterapiaPacienteDto guardar(FisioterapiaPaciente fisioterapiaPaciente);
    public FisioterapiaPacienteDto actualizar(FisioterapiaPaciente fisioterapiaPaciente);
    public void borrarPorId(Long id);
}
