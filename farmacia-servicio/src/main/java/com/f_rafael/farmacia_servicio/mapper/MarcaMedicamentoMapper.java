package com.f_rafael.farmacia_servicio.mapper;

import com.f_rafael.farmacia_servicio.dto.MarcaMedicamentoDto;
import com.f_rafael.farmacia_servicio.dto.SubMedicamentoDto;
import com.f_rafael.farmacia_servicio.model.MarcaMedicamento;
import com.f_rafael.farmacia_servicio.model.Medicamento;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MarcaMedicamentoMapper {

    public MarcaMedicamentoDto obtenerDto(MarcaMedicamento marca){
        MarcaMedicamentoDto dtoARetornar = new MarcaMedicamentoDto();
        Set<Medicamento> informacionMedicamentos = marca.getMedicamentos();
        // Optional<Set<Medicamento>> medicamentosOptional = Optional.of(marca.getMedicamentos());
        Set<SubMedicamentoDto> medicamentosParaAsignar;
        SubMedicamentoDto medicamentoParaAgregar;

        if(informacionMedicamentos != null){
            // informacionMedicamentos = marca.getMedicamentos();
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

    public List<MarcaMedicamentoDto> obtenerListaDtos(Collection<MarcaMedicamento> coleccionMarcaMedicamento){
        List<MarcaMedicamentoDto> listaARetornar = new LinkedList<>();
        for(MarcaMedicamento mm : coleccionMarcaMedicamento){
            listaARetornar.add(obtenerDto(mm));
        }
        return listaARetornar;
    }
}
