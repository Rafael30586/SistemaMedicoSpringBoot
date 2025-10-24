package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.dto.FisioterapiaPacienteDto;
import com.f_rafael.hospital_servicio.exception.CampoNuloException;
import com.f_rafael.hospital_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.hospital_servicio.mapper.FisioterapiaPacienteMapper;
import com.f_rafael.hospital_servicio.model.FisioterapiaPaciente;
import com.f_rafael.hospital_servicio.repository.IFisioterapiaPacienteRepository;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FisioterapiaPacienteService implements IFisioterapiaPacienteService{

    private IFisioterapiaPacienteRepository repository;
    private FisioterapiaPacienteMapper mapper;
    @Override
    public FisioterapiaPacienteDto buscarPorId(Long id) {
        return mapper.obtenerDto(repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Fisioterapia para paciente no encontrada")));
    }

    @Override
    public List<FisioterapiaPacienteDto> buscarTodas() {
        return mapper.obtenerListaDto(repository.findAll());
    }

    @Override
    public FisioterapiaPacienteDto guardar(FisioterapiaPaciente fisioterapiaPaciente) {

        if(fisioterapiaPaciente.getPacienteId() == null || fisioterapiaPaciente.getInicio() == null){
            throw new CampoNuloException("Algunos campos de fisioterapia para paciente no pueden ser nulos");
        }
        return mapper.obtenerDto(repository.save(fisioterapiaPaciente));
    }

    @Override
    public FisioterapiaPacienteDto actualizar(FisioterapiaPaciente fisioterapiaPaciente) {

        if(fisioterapiaPaciente.getId() == null){
            throw new CampoNuloException("El id no puede ser nulo durante una actualización");
        }
        return this.guardar(fisioterapiaPaciente);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("La fisioterapia para paciente solicitada no se encuntra");
        }

        repository.deleteById(id);
    }
}
