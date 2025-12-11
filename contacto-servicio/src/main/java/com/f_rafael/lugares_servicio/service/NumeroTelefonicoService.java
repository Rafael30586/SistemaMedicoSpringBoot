package com.f_rafael.lugares_servicio.service;


import com.f_rafael.lugares_servicio.exception.CampoNuloException;
import com.f_rafael.lugares_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.lugares_servicio.exception.EnumeradoIncorrectoException;
import com.f_rafael.lugares_servicio.model.NumeroTelefonico;
import com.f_rafael.lugares_servicio.model.TipoTelefono;
import com.f_rafael.lugares_servicio.repository.INumeroTelefonicoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NumeroTelefonicoService implements INumeroTelefonicoService{ // Clase para borrar

    private INumeroTelefonicoRepository repository;

    @Override
    public NumeroTelefonico buscarPorId(Long id) {
        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }
        return repository.findById(id).get();
    }

    @Override
    public List<NumeroTelefonico> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public NumeroTelefonico guardar(NumeroTelefonico telefono) {
        if(telefono.getNumero() == null){
            throw new CampoNuloException("El número de teléfono no puede ser nulo");
        }
        return repository.save(telefono);
    }

    @Override
    public NumeroTelefonico actualizar(NumeroTelefonico telefono) {
        Long id = telefono.getId();

        if(!repository.existsById(id)){
            throw new CampoNuloException("El id no puede ser nulo");
        }

        return this.guardar(telefono);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }
        repository.deleteById(id);
    }

    @Override
    public NumeroTelefonico buscarPorNumero(String numero) {

        if(repository.findByNumero(numero).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return repository.findByNumero(numero).get();
    }

    @Override
    public List<NumeroTelefonico> buscarPorTipo(String tipo) {
        TipoTelefono[] tiposDeTelefono = TipoTelefono.values();
        boolean tipoTelefonicoPresente = false;

        for (TipoTelefono tt : tiposDeTelefono) {
            tipoTelefonicoPresente = tt.toString().equals(tipo) ? true : false;
        }

        if (!tipoTelefonicoPresente) {
            throw new EnumeradoIncorrectoException("El tipo de teléfono no existe");
        }

        return repository.buscarPorTipo(tipo);
    }
}
