package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.dto.CirugiaPacienteDto;
import com.f_rafael.hospital_servicio.model.CirugiaPaciente;
import lombok.Setter;

import java.util.List;


public interface ICirugiaPacienteService {

    public CirugiaPacienteDto buscarPorId(Long id);
    public List<CirugiaPacienteDto> buscarTodos();
    public CirugiaPacienteDto guardar(CirugiaPaciente cirugiaPaciente);
    public CirugiaPacienteDto actualizar(CirugiaPaciente cirugiaPaciente);
    public void borrarPorId(Long id);
}
