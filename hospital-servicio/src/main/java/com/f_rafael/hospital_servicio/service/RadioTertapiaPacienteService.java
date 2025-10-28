package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.dto.RadioTerapiaPacienteDto;
import com.f_rafael.hospital_servicio.exception.CampoNuloException;
import com.f_rafael.hospital_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.hospital_servicio.mapper.RadioTerapiaPacienteMapper;
import com.f_rafael.hospital_servicio.model.RadioTerapiaPaciente;
import com.f_rafael.hospital_servicio.repository.IRadioTerapiaPacienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RadioTertapiaPacienteService implements IRadioTerapiaPacienteService{

    private IRadioTerapiaPacienteRepository repository;
    private RadioTerapiaPacienteMapper mapper;

    @Override
    public RadioTerapiaPacienteDto buscarPorId(Long id) {
        return mapper.obtenerDto(repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Tratamiento por radio terapia no encontrado")));
    }

    @Override
    public List<RadioTerapiaPacienteDto> buscarTodas() {
        return mapper.obtenerListaDto(repository.findAll());
    }

    @Override
    public RadioTerapiaPacienteDto guardar(RadioTerapiaPaciente radioTerapiaPaciente) {

        if(radioTerapiaPaciente.getPacienteId() == null || radioTerapiaPaciente.getInicio() == null){
            throw new CampoNuloException("Algunos campos de tratamiento por radioterapia no pueden ser nulos");
        }
        return mapper.obtenerDto(repository.save(radioTerapiaPaciente));
    }

    @Override
    public RadioTerapiaPacienteDto actualizar(RadioTerapiaPaciente radioTerapiaPaciente) {

        if(radioTerapiaPaciente.getId() == null){
            throw new CampoNuloException("El id no puede ser nulo duarnte una actualización");
        }

        return this.guardar(radioTerapiaPaciente);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("El tratamiento por radio terapia no ha sido encontrado");
        }

        repository.deleteById(id);
    }
}
