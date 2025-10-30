package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.dto.EmpleadoDto;
import com.f_rafael.hospital_servicio.exception.CampoNuloException;
import com.f_rafael.hospital_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.hospital_servicio.mapper.EmpleadoMapper;
import com.f_rafael.hospital_servicio.model.Empleado;
import com.f_rafael.hospital_servicio.repository.IEmpleadoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmpleadoService implements IEmpleadoService{

    private IEmpleadoRepository repository;
    private EmpleadoMapper mapper;

    @Override
    public EmpleadoDto buscarPorId(Long id) {
        return mapper.obtenerDto(repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Empleado no encontrado")));
    }

    @Override
    public List<EmpleadoDto> buscarTodos() {
        return mapper.obtenerListaDto(repository.findAll());
    }

    @Override
    public EmpleadoDto guardar(Empleado empleado) {

        if(empleado.getDni() == null || empleado.getPrimerNombre() == null || empleado.getRol() == null){
            throw new CampoNuloException("Algunos campos de la entidad Empleado no pueden ser nulos");
        }

        return mapper.obtenerDto(repository.save(empleado));
    }

    @Override
    public EmpleadoDto actualizar(Empleado empleado) {

        if(empleado.getId() == null){
            throw new CampoNuloException("El id no puede ser nulo durante una actualización");
        }
        return this.guardar(empleado);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Empleado no encontrado");
        }

        repository.deleteById(id);
    }

    @Override
    public EmpleadoDto buscarPorDni(Long dni) {
        return mapper.obtenerDto(repository.findByDni(dni).orElseThrow(()-> new EntidadNoEncontradaException("Empleado no encontrado")));
    }

    @Override
    public List<EmpleadoDto> buscarPorNombre(String nombre) {
        return mapper.obtenerListaDto(repository.buscarPorNombre(nombre));
    }

    @Override
    public List<EmpleadoDto> buscarPorApellido(String apellido) {
        return mapper.obtenerListaDto(repository.buscarPorApellido(apellido));
    }

    @Override
    public EmpleadoDto buscarPorEmail(String email) {
        return mapper.obtenerDto(repository.findByEmail(email).orElseThrow(()-> new EntidadNoEncontradaException("Empleado no encontrado")));
    }

    @Override
    public EmpleadoDto buscarPorMatriculaProfesional(String matricula) {
        return mapper.obtenerDto(repository.findByMatriculaProfesional(matricula).orElseThrow(()-> new EntidadNoEncontradaException("Empleado no encontardo")));
    }

    @Override
    public List<EmpleadoDto> buscarPorRol(String rol) {
        return mapper.obtenerListaDto(repository.buscarPorRol(rol));
    }

    @Override
    public List<EmpleadoDto> buscarPorRangoSalarial(Float minimo, Float maximo) {
        return mapper.obtenerListaDto(repository.buscarPorRangoSalarial(minimo,maximo));
    }
}
