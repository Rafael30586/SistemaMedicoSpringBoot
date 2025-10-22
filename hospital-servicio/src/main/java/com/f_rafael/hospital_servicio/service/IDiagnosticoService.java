package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.model.Diagnostico;

import java.util.List;

public interface IDiagnosticoService {

    public Diagnostico buscarPorId(Long id);
    public List<Diagnostico> buscarTodos();
    public Diagnostico guardar(Diagnostico diagnostico);
    public Diagnostico actualizar(Diagnostico diagnostico);
    public void borrarPorId(Long id);
}
