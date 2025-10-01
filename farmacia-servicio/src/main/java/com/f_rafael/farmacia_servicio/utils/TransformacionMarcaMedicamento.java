package com.f_rafael.farmacia_servicio.utils;

import com.f_rafael.farmacia_servicio.dto.MarcaMedicamentoDto;
import com.f_rafael.farmacia_servicio.dto.SubMedicamentoDto;
import com.f_rafael.farmacia_servicio.model.MarcaMedicamento;
import com.f_rafael.farmacia_servicio.model.Medicamento;

import java.util.*;

public class TransformacionMarcaMedicamento {

    public static MarcaMedicamentoDto obtenerDto(MarcaMedicamento marca){
        MarcaMedicamentoDto dtoARetornar = new MarcaMedicamentoDto();
        Set<Medicamento> informacionMedicamentos;
        Optional<Set<Medicamento>> medicamentosOptional = Optional.of(marca.getMedicamentos());
        Set<SubMedicamentoDto> medicamentosParaAsignar;
        SubMedicamentoDto medicamentoParaAgregar;

        if(medicamentosOptional.isPresent()){
            informacionMedicamentos = marca.getMedicamentos();
            medicamentosParaAsignar = new HashSet<>();

            for(Medicamento m : informacionMedicamentos){
                medicamentoParaAgregar = new SubMedicamentoDto(m.getId(),
                        m.getPrincipioActivo().getNombre(),
                        m.getFormaFarmaceutica().getNombre(),
                        m.getAdministracion().getVia(),
                        m.getMarca().getNombre());

                medicamentosParaAsignar.add(medicamentoParaAgregar);
            }
            dtoARetornar.setMedicamentos(medicamentosParaAsignar);
        }
        dtoARetornar.setId(marca.getId());
        dtoARetornar.setNombre(marca.getNombre());

        return dtoARetornar;
    }

    public static List<MarcaMedicamentoDto> obtenerListaDtos(Collection<MarcaMedicamento> coleccionMarcaMedicamento){
        List<MarcaMedicamentoDto> listaARetornar = new LinkedList<>();
        for(MarcaMedicamento mm : coleccionMarcaMedicamento){
            listaARetornar.add(obtenerDto(mm));
        }
        return listaARetornar;
    }
}
