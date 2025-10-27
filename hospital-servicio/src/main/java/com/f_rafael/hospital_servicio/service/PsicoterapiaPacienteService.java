package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.dto.PsicoterapiaPacienteDto;
import com.f_rafael.hospital_servicio.exception.CampoNuloException;
import com.f_rafael.hospital_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.hospital_servicio.mapper.PsicotearpiaPacienteMapper;
import com.f_rafael.hospital_servicio.model.PsicoterapiaPaciente;
import com.f_rafael.hospital_servicio.repository.IPsicoterapiaPacienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PsicoterapiaPacienteService implements IPsicoterapiaPacienteService{

    private PsicotearpiaPacienteMapper mapper;
    private IPsicoterapiaPacienteRepository repository;
    @Override
    public PsicoterapiaPacienteDto buscarPorId(Long id) {
        return mapper.obtenerDto(repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("El tratamiento no se ha encontrado")));
    }

    @Override
    public List<PsicoterapiaPacienteDto> buscarTodas() {
        return mapper.obtenerListaDto(repository.findAll());
    }

    @Override
    public PsicoterapiaPacienteDto guardar(PsicoterapiaPaciente psicoterapiaPaciente) {

        if(psicoterapiaPaciente.getPacienteId() == null || psicoterapiaPaciente.getInicio() == null){
            throw new CampoNuloException("Algunos campos de tratamiento por psicoterapia no pueden ser nulos");
        }

        return mapper.obtenerDto(repository.save(psicoterapiaPaciente));
    }

    @Override
    public PsicoterapiaPacienteDto actualizar(PsicoterapiaPaciente psicoterapiaPaciente) {

        if(psicoterapiaPaciente.getId() == null){
            throw new CampoNuloException("El id no puede ser nulo durante una actualización");
        }

        return this.guardar(psicoterapiaPaciente);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Tratamiento por psicoterapia no encontrado");
        }

        repository.deleteById(id);
    }
}
