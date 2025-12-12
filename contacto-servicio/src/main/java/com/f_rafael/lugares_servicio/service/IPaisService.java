package com.f_rafael.lugares_servicio.service;

import com.f_rafael.lugares_servicio.model.Pais;

import java.util.List;

public interface IPaisService {

    public Pais buscarPorId(Long id);
    public List<Pais> buscarTodos();
    public Pais guardar(Pais pais);
    public Pais actualizar(Pais pais);
    public void borrarPorId(Long id);
    public Pais buscarPorNombre(String nombre);
    public Pais modificarNombre(Long id, String nombre);
}
