package com.f_rafael.hospital_servicio.controller;

import com.f_rafael.hospital_servicio.model.TratamientoQuirurgico;
import com.f_rafael.hospital_servicio.service.ITratamientoQuirurgicoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tratamientos-quirurgicos")
public class TratamientoQuirurgicoController {

    private ITratamientoQuirurgicoService service;

    @GetMapping("/{id}")
    public ResponseEntity<TratamientoQuirurgico> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<TratamientoQuirurgico>> buscarTodos(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping
    public ResponseEntity<TratamientoQuirurgico> buscarPorNombre(@RequestParam String nombre){
        return ResponseEntity.ok(service.buscarPorNombre(nombre));
    }

    @GetMapping
    public ResponseEntity<List<TratamientoQuirurgico>> buscarPorDescripcion(@RequestParam String secuencia){
        return ResponseEntity.ok(service.buscarPorDescripcion(secuencia));
    }

    @PostMapping
    public ResponseEntity<TratamientoQuirurgico> guardar(@RequestBody TratamientoQuirurgico tratamientoQuirurgico){
        return new ResponseEntity<>(service.guardar(tratamientoQuirurgico), HttpStatusCode.valueOf(201));
    }

    @PutMapping
    public ResponseEntity<TratamientoQuirurgico> actualizar(@RequestBody TratamientoQuirurgico tratamientoQuirurgico){
        return ResponseEntity.ok(service.actualizar(tratamientoQuirurgico));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        service.borrarPorId(id);
        return new ResponseEntity<>("El tratamiento ha sido borrado",HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TratamientoQuirurgico> modificarNombre(@PathVariable Long id,
                                                                 @RequestParam String nombre){
        return ResponseEntity.ok(service.modificarNombre(id, nombre));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TratamientoQuirurgico> modificarDescripcion(@PathVariable Long id,
                                                                      @RequestParam String descripcion){
        return ResponseEntity.ok(service.modificarDescripcion(id, descripcion));
    }
}
