package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.dto.PsicoterapiaPacienteDto;
import com.f_rafael.hospital_servicio.model.PsicoterapiaPaciente;

import java.util.List;

public interface IPsicoterapiaPacienteService {

    public PsicoterapiaPacienteDto buscarPorId(Long id);
    public List<PsicoterapiaPacienteDto> buscarTodas();
    public PsicoterapiaPacienteDto guardar(PsicoterapiaPaciente psicoterapiaPaciente);
    public PsicoterapiaPacienteDto actualizar(PsicoterapiaPaciente psicoterapiaPaciente);
    public void borrarPorId(Long id);
}
