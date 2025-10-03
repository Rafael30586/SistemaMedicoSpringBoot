package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.dto.*;
import com.f_rafael.farmacia_servicio.exception.CampoNuloException;
import com.f_rafael.farmacia_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.farmacia_servicio.model.*;
import com.f_rafael.farmacia_servicio.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MedicamentoService implements IMedicamentoService{

    private IMedicamentoRepository repository;
    private IPrincipioActivoRepository principioActivoRepository;
    private IFormaFarmaceuticaRepository formaFarmaceuticaRepository;
    private IAdministracionFarmacoRepository administracionFarmacoRepository;
    private IMarcaMedicamentoRepository marcaMedicamentoRepository;

    @Override
    public MedicamentoDto buscarPorId(Long id) {

        if(repository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return obtenerDto(repository.findById(id).get());
    }

    @Override
    public List<MedicamentoDto> buscarTodos() {
        return obtenerListaDto(repository.findAll());
    }

    @Override
    public MedicamentoDto guardar(Medicamento medicamento) {

        if(medicamento.getPrincipioActivo() == null || medicamento.getFormaFarmaceutica() == null || medicamento.getAdministracion() == null || medicamento.getMarca() == null){
            throw new CampoNuloException("Hay campos que no pueden ser nulos");
        }
        return obtenerDto(repository.save(medicamento));
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
        return obtenerListaDto(repository.buscarPorPrincipioActivo(nombrePrincipioActivo));
    }


    @Override
    public List<MedicamentoDto> buscarPorFormaFarmaceutica(String nombreFormaFarmaceutica) {
        return obtenerListaDto(repository.buscarPorFormaFarmaceutica(nombreFormaFarmaceutica));
    }

    @Override
    public List<MedicamentoDto> buscarPorAdministracion(String via) {
        return obtenerListaDto(repository.buscarPorAdministracion(via));
    }

    @Override
    public List<MedicamentoDto> buscarPorMarca(String nombreMarca) {
        return obtenerListaDto(repository.buscarPorMarca(nombreMarca));
    }

    @Override
    public void asignarPrincipioActivo(Long id, Long principioActivoId) {
        Medicamento medicamentoAEditar;
        PrincipioActivo principioActivoAAsignar = new PrincipioActivo();

        if(repository.findById(id).isEmpty() || principioActivoRepository.findById(principioActivoId).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        medicamentoAEditar = repository.findById(id).get();
        principioActivoAAsignar.setId(principioActivoId);
        medicamentoAEditar.setPrincipioActivo(principioActivoAAsignar);
        repository.save(medicamentoAEditar);
    }

    @Override
    public void asignarFormaFarmaceutica(Long id, Long formaFarmaceuticaId) {
        Medicamento medicamentoAEditar;
        FormaFarmaceutica formaFarmaceuticaAAsignar = new FormaFarmaceutica();

        if(repository.findById(id).isEmpty() || formaFarmaceuticaRepository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        medicamentoAEditar = repository.findById(id).get();
        formaFarmaceuticaAAsignar.setId(formaFarmaceuticaId);
        medicamentoAEditar.setFormaFarmaceutica(formaFarmaceuticaAAsignar);
        // medicamentoAEditar.setFormaFarmaceutica(formaFarmaceuticaRepository.findById(formaFarmaceuticaId).get());
        repository.save(medicamentoAEditar);
    }

    @Override
    public void asignarAdministracion(Long id, Long administracionId) {
        Medicamento medicamentoAEditar;
        AdministracionFarmaco administracionAAsignar = new AdministracionFarmaco();

        if(repository.findById(id).isEmpty() || administracionFarmacoRepository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        medicamentoAEditar = repository.findById(id).get();
        administracionAAsignar.setId(administracionId);
        medicamentoAEditar.setAdministracion(administracionAAsignar);
        // medicamentoAEditar.setAdministracion(administracionFarmacoRepository.findById(administracionId).get());
        repository.save(medicamentoAEditar);
    }

    @Override
    public void asignarMarca(Long id, Long marcaId) {
        Medicamento medicamentoAEditar;
        MarcaMedicamento marcaAAsignar = new MarcaMedicamento();

        if(repository.findById(id).isEmpty() || marcaMedicamentoRepository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        medicamentoAEditar = repository.findById(id).get();
        marcaAAsignar.setId(marcaId);
        medicamentoAEditar.setMarca(marcaAAsignar);
        // medicamentoAEditar.setMarca(marcaMedicamentoRepository.findById(marcaId).get());
        repository.save(medicamentoAEditar);
    }

    private MedicamentoDto obtenerDto(Medicamento medicamento){
        MedicamentoDto dtoARetornar = new MedicamentoDto();

        Optional<PrincipioActivo> optionalPrincipioActivo = Optional.of(medicamento.getPrincipioActivo());
        Optional<FormaFarmaceutica> optionalFormaFarmaceutica = Optional.of(medicamento.getFormaFarmaceutica());
        Optional<AdministracionFarmaco> optionalAdministracionFarmaco = Optional.of(medicamento.getAdministracion());
        Optional<MarcaMedicamento> optionalMarca = Optional.of(medicamento.getMarca());

        SubPrincipioActivoDto principioActivoParaAsignar;
        SubFormaFarmaceuticaDto formafarmaceuticaParaAsignar;
        SubAdministracionFarmacoDto administracionParaAsignar;
        SubMarcaMedicamentoDto marcaParaAsignar;

        if(optionalPrincipioActivo.isPresent()){
            principioActivoParaAsignar = new SubPrincipioActivoDto(medicamento.getPrincipioActivo().getId(),
                    medicamento.getPrincipioActivo().getNombre());
            dtoARetornar.setPrincipioActivo(principioActivoParaAsignar);
        }

        if(optionalFormaFarmaceutica.isPresent()){
            formafarmaceuticaParaAsignar = new SubFormaFarmaceuticaDto(medicamento.getFormaFarmaceutica().getId(),
                    medicamento.getFormaFarmaceutica().getNombre());
            dtoARetornar.setFormaFarmaceutica(formafarmaceuticaParaAsignar);
        }

        if(optionalAdministracionFarmaco.isPresent()){
            administracionParaAsignar = new SubAdministracionFarmacoDto(medicamento.getAdministracion().getId(),
                    medicamento.getAdministracion().getVia());
            dtoARetornar.setAdministracion(administracionParaAsignar);
        }

        if(optionalMarca.isPresent()){
            marcaParaAsignar = new SubMarcaMedicamentoDto(medicamento.getMarca().getId(),
                    medicamento.getMarca().getNombre());
            dtoARetornar.setMarca(marcaParaAsignar);
        }

        return dtoARetornar;
    }

    private List<MedicamentoDto> obtenerListaDto(Collection<Medicamento> coleccionMedicamento){
        List<MedicamentoDto> listaARetornar = new LinkedList<>();

        for(Medicamento m : coleccionMedicamento){
            listaARetornar.add(obtenerDto(m));
        }

        return listaARetornar;
    }
}
