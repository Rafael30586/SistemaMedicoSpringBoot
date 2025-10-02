package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.dto.MedicamentoDto;
import com.f_rafael.farmacia_servicio.exception.CampoNuloException;
import com.f_rafael.farmacia_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.farmacia_servicio.model.FormaFarmaceutica;
import com.f_rafael.farmacia_servicio.model.Medicamento;
import com.f_rafael.farmacia_servicio.repository.IMedicamentoRepository;
import com.f_rafael.farmacia_servicio.utils.TransformacionMedicamento;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicamentoService implements IMedicamentoService{

    private IMedicamentoRepository repository;

    @Override
    public Optional<Medicamento> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public MedicamentoDto buscarPorId2(Long id) {

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return TransformacionMedicamento.obtenerDto(repository.findById(id).get());
    }

    @Override
    public List<Medicamento> buscarTodos() {
        return List.of();
    }

    @Override
    public List<MedicamentoDto> buscarTodos2() {
        return TransformacionMedicamento.obtenerListaDto(repository.findAll());
    }

    @Override
    public Medicamento guardar(Medicamento medicamento) {
        return repository.save(medicamento);
    }

    @Override
    public MedicamentoDto guardar2(Medicamento medicamento) {

        if(medicamento.getPrincipioActivo() == null || medicamento.getFormaFarmaceutica() == null || medicamento.getAdministracion() == null || medicamento.getMarca() == null){
            throw new CampoNuloException("Hay campos que no pueden ser nulos");
        }
        return TransformacionMedicamento.obtenerDto(repository.save(medicamento));
    }

    @Override
    public Medicamento actualizar(Medicamento medicamento) {
        return this.guardar(medicamento);
    }

    @Override
    public MedicamentoDto actualizar2(Medicamento medicamento) {
        Long id = medicamento.getId();

        if(id == null){
            throw new CampoNuloException("El id no puede ser nulo");
        }

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return this.guardar2(medicamento);
    }

    @Override
    public void borrarPorId(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void borrarPorId2(Long id) {

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        repository.deleteById(id);
    }

    @Override
    public List<Medicamento> buscarPorPrincipioActivo(String nombrePrincipioActivo) {
        return repository.buscarPorPrincipioActivo(nombrePrincipioActivo);
    }

    @Override
    public List<MedicamentoDto> buscarPorPrincipioActivo2(String nombrePrincipioActivo) {
        return TransformacionMedicamento.obtenerListaDto(repository.buscarPorPrincipioActivo(nombrePrincipioActivo));
    }

    @Override
    public List<Medicamento> buscarPorFormaFarmaceutica(String nombreFormaFarmaceutica) {
        return repository.buscarPorFormaFarmaceutica(nombreFormaFarmaceutica);
    }

    @Override
    public List<MedicamentoDto> buscarPorFormaFarmaceutica2(String nombreFormaFarmaceutica) {
        return TransformacionMedicamento.obtenerListaDto(repository.buscarPorFormaFarmaceutica(nombreFormaFarmaceutica));
    }

    @Override
    public List<Medicamento> buscarPorAdministracion(String via) {
        return repository.buscarPorAdministracion(via);
    }

    @Override
    public List<MedicamentoDto> buscarPorAdministracion2(String via) {
        return TransformacionMedicamento.obtenerListaDto(repository.buscarPorAdministracion(via));
    }

    @Override
    public List<Medicamento> buscarPorMarca(String nombreMarca) {
        return repository.buscarPorMarca(nombreMarca);
    }

    @Override
    public List<MedicamentoDto> buscarPorMarca2(String nombreMarca) {
        return TransformacionMedicamento.obtenerListaDto(repository.buscarPorMarca(nombreMarca));
    }
}
