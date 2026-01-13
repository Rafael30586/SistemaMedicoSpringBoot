package com.f_rafael.farmacia_servicio.mapper;

import com.f_rafael.farmacia_servicio.dto.FormaFarmaceuticaDto;
import com.f_rafael.farmacia_servicio.dto.SubMedicamentoDto;
import com.f_rafael.farmacia_servicio.model.FormaFarmaceutica;
import com.f_rafael.farmacia_servicio.model.Medicamento;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class FormaFarmaceuticaMapper {

    public FormaFarmaceuticaDto obtenerDto(FormaFarmaceutica formaFarmaceutica){
        FormaFarmaceuticaDto dtoARetornar = new FormaFarmaceuticaDto();
        Set<Medicamento> informacionMedicamentos = formaFarmaceutica.getMedicamentos();
        // Optional<Set<Medicamento>> medicamentosOptional = Optional.of(formaFarmaceutica.getMedicamentos());
        SubMedicamentoDto medicamentoParaAgregar;
        Set<SubMedicamentoDto> medicamentosParaAsignar;

        if(informacionMedicamentos != null){
            // informacionMedicamentos = formaFarmaceutica.getMedicamentos();
            medicamentosParaAsignar = new HashSet<>();

            for(Medicamento m : informacionMedicamentos){
                medicamentoParaAgregar = new SubMedicamentoDto(m.getId(),
                        m.getNombre(),
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

    public List<FormaFarmaceuticaDto> obtenerListaDtos(Collection<FormaFarmaceutica> coleccionFormasFarmaceuticas){
        List<FormaFarmaceuticaDto> listaARetornar = new LinkedList<>();

        for(FormaFarmaceutica ff : coleccionFormasFarmaceuticas){
            listaARetornar.add(obtenerDto(ff));
        }

        return listaARetornar;
    }
}
