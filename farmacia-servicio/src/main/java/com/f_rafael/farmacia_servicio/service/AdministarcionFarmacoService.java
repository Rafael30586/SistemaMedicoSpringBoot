package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.model.AdministracionFarmaco;
import com.f_rafael.farmacia_servicio.repository.IAdministarcionFarmacoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AdministarcionFarmacoService implements IAdministracionFarmacoService{

    private IAdministarcionFarmacoRepository repository;

    @Override
    public Optional<AdministracionFarmaco> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<AdministracionFarmaco> buscarTodas() {
        return repository.findAll();
    }

    @Override
    public AdministracionFarmaco guardar(AdministracionFarmaco administracion) {
        return repository.save(administracion);
    }

    @Override
    public AdministracionFarmaco actualizar(AdministracionFarmaco administracion) {
        return this.guardar(administracion);
    }

    @Override
    public void borrarPorId(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<AdministracionFarmaco> buscarPorVia(String via) {
        return repository.findByVia(via);
    }
}
