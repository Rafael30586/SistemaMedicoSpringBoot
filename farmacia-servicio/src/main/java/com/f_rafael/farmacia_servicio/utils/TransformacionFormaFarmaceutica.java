package com.f_rafael.farmacia_servicio.utils;

import com.f_rafael.farmacia_servicio.dto.FormaFarmaceuticaDto;
import com.f_rafael.farmacia_servicio.dto.SubMedicamentoDto;
import com.f_rafael.farmacia_servicio.model.FormaFarmaceutica;
import com.f_rafael.farmacia_servicio.model.Medicamento;

import java.util.*;

public class TransformacionFormaFarmaceutica {

    public static FormaFarmaceuticaDto obtenerDto(FormaFarmaceutica formaFarmaceutica){
        FormaFarmaceuticaDto dtoARetornar = new FormaFarmaceuticaDto();
        Set<Medicamento> informacionMedicamentos;
        Optional<Set<Medicamento>> medicamentosOptional = Optional.of(formaFarmaceutica.getMedicamentos());
        SubMedicamentoDto medicamentoParaAgregar;
        Set<SubMedicamentoDto> medicamentosParaAsignar;

        if(medicamentosOptional.isPresent()){
            informacionMedicamentos = formaFarmaceutica.getMedicamentos();
            medicamentosParaAsignar = new HashSet<>();

            for(Medicamento m : informacionMedicamentos){
                medicamentoParaAgregar = new SubMedicamentoDto(m.getId(),
                        m.getPrincipioActivo().getNombre(),
                        m.getFormaFarmaceutica().getNombre(),
                        m.getAdministracion().getVia(),
                        m.getMarca().getNombre());

                medicamentosParaAsignar.add(medicamentoParaAgregar);
            }

            dtoARetornar.setMedicamento(medicamentosParaAsignar);
        }

        dtoARetornar.setId(formaFarmaceutica.getId());
        dtoARetornar.setNombre(formaFarmaceutica.getNombre());

        return dtoARetornar;
    }

    public static List<FormaFarmaceuticaDto> obtenerListaDtos(Collection<FormaFarmaceutica> coleccionFormasFarmaceuticas){
        List<FormaFarmaceuticaDto> listaARetornar = new LinkedList<>();

        for(FormaFarmaceutica ff : coleccionFormasFarmaceuticas){
            listaARetornar.add(obtenerDto(ff));
        }

        return listaARetornar;
    }
}
