package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.exception.CampoNuloException;
import com.f_rafael.hospital_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.hospital_servicio.model.Diagnostico;
import com.f_rafael.hospital_servicio.repository.IDiagnosticoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosticoService implements IDiagnosticoService{

    private IDiagnosticoRepository repository;
    @Override
    public Diagnostico buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Diagnostico no encontrado"));
    }

    @Override
    public List<Diagnostico> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public Diagnostico guardar(Diagnostico diagnostico) {

        if(diagnostico.getNombre() == null){
            throw new CampoNuloException("El nombre del diagnóstico no puede ser nulo");
        }

        return repository.save(diagnostico);
    }

    @Override
    public Diagnostico actualizar(Diagnostico diagnostico) {
        return this.guardar(diagnostico);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("El diagnóstico para borrar no se ha encontrado");
        }

        repository.deleteById(id);
    }
}
