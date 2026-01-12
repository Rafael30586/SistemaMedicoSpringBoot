package com.f_rafael.farmacia_servicio.service;

import com.f_rafael.farmacia_servicio.dto.*;
import com.f_rafael.farmacia_servicio.exception.CampoNuloException;
import com.f_rafael.farmacia_servicio.exception.DatoIncorrectoException;
import com.f_rafael.farmacia_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.farmacia_servicio.mapper.MedicamentoMapper;
import com.f_rafael.farmacia_servicio.mapper.StringMapper;
import com.f_rafael.farmacia_servicio.model.*;
import com.f_rafael.farmacia_servicio.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


@Service
@AllArgsConstructor
public class MedicamentoService implements IMedicamentoService{

    private IMedicamentoRepository repository;
    // private IPrincipioActivoRepository principioActivoRepository;
    private IFormaFarmaceuticaRepository formaFarmaceuticaRepository;
    private IAdministracionFarmacoRepository administracionFarmacoRepository;
    private IMarcaMedicamentoRepository marcaMedicamentoRepository;
    private MedicamentoMapper mapper;
    private StringMapper stringMapper;

    @Override
    public MedicamentoDto buscarPorId(Long id) {
        return mapper.obtenerDto(devolverPorId(id));
    }

    @Override
    public List<MedicamentoDto> buscarTodos() {
        return mapper.obtenerListaDto(repository.findAll());
    }

    @Override
    public MedicamentoDto guardar(Medicamento medicamento) {

        if(medicamento.getPrincipiosActivos() == null || medicamento.getFormaFarmaceutica() == null || medicamento.getAdministracion() == null || medicamento.getMarca() == null){
            throw new CampoNuloException("Hay campos que no pueden ser nulos");
        }
        return mapper.obtenerDto(repository.save(medicamento));
    }

    @Override
    public MedicamentoDto actualizar(Medicamento medicamento) {
        Long id = medicamento.getId();

        if(id == null){
            throw new CampoNuloException("El id no puede ser nulo");
        }

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return this.guardar(medicamento);
    }


    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        repository.deleteById(id);
    }

    @Override
    public List<MedicamentoDto> buscarPorPrincipioActivo(String nombrePrincipioActivo) {
        List<Medicamento> medicamentos = repository.findAll();
        List<MedicamentoDto> listaARetornar = new LinkedList<>();
        Set<PrincipioActivo> principiosActivos;
        String principioActivoSinGuiones = stringMapper.removerGuionesBajos(nombrePrincipioActivo);

        for(Medicamento m : medicamentos){
            principiosActivos = m.getPrincipiosActivos();

            for(PrincipioActivo pa : principiosActivos){
                if(pa.getNombre().equals(principioActivoSinGuiones)){
                    listaARetornar.add(mapper.obtenerDto(m));
                }
            }
        }

        return listaARetornar;
        // return mapper.obtenerListaDto(repository.buscarPorPrincipioActivo(nombrePrincipioActivo));
    }


    @Override
    public List<MedicamentoDto> buscarPorFormaFarmaceutica(String nombreFormaFarmaceutica) {
        String formaFarmaceuticaSinGuiones = stringMapper.removerGuionesBajos(nombreFormaFarmaceutica);
        return mapper.obtenerListaDto(repository.buscarPorFormaFarmaceutica(formaFarmaceuticaSinGuiones));
    }

    @Override
    public List<MedicamentoDto> buscarPorAdministracion(String via) {
        String viaSinGuiones = stringMapper.removerGuionesBajos(via);
        return mapper.obtenerListaDto(repository.buscarPorAdministracion(viaSinGuiones));
    }

    @Override
    public List<MedicamentoDto> buscarPorMarca(String nombreMarca) {
        String marcaSinGuiones = stringMapper.removerGuionesBajos(nombreMarca);
        return mapper.obtenerListaDto(repository.buscarPorMarca(marcaSinGuiones));
    }

    @Override
    public void agregarPrincpioActivo(Long id, Long principioActivoId) {
        Medicamento medicamentoParaEditar = devolverPorId(id);
        Set<PrincipioActivo> principiosActivosParaAsignar = medicamentoParaEditar.getPrincipiosActivos();
        PrincipioActivo principioActivoParaAgregar = new PrincipioActivo();

        principioActivoParaAgregar.setId(principioActivoId);
        principiosActivosParaAsignar.add(principioActivoParaAgregar);

        this.actualizar(medicamentoParaEditar);
    }

    @Override
    public void quitarPrincipioActivo(Long id, Long principioActivoId) {
        Medicamento medicamentoParaEditar = devolverPorId(id);
        Set<PrincipioActivo> principiosActivosParaAsignar = medicamentoParaEditar.getPrincipiosActivos();
        Iterator<PrincipioActivo> iterador = principiosActivosParaAsignar.iterator();
        boolean principioActivoPresente = false;

        if(principiosActivosParaAsignar.size() < 2){
            throw new DatoIncorrectoException("La cantidad de principios activos en un medicamento tiene que ser mayor o igual a uno");
        }

        while(iterador.hasNext()){
            if(iterador.next().getId() == principioActivoId){
                iterador.remove();
                principioActivoPresente = true;
            }
        }

        if(!principioActivoPresente){
            throw new DatoIncorrectoException("El id no corresponde a ningún principio activo presente en el medicamento");
        }

        medicamentoParaEditar.setPrincipiosActivos(principiosActivosParaAsignar);

        this.actualizar(medicamentoParaEditar);
    }
