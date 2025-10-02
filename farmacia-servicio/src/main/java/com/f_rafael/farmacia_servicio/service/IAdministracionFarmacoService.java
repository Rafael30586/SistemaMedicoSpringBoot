package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.dto.AccionTerapeuticaDto;
import com.f_rafael.farmacia_servicio.dto.AdministracionFarmacoDto;
import com.f_rafael.farmacia_servicio.model.AccionTerapeutica;
import com.f_rafael.farmacia_servicio.model.AdministracionFarmaco;

import java.util.List;
import java.util.Optional;

public interface IAdministracionFarmacoService {
    public Optional<AdministracionFarmaco> buscarPorId(Long id);
    public AdministracionFarmacoDto buscarPorId2(Long id);
    public List<AdministracionFarmaco> buscarTodas();
    public List<AdministracionFarmacoDto> buscarTodas2();
    public AdministracionFarmaco guardar(AdministracionFarmaco administracion);
    public AdministracionFarmacoDto guardar2(AdministracionFarmaco administracion);
    public AdministracionFarmaco actualizar(AdministracionFarmaco administracion);
    public AdministracionFarmacoDto actualizar2(AdministracionFarmaco administracion);
    public void borrarPorId(Long id);
    public Optional<AdministracionFarmaco> buscarPorVia(String via);
    public AdministracionFarmacoDto buscarPorVia2(String via);
}
