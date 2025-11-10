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

    @Override
    public TratamientoQuirurgico buscarPorNombre(String nombre) {
        return repository.findByNombre(nombre).orElseThrow(()-> new EntidadNoEncontradaException("Tratamiento quirúrgico no encontrado"));
    }

    @Override
    public List<TratamientoQuirurgico> buscarPorDescripcion(String secuencia) {
        return repository.findAllByDescripcionContaining(secuencia);
    }

    @Override
    public TratamientoQuirurgico modificarNombre(Long id, String nombre) {
        TratamientoQuirurgico tratamientoParaActualizar = devolverPorId(id);
        tratamientoParaActualizar.setNombre(nombre);

        return this.actualizar(tratamientoParaActualizar);
    }

    @Override
    public TratamientoQuirurgico modificarDescripcion(Long id, String descripcion) {
        TratamientoQuirurgico tratamientoParaActualizar = devolverPorId(id);
        tratamientoParaActualizar.setDescripcion(descripcion);

        return this.actualizar(tratamientoParaActualizar);
    }

    public TratamientoQuirurgico devolverPorId(Long id){
        return repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Tratamiento quirúrgico no encontrado"));
    }
}
