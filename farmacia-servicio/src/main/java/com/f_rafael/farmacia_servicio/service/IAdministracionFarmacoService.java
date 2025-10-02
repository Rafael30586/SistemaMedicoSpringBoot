package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.dto.AdministracionFarmacoDto;
import com.f_rafael.farmacia_servicio.model.AdministracionFarmaco;

import java.util.List;

public interface IAdministracionFarmacoService {
    public AdministracionFarmacoDto buscarPorId(Long id);
    public List<AdministracionFarmacoDto> buscarTodas();
    public AdministracionFarmacoDto guardar(AdministracionFarmaco administracion);
    public AdministracionFarmacoDto actualizar(AdministracionFarmaco administracion);
    public void borrarPorId(Long id);
    public AdministracionFarmacoDto buscarPorVia(String via);
}
