package com.f_rafael.pacientes_servicio.service;

import com.f_rafael.pacientes_servicio.dto.PacienteDto;
import com.f_rafael.pacientes_servicio.exception.CampoNuloException;
import com.f_rafael.pacientes_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.pacientes_servicio.model.Paciente;
import com.f_rafael.pacientes_servicio.repository.IPacienteRepository;
import com.f_rafael.pacientes_servicio.utils.PacienteMap;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PacienteService implements IPacienteService{

    private IPacienteRepository repository;
    private PacienteMap transformacion;

    @Override
    public PacienteDto buscarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return transformacion.obtenerDto(repository.findById(id).get());
    }

    @Override
    public List<PacienteDto> buscarTodos() {
        return transformacion.obtenerListaDto(repository.findAll());
    }

    @Override
    public PacienteDto guardar(Paciente paciente) {

        if(paciente.getPrimerNombre() == null || paciente.getApellidoPaterno() == null || paciente.getFechaNacimiento() == null || paciente.getLugarNacimientoId() == null || paciente.getDni() == null){
            throw new CampoNuloException("Algunos campos no pueden ser nulos");
        }

        return transformacion.obtenerDto(repository.save(paciente));
    }

    @Override
    public PacienteDto actualizar(Paciente paciente) {

        if (paciente.getId() == null) {
            throw new CampoNuloException("El id no puede ser nulo");
        }

        return this.guardar(paciente);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        repository.deleteById(id);
    }
}
