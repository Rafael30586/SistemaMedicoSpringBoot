package com.f_rafael.lugares_servicio.service;


import com.f_rafael.lugares_servicio.model.NumeroTelefonico;
import com.f_rafael.lugares_servicio.repository.INumeroTelefonicoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NumeroTelefonicoService implements INumeroTelefonicoService{

    private INumeroTelefonicoRepository repository;

    @Override
    public Optional<NumeroTelefonico> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<NumeroTelefonico> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public NumeroTelefonico guardar(NumeroTelefonico telefono) {
        return repository.save(telefono);
    }

    @Override
    public NumeroTelefonico actualizar(NumeroTelefonico telefono) {
        return this.guardar(telefono);
    }

    @Override
    public void borrarPorId(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<NumeroTelefonico> buscarPorNumero(String numero) {
        return repository.findByNumero(numero);
    }

    @Override
    public List<NumeroTelefonico> buscarPorTipo(String tipo) {
        return repository.buscarPorTipo(tipo);
    }
}
