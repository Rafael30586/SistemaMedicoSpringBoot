package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.dto.RadioTerapiaPacienteDto;
import com.f_rafael.hospital_servicio.model.RadioTerapiaPaciente;

import java.util.List;

public interface IRadioTerapiaPacienteService {

    public RadioTerapiaPacienteDto buscarPorId(Long id);
    public List<RadioTerapiaPacienteDto> buscarTodas();
    public RadioTerapiaPacienteDto guardar(RadioTerapiaPaciente radioTerapiaPaciente);
    public RadioTerapiaPacienteDto actualizar(RadioTerapiaPaciente radioTerapiaPaciente);
    public void borrarPorId(Long id);
}
