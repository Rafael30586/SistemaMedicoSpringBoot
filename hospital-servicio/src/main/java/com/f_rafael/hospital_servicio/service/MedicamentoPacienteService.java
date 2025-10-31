package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.dto.MedicamentoPacienteDto;
import com.f_rafael.hospital_servicio.exception.CampoNuloException;
import com.f_rafael.hospital_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.hospital_servicio.mapper.MedicamentoPacienteMapper;
import com.f_rafael.hospital_servicio.model.MedicamentoPaciente;
import com.f_rafael.hospital_servicio.repository.IMedicamentoPacienteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MedicamentoPacienteService implements IMedicamentoPacienteService{
    private MedicamentoPacienteMapper mapper;
    private IMedicamentoPacienteRepository repository;
    @Override
    public MedicamentoPacienteDto buscarPorId(Long id) {
        return mapper.obtenerDto(repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Tratamiento con medicamentoso no encontrado")));
    }

    @Override
    public List<MedicamentoPacienteDto> buscarTodos() {
        return mapper.obtenerListaDto(repository.findAll());
    }

    @Override
    public MedicamentoPacienteDto guardar(MedicamentoPaciente medicamentoPaciente) {

        if(medicamentoPaciente.getMedicamentoId() == null || medicamentoPaciente.getPacienteId() == null || medicamentoPaciente.getInicio() == null || medicamentoPaciente.getDosisId() == null){
            throw new CampoNuloException("Algunos campois de tratamiento medicamentoso no pueden ser nulos");
        }
        return mapper.obtenerDto(repository.save(medicamentoPaciente));
    }

    @Override
    public MedicamentoPacienteDto actualizar(MedicamentoPaciente medicamentoPaciente) {
        if(medicamentoPaciente.getDosisId() == null){
            throw new CampoNuloException("El id durante una actualización no puede ser nulo");
        }

        return this.guardar(medicamentoPaciente);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Tratamiento medicamentoso no encontrado");
        }

        repository.deleteById(id);
    }

    @Override
    public MedicamentoPacienteDto buscarPorPaciente(MedicamentoPaciente medicamentoPaciente) {
        return null;
    }

    @Override
    public MedicamentoPacienteDto buscarPorPrincipioActivo(String principioActivo) {
        return null;
    }

    @Override
    public MedicamentoPacienteDto buscarPorFechaDeInicio(LocalDate desde, LocalDate hasta) {
        return null;
    }

    @Override
    public MedicamentoPacienteDto BuscarPorFechaDeFinal(LocalDate desde, LocalDate hasta) {
        return null;
    }
}
