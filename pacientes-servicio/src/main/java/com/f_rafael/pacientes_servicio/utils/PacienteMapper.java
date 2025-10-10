package com.f_rafael.pacientes_servicio.utils;

import com.f_rafael.pacientes_servicio.dto.*;
import com.f_rafael.pacientes_servicio.model.Paciente;
import com.f_rafael.pacientes_servicio.repository.IDireccionClient;
import com.f_rafael.pacientes_servicio.repository.ILocalidadClient;
import com.f_rafael.pacientes_servicio.repository.INumeroTelefonicoClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Component
public class PacienteMapper {

    private ObraSocialMapper obraSocialMapper;
    private IDireccionClient direccionClient;
    private INumeroTelefonicoClient numeroTelefonicoClient;
    private ILocalidadClient localidadClient;

    public PacienteDto obtenerDto(Paciente informacionPaciente){
        PacienteDto dtoARetornar = new PacienteDto();
        List<NumeroTelefonicoDto> numerosTelefonicosParaAsignar = new LinkedList<>();
        DireccionDto direccionParaAsignar = direccionClient.obtenerInformacionDireccion(informacionPaciente.getDireccionId());
        LocalidadDto lugarDeNacimientoParaAsignar = localidadClient.obtenerInformacionDeLocalidad(informacionPaciente.getLugarNacimientoId());
        Set<Long> idTelefonos = informacionPaciente.getTelefonosId();
        ObraSocialDto obraSocialParaAsignar;

        dtoARetornar.setId(informacionPaciente.getId());
        dtoARetornar.setDni(informacionPaciente.getDni());
        dtoARetornar.setPrimerNombre(informacionPaciente.getPrimerNombre());
        dtoARetornar.setSegundoNombre(informacionPaciente.getSegundoNombre());
        dtoARetornar.setApellidoPaterno(informacionPaciente.getApellidoPaterno());
        dtoARetornar.setApellidoMaterno(informacionPaciente.getApellidoMaterno());
        dtoARetornar.setEmail(informacionPaciente.getEmail());
        dtoARetornar.setFechaNacimiento(informacionPaciente.getFechaNacimiento());
        dtoARetornar.setDomicilio(direccionParaAsignar);
        dtoARetornar.setLugarNacimiento(lugarDeNacimientoParaAsignar);

        for(Long id : idTelefonos){
            numerosTelefonicosParaAsignar.add(numeroTelefonicoClient.buscarPorId(id));
        }

        dtoARetornar.setTelefonos(numerosTelefonicosParaAsignar);

        if(informacionPaciente.getObraSocial() != null){
            obraSocialParaAsignar = obraSocialMapper.obtenerDto(informacionPaciente.getObraSocial());
            dtoARetornar.setObraSocial(obraSocialParaAsignar);
        }

        return dtoARetornar;
    }

    public List<PacienteDto> obtenerListaDto(Collection<Paciente> informacionPacientes){
        List<PacienteDto> listaARetornar = new LinkedList<>();

        for(Paciente p : informacionPacientes){
            listaARetornar.add(obtenerDto(p));
        }

        return listaARetornar;
    }
}
