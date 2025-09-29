package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.model.AccionTerapeutica;
import com.f_rafael.farmacia_servicio.model.AdministracionFarmaco;

import java.util.List;
import java.util.Optional;

public interface IAdministracionFarmacoService {
    public Optional<AdministracionFarmaco> buscarPorId(Long id);
    public List<AdministracionFarmaco> buscarTodas();
    public AdministracionFarmaco guardar(AdministracionFarmaco administracion);
    public AdministracionFarmaco actualizar(AdministracionFarmaco administracion);
    public void borrarPorId(Long id);
    public Optional<AdministracionFarmaco> buscarPorVia(String via);
}
