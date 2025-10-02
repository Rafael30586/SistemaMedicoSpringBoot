package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.dto.MedicamentoDto;
import com.f_rafael.farmacia_servicio.exception.CampoNuloException;
import com.f_rafael.farmacia_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.farmacia_servicio.model.Medicamento;
import com.f_rafael.farmacia_servicio.repository.IMedicamentoRepository;
import com.f_rafael.farmacia_servicio.utils.TransformacionMedicamento;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicamentoService implements IMedicamentoService{

    private IMedicamentoRepository repository;

    @Override
    public MedicamentoDto buscarPorId(Long id) {

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return TransformacionMedicamento.obtenerDto(repository.findById(id).get());
    }

    @Override
    public List<MedicamentoDto> buscarTodos() {
        return TransformacionMedicamento.obtenerListaDto(repository.findAll());
    }

    @Override
    public MedicamentoDto guardar(Medicamento medicamento) {

        if(medicamento.getPrincipioActivo() == null || medicamento.getFormaFarmaceutica() == null || medicamento.getAdministracion() == null || medicamento.getMarca() == null){
            throw new CampoNuloException("Hay campos que no pueden ser nulos");
        }
        return TransformacionMedicamento.obtenerDto(repository.save(medicamento));
    }

    @Override
    public MedicamentoDto actualizar(Medicamento medicamento) {
        Long id = medicamento.getId();

        if(id == null){
            throw new CampoNuloException("El id no puede ser nulo");
        }

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return this.guardar(medicamento);
    }


    @Override
    public void borrarPorId(Long id) {

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        repository.deleteById(id);
    }

    @Override
    public List<MedicamentoDto> buscarPorPrincipioActivo(String nombrePrincipioActivo) {
        return TransformacionMedicamento.obtenerListaDto(repository.buscarPorPrincipioActivo(nombrePrincipioActivo));
    }


    @Override
    public List<MedicamentoDto> buscarPorFormaFarmaceutica(String nombreFormaFarmaceutica) {
        return TransformacionMedicamento.obtenerListaDto(repository.buscarPorFormaFarmaceutica(nombreFormaFarmaceutica));
    }

    @Override
    public List<MedicamentoDto> buscarPorAdministracion(String via) {
        return TransformacionMedicamento.obtenerListaDto(repository.buscarPorAdministracion(via));
    }

    @Override
    public List<MedicamentoDto> buscarPorMarca(String nombreMarca) {
        return TransformacionMedicamento.obtenerListaDto(repository.buscarPorMarca(nombreMarca));
    }
}
