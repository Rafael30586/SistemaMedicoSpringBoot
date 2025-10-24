package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.model.EstudioMedico;

import java.util.List;

public interface IEstudioMedicoService {
    public EstudioMedico buscarPorId(Long id);
    public List<EstudioMedico> buscarTodos();
    public EstudioMedico guardar(EstudioMedico estudioMedico);
    public EstudioMedico actualizar(EstudioMedico estudioMedico);
    public void borrarPorId(Long id);
}