/*
    @Override
    public MedicamentoDto asignarPrincipioActivo(Long id, Long principioActivoId) {
        Medicamento medicamentoAEditar;
        PrincipioActivo principioActivoAAsignar = new PrincipioActivo();

        if(!repository.existsById(id) || principioActivoRepository.findById(principioActivoId).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        medicamentoAEditar = repository.findById(id).get();
        principioActivoAAsignar.setId(principioActivoId);
        medicamentoAEditar.setPrincipioActivo(principioActivoAAsignar);
        return this.actualizar(medicamentoAEditar);
    }*/

    @Override
    public MedicamentoDto asignarFormaFarmaceutica(Long id, Long formaFarmaceuticaId) {
        Medicamento medicamentoAEditar;
        FormaFarmaceutica formaFarmaceuticaAAsignar = new FormaFarmaceutica();

        if(!repository.existsById(id) || formaFarmaceuticaRepository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        medicamentoAEditar = repository.findById(id).get();
        formaFarmaceuticaAAsignar.setId(formaFarmaceuticaId);
        medicamentoAEditar.setFormaFarmaceutica(formaFarmaceuticaAAsignar);
        // medicamentoAEditar.setFormaFarmaceutica(formaFarmaceuticaRepository.findById(formaFarmaceuticaId).get());
        return this.actualizar(medicamentoAEditar);
    }

    @Override
    public MedicamentoDto asignarAdministracion(Long id, Long administracionId) {
        Medicamento medicamentoAEditar;
        AdministracionFarmaco administracionAAsignar = new AdministracionFarmaco();

        if(repository.findById(id).isEmpty() || administracionFarmacoRepository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        medicamentoAEditar = repository.findById(id).get();
        administracionAAsignar.setId(administracionId);
        medicamentoAEditar.setAdministracion(administracionAAsignar);
        // medicamentoAEditar.setAdministracion(administracionFarmacoRepository.findById(administracionId).get());
        return this.actualizar(medicamentoAEditar);
    }

    @Override
    public MedicamentoDto asignarMarca(Long id, Long marcaId) {
        Medicamento medicamentoAEditar;
        MarcaMedicamento marcaAAsignar = new MarcaMedicamento();

        if(repository.findById(id).isEmpty() || marcaMedicamentoRepository.findById(id).isEmpty()){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        medicamentoAEditar = repository.findById(id).get();
        marcaAAsignar.setId(marcaId);
        medicamentoAEditar.setMarca(marcaAAsignar);
        // medicamentoAEditar.setMarca(marcaMedicamentoRepository.findById(marcaId).get());
        return this.actualizar(medicamentoAEditar);
    }

    public Medicamento devolverPorId(Long id){
        return repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Medicamento no encontrado"));
    }


}
