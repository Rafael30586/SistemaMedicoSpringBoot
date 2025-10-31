package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.dto.MedicamentoPacienteDto;
import com.f_rafael.hospital_servicio.model.MedicamentoPaciente;

import java.time.LocalDate;
import java.util.List;

public interface IMedicamentoPacienteService {

    public MedicamentoPacienteDto buscarPorId(Long id);
    public List<MedicamentoPacienteDto> buscarTodos();
    public MedicamentoPacienteDto guardar(MedicamentoPaciente medicamentoPaciente);
    public MedicamentoPacienteDto actualizar(MedicamentoPaciente medicamentoPaciente);
    public void borrarPorId(Long id);
    public MedicamentoPacienteDto buscarPorPaciente(MedicamentoPaciente medicamentoPaciente);
    public MedicamentoPacienteDto buscarPorPrincipioActivo(String principioActivo);
    public MedicamentoPacienteDto buscarPorFechaDeInicio(LocalDate desde, LocalDate hasta);
    public MedicamentoPacienteDto BuscarPorFechaDeFinal(LocalDate desde, LocalDate hasta);
}
