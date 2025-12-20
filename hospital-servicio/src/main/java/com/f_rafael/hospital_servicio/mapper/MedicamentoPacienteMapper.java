package com.f_rafael.hospital_servicio.mapper;

import com.f_rafael.hospital_servicio.dto.MedicamentoPacienteDto;
import com.f_rafael.hospital_servicio.model.MedicamentoPaciente;
import com.f_rafael.hospital_servicio.repository.IDosisClient;
import com.f_rafael.hospital_servicio.repository.IFarmaciaClient;
import com.f_rafael.hospital_servicio.repository.IMedicamentoClient;
import com.f_rafael.hospital_servicio.repository.IPacienteClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Component
@AllArgsConstructor
public class MedicamentoPacienteMapper {

    private IPacienteClient pacienteClient;
    private IMedicamentoClient medicamentoClient;
    // private IDosisClient dosisClient;
    private IFarmaciaClient farmaciaClient;

    public MedicamentoPacienteDto obtenerDto(MedicamentoPaciente informacionTratamiento){
        MedicamentoPacienteDto dtoARetornar = new MedicamentoPacienteDto();

        dtoARetornar.setId(informacionTratamiento.getId());
        dtoARetornar.setPaciente(pacienteClient.buscarPacientePorId(informacionTratamiento.getPacienteId()));
        dtoARetornar.setMedicamento(medicamentoClient.buscarPorId(informacionTratamiento.getMedicamentoId()));
        dtoARetornar.setDosis(farmaciaClient.buscarDosisPorId(informacionTratamiento.getDosisId()));
        dtoARetornar.setInicio(informacionTratamiento.getInicio());
        dtoARetornar.setFin(informacionTratamiento.getFin());

        return dtoARetornar;
    }

    public List<MedicamentoPacienteDto> obtenerListaDto(Collection<MedicamentoPaciente> informacionTratamientos){
        List<MedicamentoPacienteDto> listaParaRetornar = new LinkedList<>();

        for(MedicamentoPaciente mp : informacionTratamientos){
            listaParaRetornar.add(obtenerDto(mp));
        }

        return listaParaRetornar;
    }
}
