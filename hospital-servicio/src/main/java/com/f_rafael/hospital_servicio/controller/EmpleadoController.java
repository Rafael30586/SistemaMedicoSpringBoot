package com.f_rafael.hospital_servicio.controller;

import com.f_rafael.hospital_servicio.dto.EmpleadoDto;
import com.f_rafael.hospital_servicio.model.Empleado;
import com.f_rafael.hospital_servicio.service.IEmpleadoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
@AllArgsConstructor
public class EmpleadoController {

    private IEmpleadoService service;

    @GetMapping("/{id}") // funciona
    public ResponseEntity<EmpleadoDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping // funciona
    public ResponseEntity<List<EmpleadoDto>> buscarTodos(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("/dni") // funciona
    public ResponseEntity<EmpleadoDto> buscarPorDni(@RequestParam Long dni){
        return ResponseEntity.ok(service.buscarPorDni(dni));
    }

    @GetMapping("/nombre") // funciona
    public ResponseEntity<List<EmpleadoDto>> buscarPorNombre(@RequestParam String nombre){
        return ResponseEntity.ok(service.buscarPorNombre(nombre));
    }

    @GetMapping("/apellido") // funciona
    public ResponseEntity<List<EmpleadoDto>> buscarPorApellido(@RequestParam String apellido){
        return ResponseEntity.ok(service.buscarPorApellido(apellido));
    }

    @GetMapping("/email") // funciona
    public ResponseEntity<EmpleadoDto> buscarPorEmail(@RequestParam String email){
        return ResponseEntity.ok(service.buscarPorEmail(email));
    }

    @GetMapping("/matricula") // funciona
    public ResponseEntity<EmpleadoDto> buscarPorMatriculaProfesional(@RequestParam String matricula){
        return ResponseEntity.ok(service.buscarPorMatriculaProfesional(matricula));
    }

    @GetMapping("/rol") // funciona
    public ResponseEntity<List<EmpleadoDto>> buscarPorRol(@RequestParam String rol){
        return ResponseEntity.ok(service.buscarPorRol(rol));
    }

    @GetMapping("/rango-salarial") // funciona
    public ResponseEntity<List<EmpleadoDto>> buscarPorRangoSalarial(@RequestParam Float minimo,
                                                                    @RequestParam Float maximo){
        return ResponseEntity.ok(service.buscarPorRangoSalarial(minimo, maximo));
    }

    @PostMapping  // funciona
    public ResponseEntity<EmpleadoDto> guardar(@RequestBody Empleado empleado){
        return new ResponseEntity(service.guardar(empleado), HttpStatusCode.valueOf(201));
    }

    @PutMapping // funciona
    public ResponseEntity<EmpleadoDto> actualizar(@RequestBody Empleado empleado){
        return ResponseEntity.ok(service.actualizar(empleado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        service.borrarPorId(id);
        return new ResponseEntity<>("El emepleado se ha borrado", HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}/dni") // funciona
    public ResponseEntity<EmpleadoDto> modificarDni(@PathVariable Long id,
                                                    @RequestParam Long dni){
        return ResponseEntity.ok(service.modificarDni(id,dni));
    }

    @PatchMapping("/{id}/primer-nombre") // funciona
    public ResponseEntity<EmpleadoDto> modificarPrimerNombre(@PathVariable Long id,
                                                             @RequestParam("primer-nombre") String primerNombre){
        return ResponseEntity.ok(service.modificarPrimerNombre(id,primerNombre));
    }

    @PatchMapping("/{id}/segundo-nombre") // funciona
    public ResponseEntity<EmpleadoDto> modificarSegundoNombre(@PathVariable Long id,
                                                              @RequestParam("segundo-nombre") String segundoNombre){
        return ResponseEntity.ok(service.modificarSegundoNombre(id, segundoNombre));
    }

    @PatchMapping("/{id}/apellido-paterno") // funciona
    public ResponseEntity<EmpleadoDto> modificarApellidopPaterno(@PathVariable Long id,
                                                                 @RequestParam("apellido-paterno") String apellidoPaterno){
        return ResponseEntity.ok(service.modificarApellidoPaterno(id, apellidoPaterno));
    }

    @PatchMapping("/{id}/apellido-materno") // funciona
    public ResponseEntity<EmpleadoDto> nmodificarApellidoMaterno(@PathVariable Long id,
                                                                 @RequestParam("apellido-materno") String apellidoMaterno){
        return ResponseEntity.ok(service.modificarApellidoMaterno(id, apellidoMaterno));
    }

    @PatchMapping("/{id}/email") // funciona
    public ResponseEntity<EmpleadoDto> modificarEmail(@PathVariable Long id,
                                                      @RequestParam String email){
        return ResponseEntity.ok(service.modificarEmail(id,email));
    }

    @PatchMapping("/{id}/domicilio") // funciona
    public ResponseEntity<EmpleadoDto> modificarDomicilio(@PathVariable Long id,
                                                          @RequestParam("domicilio-id") Long domicilioId){
        return ResponseEntity.ok(service.modificarDomicilio(id, domicilioId));
    }

    @PatchMapping("/{id}/agregar-telefono") // funciona
    public ResponseEntity<EmpleadoDto> agregarTelefono(@PathVariable Long id,
                                                       @RequestParam String telefono){
        return ResponseEntity.ok(service.agregarTelefono(id, telefono));
    }

    @PatchMapping("/{id}/quitar-telefono") // funciona
    public ResponseEntity<EmpleadoDto> quitarTelefono(@PathVariable Long id,
                                                      @RequestParam String telefono){
        return ResponseEntity.ok(service.quitarTelefono(id, telefono));
    }

    @PatchMapping("/{id}/matricula") // funciona
    public ResponseEntity<EmpleadoDto> modificarMatriculaProfesional(@PathVariable Long id,
                                                                     @RequestParam String matricula){
        return ResponseEntity.ok(service.modificarMatriculaProfesional(id, matricula));
    }

    @PatchMapping("/{id}/rol") // funciona
    public ResponseEntity<EmpleadoDto> modificarRol(@PathVariable Long id,
                                                    @RequestParam("rol-id") Long rolId){
        return ResponseEntity.ok(service.modificarRol(id,rolId));
    }

    @PatchMapping("/{id}/salario") // funciona
    public ResponseEntity<EmpleadoDto> modificarSalario(@PathVariable Long id,
                                                        @RequestParam Float salario){
        return ResponseEntity.ok(service.modificarSalario(id, salario));
    }
}
