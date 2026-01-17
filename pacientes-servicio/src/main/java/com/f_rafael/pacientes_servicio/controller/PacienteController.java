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

    @GetMapping("/{id}") // funciona
    public ResponseEntity<PacienteDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping // funciona
    public ResponseEntity<List<PacienteDto>> buscarTodos(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("/dni") // funciona
    public ResponseEntity<PacienteDto> buscarPorDni(@RequestParam Long dni){
        return ResponseEntity.ok(service.buscarPorDni(dni));
    }

    @GetMapping("/nombre") // funciona
    public ResponseEntity<List<PacienteDto>> buscarPorNombre(@RequestParam String nombre){
        return ResponseEntity.ok(service.buscarPorNombre(nombre));
    }

    @GetMapping("/apellido") // funciona
    public ResponseEntity<List<PacienteDto>> buscarPorApellido(@RequestParam String apellido){
        return ResponseEntity.ok(service.buscarPorApellido(apellido));
    }

    @GetMapping("/email") // funciona
    public ResponseEntity<PacienteDto> buscarPorEmail(@RequestParam String email){
        return ResponseEntity.ok(service.buscarPorEmail(email));
    }

    @GetMapping("/telefono") // funciona
    public ResponseEntity<List<PacienteDto>> buscarPorTelefono(@RequestParam("numero-telefonico") String numeroTelefonico){
        return ResponseEntity.ok(service.buscarPorNumeroTelefonico(numeroTelefonico));
    }

    @GetMapping("/fecha-nacimiento") // fucniona
    public ResponseEntity<List<PacienteDto>> buscarPorIntervaloNacimiento(@RequestParam Integer desde,
                                                                    @RequestParam Integer hasta){
        return ResponseEntity.ok(service.buscarPorIntervaloNacimiento(desde,hasta));
    }

    @GetMapping("lugar-nacimiento") // funciona
    public ResponseEntity<List<PacienteDto>> buscarPorLugarNacimiento(@RequestParam String localidad){
        return ResponseEntity.ok(service.buscarPorLugarNacimiento(localidad));
    }

    @GetMapping("/domicilio") // funciona
    public ResponseEntity<List<PacienteDto>> buscarPorDomicilio(@RequestParam String calle){
        return ResponseEntity.ok(service.buscarPorDomicilio(calle));
    }

    @PostMapping // funciona
    public ResponseEntity<PacienteDto> guardar(@RequestBody Paciente paciente){
        return new ResponseEntity<>(service.guardar(paciente), HttpStatusCode.valueOf(201));
    }

    @PutMapping // funciona
    public ResponseEntity<PacienteDto> actualizar(@RequestBody Paciente paciente){
        return ResponseEntity.ok(service.actualizar(paciente));
    }

    @DeleteMapping("/{id}") // funciona
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        service.borrarPorId(id);
        return new ResponseEntity<>("Entidad borrada correctamente",HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/dni") // funciona
    public ResponseEntity<PacienteDto> actualizarDni(@RequestParam Long id,
                                                     @RequestParam Long dni){
        return ResponseEntity.ok(service.actulizarDni(id, dni));
    }

    @PatchMapping("/primer-nombre") // funciona
    public ResponseEntity<PacienteDto> actualizarPrimerNombre(@RequestParam("id-o-dni") Long idODni,
                                                              @RequestParam String opcion,
                                                              @RequestParam String nombre){
        return ResponseEntity.ok(service.actulizarPrimerNombre(idODni,opcion,nombre));
    }

    @PatchMapping("/segundo-nombre") // funciona
    public ResponseEntity<PacienteDto> actualizarSegundoNombre(@RequestParam("id-o-dni") Long idODni,
                                                               @RequestParam String opcion,
                                                               @RequestParam String nombre){
        return ResponseEntity.ok(service.actulizarSegundoNombre(idODni,opcion,nombre));
    }

    @PatchMapping("/apellido-paterno") // funciona
    public ResponseEntity<PacienteDto> actualizarApellidoPaterno(@RequestParam("id-o-dni") Long idODni,
                                                                 @RequestParam String opcion,
                                                                 @RequestParam String apellido){
        return ResponseEntity.ok(service.actulizarApellidoPaterno(idODni,opcion,apellido));
    }

    @PatchMapping("/apellido-materno") // funciona
    public ResponseEntity<PacienteDto> actualizarApellidoMaterno(@RequestParam("id-o-dni") Long idODni,
                                                                 @RequestParam String opcion,
                                                                 @RequestParam String apellido){
        return ResponseEntity.ok(service.actualizarApellidoMaterno(idODni,opcion,apellido));
    }

    @PatchMapping("/email") // funciona
    public ResponseEntity<PacienteDto> actualizarEmail(@RequestParam("id-o-dni") Long idODni,
                                                       @RequestParam String opcion,
                                                       @RequestParam String email){
        return ResponseEntity.ok(service.actualizarEmail(idODni,opcion,email));
    }

    @PatchMapping("/agregar-telefono") // funciona
    public ResponseEntity<PacienteDto> agregarNumeroTelefonico(@RequestParam("id-o-dni")Long idODni,
                                                       @RequestParam String opcion,
                                                       @RequestParam("telefono-para-agregar") String telefonoParaAgregar){
        return ResponseEntity.ok(service.agregarNumeroTelefonico(idODni,opcion,telefonoParaAgregar));
    }

    @PatchMapping("/quitar-telefono") // funciona
    public ResponseEntity<PacienteDto> quitarNumeroTelefonico(@RequestParam("id-o-dni")Long idODni,
                                                              @RequestParam String opcion,
                                                              @RequestParam("telefono-para-quitar") String telefonoParaQuitar){
        return ResponseEntity.ok(service.quitarNumeroTelefonico(idODni,opcion,telefonoParaQuitar));
    }

    @PatchMapping("/fecha-nacimiento") // funciona
    public ResponseEntity<PacienteDto> actualizarFechaNacimiento(@RequestParam("id-o-dni")Long idODni,
                                                                 @RequestParam String opcion,
                                                                 @RequestParam("fecha") LocalDate fechaNacimiento){
        return ResponseEntity.ok(service.actualizarFechaNacimiento(idODni,opcion,fechaNacimiento));
    }

    @PatchMapping("/lugar-nacimiento") // funciona
    public ResponseEntity<PacienteDto> actualizaLugarNacimiento(@RequestParam("id-o-dni")Long idODni,
                                                                @RequestParam String opcion,
                                                                @RequestParam("localidad-id") Long localidadId){
        return ResponseEntity.ok(service.actualizarLugarNacimiento(idODni,opcion,localidadId));
    }

    @PatchMapping("/domicilio") // funciona
    public ResponseEntity<PacienteDto> actualizarDomicilio(@RequestParam("id-o-dni")Long idODni,
                                                           @RequestParam String opcion,
                                                           @RequestParam("direccion-id") Long direccionId){
        return ResponseEntity.ok(service.actualizarDomicilio(idODni,opcion,direccionId));
    }

    @PatchMapping("/obra-social") // funciona
    public ResponseEntity<PacienteDto> actualizarObraSocial(@RequestParam("id-o-dni")Long idODni,
                                                            @RequestParam String opcion,
                                                            @RequestParam("obra-social-id") Long obraSocialId){
        return ResponseEntity.ok(service.actualizarObraSocial(idODni,opcion,obraSocialId));
    }

}
