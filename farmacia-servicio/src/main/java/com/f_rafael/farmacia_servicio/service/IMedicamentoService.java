package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.dto.MedicamentoDto;
import com.f_rafael.farmacia_servicio.model.Medicamento;

import java.util.List;

public interface IMedicamentoService {
    public MedicamentoDto buscarPorId(Long id);
    public List<MedicamentoDto> buscarTodos();
    public MedicamentoDto guardar(Medicamento medicamento);
    public MedicamentoDto actualizar(Medicamento medicamento);
    public void borrarPorId(Long id);
    public List<MedicamentoDto> buscarPorPrincipioActivo(String nombrePrincipioActivo);
    public List<MedicamentoDto> buscarPorFormaFarmaceutica(String nombreFormaFarmaceutica);
    public List<MedicamentoDto> buscarPorAdministracion(String via);
    public List<MedicamentoDto> buscarPorMarca(String nombreMarca);

}
