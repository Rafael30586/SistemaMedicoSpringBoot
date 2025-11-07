package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.model.Sector;

import java.util.List;

public interface ISectorService {
    public Sector buscarPorId(Long id);
    public List<Sector> buscarTodos();
    public Sector guardar(Sector sector);
    public Sector actualizar(Sector sector);
    public void borrarPorId(Long id);
    public Sector buscarPorNombre(String nombre);
    public Sector modificarNombre(Long id, String nombre);
}
