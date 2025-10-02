package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.dto.MedicamentoDto;
import com.f_rafael.farmacia_servicio.model.FormaFarmaceutica;
import com.f_rafael.farmacia_servicio.model.Medicamento;

import java.util.List;
import java.util.Optional;

public interface IMedicamentoService {
    public Optional<Medicamento> buscarPorId(Long id);
    public MedicamentoDto buscarPorId2(Long id);
    public List<Medicamento> buscarTodos();
    public List<MedicamentoDto> buscarTodos2();
    public Medicamento guardar(Medicamento medicamento);
    public MedicamentoDto guardar2(Medicamento medicamento);
    public Medicamento actualizar(Medicamento medicamento);
    public MedicamentoDto actualizar2(Medicamento medicamento);
    public void borrarPorId(Long id);
    public void borrarPorId2(Long id);
    public List<Medicamento> buscarPorPrincipioActivo(String nombrePrincipioActivo);
    public List<MedicamentoDto> buscarPorPrincipioActivo2(String nombrePrincipioActivo);
    public List<Medicamento> buscarPorFormaFarmaceutica(String nombreFormaFarmaceutica);
    public List<MedicamentoDto> buscarPorFormaFarmaceutica2(String nombreFormaFarmaceutica);
    public List<Medicamento> buscarPorAdministracion(String via);
    public List<MedicamentoDto> buscarPorAdministracion2(String via);
    public List<Medicamento> buscarPorMarca(String nombreMarca);
    public List<MedicamentoDto> buscarPorMarca2(String nombreMarca);

}
