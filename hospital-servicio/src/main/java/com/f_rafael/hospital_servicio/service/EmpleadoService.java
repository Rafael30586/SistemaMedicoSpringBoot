package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.dto.EmpleadoDto;
import com.f_rafael.hospital_servicio.exception.CampoNuloException;
import com.f_rafael.hospital_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.hospital_servicio.mapper.EmpleadoMapper;
import com.f_rafael.hospital_servicio.mapper.StringMapper;
import com.f_rafael.hospital_servicio.model.Empleado;
import com.f_rafael.hospital_servicio.model.RolEmpleado;
import com.f_rafael.hospital_servicio.repository.IContactoClient;
import com.f_rafael.hospital_servicio.repository.IEmpleadoRepository;
import com.f_rafael.hospital_servicio.utils.Verificador;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class EmpleadoService implements IEmpleadoService{

    private IEmpleadoRepository repository;
    private EmpleadoMapper mapper;
    private StringMapper stringMapper;
    private Verificador verificador;
    private IContactoClient contactoClient;

    @Override
    public EmpleadoDto buscarPorId(Long id) {
        return mapper.obtenerDto(devolverPorId(id));
    }

    @Override
    public List<EmpleadoDto> buscarTodos() {
        return mapper.obtenerListaDto(repository.findAll());
    }

    @Override
    public EmpleadoDto guardar(Empleado empleado) {
        String primerNombre = empleado.getPrimerNombre();
        String segundoNombre = empleado.getSegundoNombre();
        String apellidoPaterno = empleado.getApellidoPaterno();
        String apellidoMaterno = empleado.getApellidoMaterno();

        if(empleado.getDni() == null || primerNombre == null || empleado.getRol() == null){
            throw new CampoNuloException("Algunos campos de la entidad Empleado no pueden ser nulos");
        }

        verificador.esEmail(empleado.getEmail());
        verificador.tieneEspaciosVacios(primerNombre);
        verificador.tieneEspaciosVacios(segundoNombre);

        verificador.soloLetrasMinusculasEspaciosYGuionesMedios(primerNombre);
        verificador.tieneEspaciosVacios(primerNombre);
        verificador.soloLetrasMinusculasEspaciosYGuionesMedios(segundoNombre);
        verificador.tieneEspaciosVacios(segundoNombre);

        verificador.soloLetrasMinusculasEspaciosYGuionesMedios(apellidoPaterno);
        verificador.soloLetrasMinusculasEspaciosYGuionesMedios(apellidoMaterno);

        Set<String> telefonos = empleado.getTelefonos();

        for(String t : telefonos){
            verificador.esNumeroTelefonico(t);
        }

        contactoClient.buscarDireccionPorId(empleado.getDomicilioId());

        return mapper.obtenerDto(repository.save(empleado));
    }

    @Override
    public EmpleadoDto actualizar(Empleado empleado) {

        if(empleado.getId() == null){
            throw new CampoNuloException("El id no puede ser nulo durante una actualización");
        }
        return this.guardar(empleado);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Empleado no encontrado");
        }

        repository.deleteById(id);
    }

    @Override
    public EmpleadoDto buscarPorDni(Long dni) {
        return mapper.obtenerDto(repository.findByDni(dni).orElseThrow(()-> new EntidadNoEncontradaException("Empleado no encontrado")));
    }

    @Override
    public List<EmpleadoDto> buscarPorNombre(String nombre) {
        return mapper.obtenerListaDto(repository.buscarPorNombre(nombre));
    }

    @Override
    public List<EmpleadoDto> buscarPorApellido(String apellido) {
        String apellidoSinGuiones = stringMapper.quitarGuionesBajos(apellido);
        return mapper.obtenerListaDto(repository.buscarPorApellido(apellidoSinGuiones));
    }

    @Override
    public EmpleadoDto buscarPorEmail(String email) {
        verificador.esEmail(email);
        return mapper.obtenerDto(repository.findByEmail(email).orElseThrow(()-> new EntidadNoEncontradaException("Empleado no encontrado")));
    }

    @Override
    public EmpleadoDto buscarPorMatriculaProfesional(String matricula) {
        return mapper.obtenerDto(repository.findByMatriculaProfesional(matricula).orElseThrow(()-> new EntidadNoEncontradaException("Empleado no encontardo")));
    }

    @Override
    public List<EmpleadoDto> buscarPorRol(String rol) {
        return mapper.obtenerListaDto(repository.buscarPorRol(rol));
    }

    @Override
    public List<EmpleadoDto> buscarPorRangoSalarial(Float minimo, Float maximo) {
        return mapper.obtenerListaDto(repository.buscarPorRangoSalarial(minimo,maximo));
    }

    @Override
    public EmpleadoDto modificarDni(Long id, Long dni) {
        Empleado empleadoAModificar = devolverPorId(id);
        empleadoAModificar.setDni(dni);

        return this.actualizar(empleadoAModificar);
    }

    @Override
    public EmpleadoDto modificarPrimerNombre(Long id, String nombre) {
        Empleado empleadoAModificar = devolverPorId(id);

        verificador.soloLetrasMinusculasEspaciosYGuionesMedios(nombre);
        verificador.tieneEspaciosVacios(nombre);

        empleadoAModificar.setPrimerNombre(nombre);

        return this.actualizar(empleadoAModificar);
    }

    @Override
    public EmpleadoDto modificarSegundoNombre(Long id, String nombre) {
        Empleado empleadoAModificar = devolverPorId(id);

        verificador.soloLetrasMinusculasEspaciosYGuionesMedios(nombre);
        verificador.tieneEspaciosVacios(nombre);

        empleadoAModificar.setSegundoNombre(nombre);

        return this.actualizar(empleadoAModificar);
    }

    @Override
    public EmpleadoDto modificarApellidoPaterno(Long id, String apellido) {
        Empleado empleadoAModificar = devolverPorId(id);
        String apellidoSinGuiones = stringMapper.quitarGuionesBajos(apellido);

        verificador.soloLetrasMinusculasEspaciosYGuionesMedios(apellido);
        empleadoAModificar.setApellidoPaterno(apellidoSinGuiones);

        return this.actualizar(empleadoAModificar);
    }

    @Override
    public EmpleadoDto modificarApellidoMaterno(Long id, String apellido) {
        Empleado empleadoAModificar = devolverPorId(id);
        String apellidoSinGuiones = stringMapper.quitarGuionesBajos(apellido);

        verificador.soloLetrasMinusculasEspaciosYGuionesMedios(apellido);
        empleadoAModificar.setApellidoMaterno(apellidoSinGuiones);

        return this.actualizar(empleadoAModificar);
    }

    @Override
    public EmpleadoDto modificarEmail(Long id, String email) {
        Empleado empleadoAModificar = devolverPorId(id);

        verificador.esEmail(email);
        empleadoAModificar.setEmail(email);

        return this.actualizar(empleadoAModificar);
    }

    @Override
    public EmpleadoDto modificarDomicilio(Long id, Long domicilioId) {
        Empleado empleadoAModificar = devolverPorId(id);
        empleadoAModificar.setDomicilioId(domicilioId);

        return this.actualizar(empleadoAModificar);
    }

    @Override
    public EmpleadoDto agregarTelefono(Long id, String telefono) {
        Empleado empleadoAModificar = devolverPorId(id);
        Set<String> telefonosParaAsignar = empleadoAModificar.getTelefonos();

        verificador.esNumeroTelefonico(telefono);

        telefonosParaAsignar.add(telefono);
        empleadoAModificar.setTelefonos(telefonosParaAsignar);

        return this.actualizar(empleadoAModificar);
    }

    @Override
    public EmpleadoDto quitarTelefono(Long id, String telefono) {
        Empleado empleadoAModificar = devolverPorId(id);
        Set<String> telefonosParaAsignar = empleadoAModificar.getTelefonos();

        verificador.esNumeroTelefonico(telefono);

        if(!telefonosParaAsignar.contains(telefono)){
            throw new EntidadNoEncontradaException("El número telefónico no está dentro de la lista");
        }

        telefonosParaAsignar.remove(telefono);
        empleadoAModificar.setTelefonos(telefonosParaAsignar);

        return this.actualizar(empleadoAModificar);
    }

    @Override
    public EmpleadoDto modificarMatriculaProfesional(Long id, String matricula) {
        Empleado empleadoAModificar = devolverPorId(id);
        empleadoAModificar.setMatriculaProfesional(matricula);

        return this.actualizar(empleadoAModificar);
    }

    @Override
    public EmpleadoDto modificarRol(Long id, Long rolId) {
        Empleado empleadoAModificar = devolverPorId(id);
        RolEmpleado rolParaAsignar = new RolEmpleado();
        rolParaAsignar.setId(rolId);

        empleadoAModificar.setRol(rolParaAsignar);

        return this.actualizar(empleadoAModificar);
    }

    @Override
    public EmpleadoDto modificarSalario(Long id, Float salario) {
        Empleado empleadoAModificar = devolverPorId(id);
        empleadoAModificar.setSalario(salario);

        return this.actualizar(empleadoAModificar);
    }

    public Empleado devolverPorId(Long id){
        return repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Emple4ado no encontrado"));
    }
}
