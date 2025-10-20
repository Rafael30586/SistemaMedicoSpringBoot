package com.f_rafael.pacientes_servicio.controller;

import com.f_rafael.pacientes_servicio.dto.PacienteDto;
import com.f_rafael.pacientes_servicio.model.Paciente;
import com.f_rafael.pacientes_servicio.service.IPacienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/pacientes")
@AllArgsConstructor
public class PacienteController {

    private IPacienteService service;

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<PacienteDto>> buscarTodos(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping
    public ResponseEntity<PacienteDto> buscarPorDni(@RequestParam Long dni){
        return ResponseEntity.ok(service.buscarPorDni(dni));
    }

    @GetMapping
    public ResponseEntity<List<PacienteDto>> buscarPorNombre(@RequestParam String nombre){
        return ResponseEntity.ok(service.buscarPorNombre(nombre));
    }

    @GetMapping
    public ResponseEntity<List<PacienteDto>> buscarPorApellido(@RequestParam String apellido){
        return ResponseEntity.ok(service.buscarPorApellido(apellido));
    }

    @GetMapping
    public ResponseEntity<PacienteDto> buscarPorEmail(@RequestParam String email){
        return ResponseEntity.ok(service.buscarPorEmail(email));
    }

    @GetMapping
    public ResponseEntity<List<PacienteDto>> buscarPorTelefono(@RequestParam("numero-telefonico") String numeroTelefonico){
        return ResponseEntity.ok(service.buscarPorNumeroTelefonico(numeroTelefonico));
    }

    @GetMapping
    public ResponseEntity<List<PacienteDto>> buscarPorIntervaloNacimiento(@RequestParam Integer desde,
                                                                    @RequestParam Integer hasta){
        return ResponseEntity.ok(service.buscarPorIntervaloNacimiento(desde,hasta));
    }

    @GetMapping
    public ResponseEntity<List<PacienteDto>> buscarPorLugarNacimiento(@RequestParam String localidad){
        return ResponseEntity.ok(service.buscarPorLugarNacimiento(localidad));
    }

    @GetMapping
    public ResponseEntity<List<PacienteDto>> buscarPorDomicilio(@RequestParam String calle){
        return ResponseEntity.ok(service.buscarPorDomicilio(calle));
    }

    @PostMapping
    public ResponseEntity<PacienteDto> guardar(@RequestBody Paciente paciente){
        return new ResponseEntity<>(service.guardar(paciente), HttpStatusCode.valueOf(201));
    }

    @PutMapping
    public ResponseEntity<PacienteDto> actualizar(@RequestBody Paciente paciente){
        return ResponseEntity.ok(service.actualizar(paciente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        service.borrarPorId(id);
        return new ResponseEntity<>("Entidad borrada correctamente",HttpStatusCode.valueOf(204));
    }

    @PatchMapping
    public ResponseEntity<PacienteDto> actualizarDni(@RequestParam Long id,
                                                     @RequestParam Long dni){
        return ResponseEntity.ok(service.actulizarDni(id, dni));
    }

    @PatchMapping
    public ResponseEntity<PacienteDto> actualizarPrimerNombre(@RequestParam("id-o-dni") Long idODni,
                                                              @RequestParam String opcion,
                                                              @RequestParam String primerNombre){
        return ResponseEntity.ok(service.actulizarPrimerNombre(idODni,opcion,primerNombre));
    }

    @PatchMapping
    public ResponseEntity<PacienteDto> actualizarSegundoNombre(@RequestParam("id-o-dni") Long idODni,
                                                               @RequestParam String opcion,
                                                               @RequestParam String segundoNombre){
        return ResponseEntity.ok(service.actulizarSegundoNombre(idODni,opcion,segundoNombre));
    }

    @PatchMapping
    public ResponseEntity<PacienteDto> actualizarApellidoPaterno(@RequestParam("id-o-dni") Long idODni,
                                                                 @RequestParam String opcion,
                                                                 @RequestParam String apellidoPaterno){
        return ResponseEntity.ok(service.actulizarApellidoPaterno(idODni,opcion,apellidoPaterno));
    }

    @PatchMapping
    public ResponseEntity<PacienteDto> actualizarApellidoMaterno(@RequestParam("id-o-dni") Long idODni,
                                                                 @RequestParam String opcion,
                                                                 @RequestParam String apellidoMaterno){
        return ResponseEntity.ok(service.actualizarApellidoMaterno(idODni,opcion,apellidoMaterno));
    }

    @PatchMapping
    public ResponseEntity<PacienteDto> actualizarEmail(@RequestParam("id-o-dni") Long idODni,
                                                       @RequestParam String opcion,
                                                       @RequestParam String email){
        return ResponseEntity.ok(service.actualizarEmail(idODni,opcion,email));
    }

    @PatchMapping
    public ResponseEntity<PacienteDto> agregarNumeroTelefonico(@RequestParam("id-o-dni")Long idODni,
                                                       @RequestParam String opcion,
                                                       @RequestParam String telefonoParaAgregar){
        return ResponseEntity.ok(service.agregarNumeroTelefonico(idODni,opcion,telefonoParaAgregar));
    }

    @PatchMapping
    public ResponseEntity<PacienteDto> quitarNumeroTelefonico(@RequestParam("id-o-dni")Long idODni,
                                                              @RequestParam String opcion,
                                                              @RequestParam String telefonoParaQuitar){
        return ResponseEntity.ok(service.quitarNumeroTelefonico(idODni,opcion,telefonoParaQuitar));
    }

    @PatchMapping
    public ResponseEntity<PacienteDto> actualizarFechaNacimiento(@RequestParam("id-o-dni")Long idODni,
                                                                 @RequestParam String opcion,
                                                                 @RequestParam LocalDate fechaNacimiento){
        return ResponseEntity.ok(service.actualizarFechaNacimiento(idODni,opcion,fechaNacimiento));
    }

    @PatchMapping
    public ResponseEntity<PacienteDto> actualizaLugarNacimiento(@RequestParam("id-o-dni")Long idODni,
                                                                @RequestParam String opcion,
                                                                @RequestParam Long localidadId){
        return ResponseEntity.ok(service.actualizarLugarNacimiento(idODni,opcion,localidadId));
    }

    @PatchMapping
    public ResponseEntity<PacienteDto> actualizarDomicilio(@RequestParam("id-o-dni")Long idODni,
                                                           @RequestParam String opcion,
                                                           @RequestParam Long direccionId){
        return ResponseEntity.ok(service.actualizarDomicilio(idODni,opcion,direccionId));
    }

    @PatchMapping
    public ResponseEntity<PacienteDto> actualizarObraSocial(@RequestParam("id-o-dni")Long idODni,
                                                            @RequestParam String opcion,
                                                            @RequestParam Long obraSocialId){
        return ResponseEntity.ok(service.actualizarObraSocial(idODni,opcion,obraSocialId));
    }

}
