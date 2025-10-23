package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.exception.CampoNuloException;
import com.f_rafael.hospital_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.hospital_servicio.model.Sector;
import com.f_rafael.hospital_servicio.repository.ISectorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectorService implements ISectorService{

    private ISectorRepository repository;

    @Override
    public Sector buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Sector no encontrado"));
    }

    @Override
    public List<Sector> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public Sector guardar(Sector sector) {

        if(sector.getNombre() == null){
            throw new CampoNuloException("El nombre del sector no puede ser nulo");
        }

        return repository.save(sector);
    }

    @Override
    public Sector actualizar(Sector sector) {

        if(sector.getId() == null){
            throw new CampoNuloException("El id no puede ser nulo en una actualización");
        }
        return this.guardar(sector);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Sector no encontrado");
        }

        repository.deleteById(id);
    }
}
