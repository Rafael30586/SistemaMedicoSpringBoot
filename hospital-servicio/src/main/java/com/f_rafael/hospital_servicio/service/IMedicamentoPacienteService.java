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
    public List<MedicamentoPacienteDto> buscarPorPaciente(Long idODni, String opcion);
    public List<MedicamentoPacienteDto> buscarPorPrincipioActivo(String principioActivo);
    public List<MedicamentoPacienteDto> buscarPorFechaDeInicio(LocalDate desde, LocalDate hasta);
    public List<MedicamentoPacienteDto> buscarPorFechaDeFinal(LocalDate desde, LocalDate hasta);
    public MedicamentoPacienteDto modificarPaciente(Long id, Long idODni, String opcion);
    public MedicamentoPacienteDto modificarMedicamento(Long id, Long medicamentoId);
    public MedicamentoPacienteDto modificarDosis(Long id, Long dosisId);
    public MedicamentoPacienteDto moficarFechaDeInicio(Long id, LocalDate inicio);
    public MedicamentoPacienteDto modificarFechaDeFinal(Long id, LocalDate fin);
}
