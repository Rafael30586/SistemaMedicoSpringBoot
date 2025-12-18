package com.f_rafael.hospital_servicio.mapper;

import com.f_rafael.hospital_servicio.dto.EmpleadoDto;
import com.f_rafael.hospital_servicio.model.Empleado;
import com.f_rafael.hospital_servicio.repository.IDireccionClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Component
@AllArgsConstructor
public class EmpleadoMapper {

    private IDireccionClient direccionClient;

    public EmpleadoDto obtenerDto(Empleado informacionEmpleado){
        EmpleadoDto dtoARetornar = new EmpleadoDto();

        dtoARetornar.setId(informacionEmpleado.getId());
        dtoARetornar.setDni(informacionEmpleado.getDni());
        dtoARetornar.setPrimerNombre(informacionEmpleado.getPrimerNombre());
        dtoARetornar.setSegundoNombre(informacionEmpleado.getSegundoNombre());
        dtoARetornar.setApellidoPaterno(informacionEmpleado.getApellidoPaterno());
        dtoARetornar.setApellidoMaterno(informacionEmpleado.getApellidoMaterno());
        dtoARetornar.setEmail(informacionEmpleado.getEmail());
        dtoARetornar.setDomicilio(direccionClient.buscarPorId(informacionEmpleado.getDomicilioId()));
        dtoARetornar.setRol(informacionEmpleado.getRol());
        dtoARetornar.setSalario(informacionEmpleado.getSalario());
        dtoARetornar.setTelefonos(informacionEmpleado.getTelefonos());
        dtoARetornar.setMatriculaProfesional(informacionEmpleado.getMatriculaProfesional());

        return dtoARetornar;
    }

    public List<EmpleadoDto> obtenerListaDto(Collection<Empleado> informacionEmpleados){
        List<EmpleadoDto> listaARetornar = new LinkedList<>();

        for(Empleado e : informacionEmpleados){
            listaARetornar.add(obtenerDto(e));
        }

        return listaARetornar;
    }
}
