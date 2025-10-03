package com.f_rafael.lugares_servicio.service;

import com.f_rafael.lugares_servicio.model.Provincia;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

public interface IProvinciaService {

    public Provincia buscarPorId(Long id);
    public List<Provincia> buscarTodas();
    public Provincia guardar(Provincia provincia);
    public Provincia actualizar(Provincia provincia);
    public void borrarPorId(Long id);
    public Provincia buscarPorNombre(String nombre);

}
