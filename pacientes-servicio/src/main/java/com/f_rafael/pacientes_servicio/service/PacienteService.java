package com.f_rafael.pacientes_servicio.service;

import com.f_rafael.pacientes_servicio.dto.PacienteDto;
import com.f_rafael.pacientes_servicio.exception.CampoNuloException;
import com.f_rafael.pacientes_servicio.exception.DatoIncorrectoException;
import com.f_rafael.pacientes_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.pacientes_servicio.mapper.StringMapper;
import com.f_rafael.pacientes_servicio.model.ObraSocial;
import com.f_rafael.pacientes_servicio.model.Paciente;
import com.f_rafael.pacientes_servicio.repository.*;
import com.f_rafael.pacientes_servicio.mapper.PacienteMapper;
import com.f_rafael.pacientes_servicio.utils.VerificadorOpciones;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class PacienteService implements IPacienteService{

    private IPacienteRepository repository;
    private PacienteMapper mapper;
    private INumeroTelefonicoClient numeroTelefonicoClient;
    private ILocalidadClient localidadClient;
    private IDireccionClient direccionClient;
    private StringMapper stringMapper;
    private IObraSocialRepository obraSocialRepository;
    private VerificadorOpciones verificador;

    @Override
    public PacienteDto buscarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        return mapper.obtenerDto(repository.findById(id).get());
    }

    @Override
    public List<PacienteDto> buscarTodos() {
        return mapper.obtenerListaDto(repository.findAll());
    }

    @Override
    public PacienteDto guardar(Paciente paciente) {

        if(paciente.getPrimerNombre() == null || paciente.getApellidoPaterno() == null || paciente.getFechaNacimiento() == null || paciente.getLugarNacimientoId() == null || paciente.getDni() == null){
            throw new CampoNuloException("Algunos campos no pueden ser nulos");
        }

        return mapper.obtenerDto(repository.save(paciente));
    }

    @Override
    public PacienteDto actualizar(Paciente paciente) {

        if (paciente.getId() == null) {
            throw new CampoNuloException("El id no puede ser nulo");
        }

        return this.guardar(paciente);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Entidad no encontrada");
        }

        repository.deleteById(id);
    }

    @Override
    public PacienteDto buscarPorDni(Long dni) {
        return mapper.obtenerDto(repository.findByDni(dni).orElseThrow(() -> new EntidadNoEncontradaException("Entidad no encontrada")));
    }

    @Override
    public List<PacienteDto> buscarPorNombre(String nombre) {
        return mapper.obtenerListaDto(repository.buscarPorNombre(stringMapper.quitarGuionesBajos(nombre)));
    }

    @Override
    public List<PacienteDto> buscarPorApellido(String apellido) {
        return mapper.obtenerListaDto(repository.buscarPorApellido(stringMapper.quitarGuionesBajos(apellido)));
    }

    @Override
    public PacienteDto buscarPorEmail(String email) {
        return mapper.obtenerDto(repository.findByEmail(email).orElseThrow(()-> new EntidadNoEncontradaException("Entidad no encontrada")));
    }

    @Override
    public List<PacienteDto> buscarPorNumeroTelefonico(String numero) {
        List<Paciente> listaARetornar = repository.buscarPorNumeroTelefonico(numero);
        return mapper.obtenerListaDto(listaARetornar);
    }

    @Override
    public List<PacienteDto> buscarPorIntervaloNacimiento(Integer desde, Integer hasta) {
        if(desde > hasta){
            throw new DatoIncorrectoException("El primer dato del intervalo debe ser menor que el segundo");
        }

        if(hasta > LocalDate.now().getYear() || desde < (LocalDate.now().getYear()-120)){
            throw new DatoIncorrectoException("Se ha superado el límite del año de nacimiento");
        }

        return mapper.obtenerListaDto(repository.buscarPorIntervaloNacimiento(desde,hasta));
    }

    @Override
    public List<PacienteDto> buscarPorLugarNacimiento(String localidad) {
        List<PacienteDto> listaARetornar = new LinkedList<>();
        List<Paciente> informacionPacientes = repository.findAll();

        for(Paciente p : informacionPacientes){
            if(localidadClient.obtenerInformacionDeLocalidad(p.getLugarNacimientoId()).getNombre().equals(localidad)){
                listaARetornar.add(mapper.obtenerDto(p));
            }
        }

        return listaARetornar;
    }

    @Override
    public List<PacienteDto> buscarPorDomicilio(String calle) {
        List<PacienteDto> listaARetornar = new LinkedList<>();
        List<Paciente> informacionPacientes = repository.findAll();

        for(Paciente p : informacionPacientes){
            if(direccionClient.obtenerInformacionDireccion(p.getDireccionId()).getCalle().equals(stringMapper.quitarGuionesBajos(calle))){
                listaARetornar.add(mapper.obtenerDto(p));
            }
        }
        return listaARetornar;
    }

    @Override
    public PacienteDto actulizarDni(Long id, Long dni) {
        Paciente pacienteAEditar = repository.findById(id).orElseThrow(()->new EntidadNoEncontradaException("PAciente no encontrado"));
        pacienteAEditar.setDni(dni);
        return this.guardar(pacienteAEditar);
    }

    @Override
    public PacienteDto actulizarPrimerNombre(Long idODni,String opcion, String primerNombre) {

        if(!verificador.idODni(opcion)){
            throw new DatoIncorrectoException("El argumento debe ser id o dni");
        }

        Paciente pacienteAEditar = new Paciente();

        if(opcion.equals("id")){
            pacienteAEditar = repository.findById(idODni).orElseThrow(()-> new EntidadNoEncontradaException("Paciente no encontrado"));
        }

        if(opcion.equals("dni")){
            pacienteAEditar = repository.findByDni(idODni).orElseThrow(()-> new EntidadNoEncontradaException("Paciente no encontrado"));
        }

        pacienteAEditar.setPrimerNombre(stringMapper.quitarGuionesBajos(primerNombre));
        return this.guardar(pacienteAEditar);
    }

    @Override
    public PacienteDto actulizarSegundoNombre(Long idODni,String opcion, String segundoNombre) {

        if(!verificador.idODni(opcion)){
            throw new DatoIncorrectoException("El argumento debe ser id o dni");
        }

        Paciente pacienteAEditar = new Paciente();

        if(opcion.equals("id")){
            pacienteAEditar = repository.findById(idODni).orElseThrow(()-> new EntidadNoEncontradaException("Paciente no encontrado"));
        }

        if(opcion.equals("dni")){
            pacienteAEditar = repository.findByDni(idODni).orElseThrow(()-> new EntidadNoEncontradaException("Paciente no encontrado"));
        }


        pacienteAEditar.setSegundoNombre(stringMapper.quitarGuionesBajos(segundoNombre));
        return this.guardar(pacienteAEditar);
    }

    @Override
    public PacienteDto actulizarApellidoPaterno(Long idODni,String opcion, String apellidoPaterno) {
        if(!verificador.idODni(opcion)){
            throw new DatoIncorrectoException("El argumento debe ser id o dni");
        }

        Paciente pacienteAEditar = new Paciente();

        if(opcion.equals("id")){
            pacienteAEditar = repository.findById(idODni).orElseThrow(()-> new EntidadNoEncontradaException("Paciente no encontrado"));
        }

        if(opcion.equals("dni")){
            pacienteAEditar = repository.findByDni(idODni).orElseThrow(()-> new EntidadNoEncontradaException("Paciente no encontrado"));
        }

        pacienteAEditar.setApellidoPaterno(stringMapper.quitarGuionesBajos(apellidoPaterno));
        return this.guardar(pacienteAEditar);
    }

    @Override
    public PacienteDto actualizarApellidoMaterno(Long idODni,String opcion, String apellidoMaterno) {
        if(!verificador.idODni(opcion)){
            throw new DatoIncorrectoException("El argumento debe ser id o dni");
        }

        Paciente pacienteAEditar = new Paciente();

        if(opcion.equals("id")){
            pacienteAEditar = repository.findById(idODni).orElseThrow(()-> new EntidadNoEncontradaException("Paciente no encontrado"));
        }

        if(opcion.equals("dni")){
            pacienteAEditar = repository.findByDni(idODni).orElseThrow(()-> new EntidadNoEncontradaException("Paciente no encontrado"));
        }

        pacienteAEditar.setApellidoMaterno(stringMapper.quitarGuionesBajos(apellidoMaterno));
        return this.guardar(pacienteAEditar);
    }

    @Override
    public PacienteDto actualizarEmail(Long idODni,String opcion, String email) {

        if(!verificador.idODni(opcion)){
            throw new DatoIncorrectoException("El argumento debe ser id o dni");
        }

        Paciente pacienteAEditar = new Paciente();

        if(opcion.equals("id")){
            pacienteAEditar = repository.findById(idODni).orElseThrow(()-> new EntidadNoEncontradaException("Paciente no encontrado"));
        }

        if(opcion.equals("dni")){
            pacienteAEditar = repository.findByDni(idODni).orElseThrow(()-> new EntidadNoEncontradaException("Paciente no encontrado"));
        }

        pacienteAEditar.setEmail(email);
        return this.guardar(pacienteAEditar);
    }

    @Override
    public PacienteDto agregarNumeroTelefonico(Long id, String telefono) {
        Paciente pacienteAEditar = repository.findById(id).orElseThrow(()->new EntidadNoEncontradaException("Paciente no encontrado"));
        Set<String> telefonosParaAsignar = pacienteAEditar.getTelefonos();

        telefonosParaAsignar.add(telefono);
        pacienteAEditar.setTelefonos(telefonosParaAsignar);

        return this.guardar(pacienteAEditar);
    }

    @Override
    public PacienteDto quitarNumeroTelefonico(Long id, String telefonoParaQuitar) {
        Paciente pacienteAEditar = repository.findById(id).orElseThrow(()->new EntidadNoEncontradaException("Paciente no encontrado"));
        Set<String> telefonosParaAsignar = pacienteAEditar.getTelefonos();
        boolean telefonoPresente = false;
        //Long telefonoParaQuitar = null;

        for(String t : telefonosParaAsignar){
            if(t.equals(telefonoParaQuitar)){
                //telefonoParaQuitar = t;
                telefonoPresente = true;
            }
        }

        if(!telefonoPresente){
            throw new DatoIncorrectoException("El teléfono no existe dentro de la lista de teléfonos del paciente");
        }

        telefonosParaAsignar.remove(telefonoParaQuitar);

        pacienteAEditar.setTelefonos(telefonosParaAsignar);

        return this.guardar(pacienteAEditar);
    }

    @Override
    public PacienteDto actualizarFechaNacimiento(Long idODni,String opcion, LocalDate fechaNacimiento) {
        if(!verificador.idODni(opcion)){
            throw new DatoIncorrectoException("El argumento debe ser id o dni");
        }

        Paciente pacienteParaEditar = new Paciente();

        if(opcion.equals("id")){
            pacienteParaEditar = repository.findById(idODni).orElseThrow(()-> new EntidadNoEncontradaException("Paciente no encontrado"));
        }

        if(opcion.equals("dni")){
            pacienteParaEditar = repository.findByDni(idODni).orElseThrow(()-> new EntidadNoEncontradaException("Paciente no encontrado"));
        }

        pacienteParaEditar.setFechaNacimiento(fechaNacimiento);
        return this.guardar(pacienteParaEditar);
    }

    @Override
    public PacienteDto actualizarLugarNacimiento(Long idODni,String opcion, Long localidadId) { // Hacer validación para saber si la localidad existe en el otro microservicio
        if(!verificador.idODni(opcion)){
            throw new DatoIncorrectoException("El argumento debe ser id o dni");
        }

        Paciente pacienteParaEditar = new Paciente();

        if(opcion.equals("id")){
            pacienteParaEditar = repository.findById(idODni).orElseThrow(()-> new EntidadNoEncontradaException("Paciente no encontrado"));
        }

        if(opcion.equals("dni")){
            pacienteParaEditar = repository.findByDni(idODni).orElseThrow(()-> new EntidadNoEncontradaException("Paciente no encontrado"));
        }

        pacienteParaEditar.setLugarNacimientoId(localidadId);
        return this.guardar(pacienteParaEditar);
    }

    @Override
    public PacienteDto actualizarDomicilio(Long idODni,String opcion, Long direccionId) {

        if(!verificador.idODni(opcion)){
            throw new DatoIncorrectoException("El argumento debe ser id o dni");
        }

        Paciente pacienteParaEditar = new Paciente();

        if(opcion.equals("id")){
            pacienteParaEditar = repository.findById(idODni).orElseThrow(()-> new EntidadNoEncontradaException("Paciente no encontrado"));
        }

        if(opcion.equals("dni")){
            pacienteParaEditar = repository.findByDni(idODni).orElseThrow(()-> new EntidadNoEncontradaException("Paciente no encontrado"));
        }

        pacienteParaEditar.setDireccionId(direccionId);
        return this.guardar(pacienteParaEditar);
    }

    @Override
    public PacienteDto actualizarObraSocial(Long idODni, String opcion, Long obraSocialId) {
        if(!verificador.idODni(opcion)){
            throw new DatoIncorrectoException("El argumento debe ser id o dni");
        }

        Paciente pacienteParaEditar = new Paciente();

        if(opcion.equals("id")){
            pacienteParaEditar = repository.findById(idODni).orElseThrow(()-> new EntidadNoEncontradaException("Paciente no encontrado"));
        }

        if(opcion.equals("dni")){
            pacienteParaEditar = repository.findByDni(idODni).orElseThrow(()-> new EntidadNoEncontradaException("Paciente no encontrado"));
        }

        ObraSocial obraSocialParaAsignar = obraSocialRepository.findById(obraSocialId).orElseThrow(()->new EntidadNoEncontradaException("Obra social no encontrada"));
        pacienteParaEditar.setObraSocial(obraSocialParaAsignar);
        return this.guardar(pacienteParaEditar);
    }
/*
    private PacienteDto buscarPorTelefonoId(Long id){
        List<Paciente> pacientes = repository.findAll();
        PacienteDto dtoARetornar;
        Set<Long> telefonosId;

        for(Paciente p : pacientes){
            if(p.getTelefonosId() != null){
                telefonosId = p.getTelefonosId();

                for(Long tid : telefonosId){
                    if(tid.equals(id)){
                        dtoARetornar = mapper.obtenerDto(p);
                        return dtoARetornar;
                    }
                }
            }
        }

        throw new EntidadNoEncontradaException("El número telefónico no corresponde a ningún paciente");
    }*/
}
