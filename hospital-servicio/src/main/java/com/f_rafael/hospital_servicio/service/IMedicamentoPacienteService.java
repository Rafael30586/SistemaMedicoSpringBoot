package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.dto.MedicamentoPacienteDto;
import com.f_rafael.hospital_servicio.model.MedicamentoPaciente;

import java.util.List;

public interface IMedicamentoPacienteService {

    public MedicamentoPacienteDto buscarPorId(Long id);
    public List<MedicamentoPacienteDto> buscarTodos();
    public MedicamentoPacienteDto guardar(MedicamentoPaciente medicamentoPaciente);
    public MedicamentoPacienteDto actualizar(MedicamentoPaciente medicamentoPaciente);
    public void borrarPorId(Long id);
}
