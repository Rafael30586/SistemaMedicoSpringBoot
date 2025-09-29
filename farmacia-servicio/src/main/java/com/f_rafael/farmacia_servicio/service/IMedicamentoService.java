package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.model.FormaFarmaceutica;
import com.f_rafael.farmacia_servicio.model.Medicamento;

import java.util.List;
import java.util.Optional;

public interface IMedicamentoService {
    public Optional<Medicamento> buscarPorId(Long id);
    public List<Medicamento> buscarTodos();
    public Medicamento guardar(Medicamento medicamento);
    public Medicamento actualizar(Medicamento medicamento);
    public void borrarPorId(Long id);
    public List<Medicamento> buscarPorPrincipioActivo(String nombrePrincipioActivo);
    public List<Medicamento> buscarPorFormaFarmaceutica(String nombreFormaFarmaceutica);
    public List<Medicamento> buscarPorAdministracion(String via);
    public List<Medicamento> buscarPorMarca(String nombreMarca);

}
