package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.exception.CampoNuloException;
import com.f_rafael.hospital_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.hospital_servicio.model.TratamientoQuirurgico;
import com.f_rafael.hospital_servicio.repository.ITratamientoQuirurgicoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TratamientoQuirurgicoService implements ITratamientoQuirurgicoService{

    private ITratamientoQuirurgicoRepository repository;

    @Override
    public TratamientoQuirurgico buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Tratamiento quirúrgico no encontrado"));
    }

    @Override
    public List<TratamientoQuirurgico> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public TratamientoQuirurgico guardar(TratamientoQuirurgico tratamientoQuirurgico) {

        if(tratamientoQuirurgico.getNombre() == null){
            throw new CampoNuloException("El tratamiento quirúrgico debe tener un nombre");
        }

        return repository.save(tratamientoQuirurgico);
    }

    @Override
    public TratamientoQuirurgico actualizar(TratamientoQuirurgico tratamientoQuirurgico) {

        if(tratamientoQuirurgico.getId() == null){
            throw new CampoNuloException("El id no puede ser nulo durante una actualización");
        }

        return this.guardar(tratamientoQuirurgico);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("El tratamiento quirúrgico no ha sido encontrado");
        }

        repository.deleteById(id);
    }
}
