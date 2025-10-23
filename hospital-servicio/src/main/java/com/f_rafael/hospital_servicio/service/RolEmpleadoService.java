package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.exception.CampoNuloException;
import com.f_rafael.hospital_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.hospital_servicio.model.RolEmpleado;
import com.f_rafael.hospital_servicio.repository.IRolEmpleadoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RolEmpleadoService implements IRolEmpleadoService{

    private IRolEmpleadoRepository repository;

    @Override
    public RolEmpleado buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Rol no encontrado"));
    }

    @Override
    public List<RolEmpleado> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public RolEmpleado guardar(RolEmpleado rolEmpleado) {
        if(rolEmpleado.getNombre() == null || rolEmpleado.getSector() == null){
            throw new CampoNuloException("Algunos campos de rol de empleado no pueden ser nulos");
        }

        return repository.save(rolEmpleado);
    }

    @Override
    public RolEmpleado actualizar(RolEmpleado rolEmpleado) {

        if(rolEmpleado.getId() == null){
            throw new CampoNuloException("El id no puede ser nulo durante una actualización");
        }

        return this.guardar(rolEmpleado);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("El rol no existe en la base de datos");
        }

        repository.deleteById(id);
    }
}
