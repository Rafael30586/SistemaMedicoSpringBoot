package com.f_rafael.hospital_servicio.controller;

import com.f_rafael.hospital_servicio.dto.DiagnosticoDto;
import com.f_rafael.hospital_servicio.model.Diagnostico;
import com.f_rafael.hospital_servicio.service.IDiagnosticoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diagnosticos")
@AllArgsConstructor
public class DiagnosticoController {

    private IDiagnosticoService service;

    @GetMapping("/{id}") // funciona
    public ResponseEntity<DiagnosticoDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping // funciona
    public ResponseEntity<List<DiagnosticoDto>> buscarTodos(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("/nombre") // funciona
    public ResponseEntity<DiagnosticoDto> buscarPorNombre(@RequestParam String nombre){
        return ResponseEntity.ok(service.buscarPorNombre(nombre));
    }

    @PostMapping // funciona
    public ResponseEntity<DiagnosticoDto> guardar(@RequestBody Diagnostico diagnostico){
        return new ResponseEntity<>(service.guardar(diagnostico), HttpStatusCode.valueOf(201));
    }

    @PutMapping // funciona
    public ResponseEntity<DiagnosticoDto> actualizar(@RequestBody Diagnostico diagnostico){
        return ResponseEntity.ok(service.actualizar(diagnostico));
    }

    @DeleteMapping("/{id}") // funciona
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        service.borrarPorId(id);
        return new ResponseEntity("El diagnóstico se ha borrado",HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}/agregar-sintoma") // funciona
    public ResponseEntity<DiagnosticoDto> agregarSintoma(@PathVariable Long id,
                                                         @RequestParam("sintoma-id") Long sintomaId){
        return ResponseEntity.ok(service.agregarSintoma(id, sintomaId));
    }

    @PatchMapping("/{id}/quitar-sintoma") // funciona
    public ResponseEntity<DiagnosticoDto> quitarSintoma(@PathVariable Long id,
                                                        @RequestParam("sintoma-id") Long sintomaId){
        return ResponseEntity.ok(service.quitarSintoma(id, sintomaId));
    }

    @PatchMapping("/{id}/agregar-signo") // funciona
    public ResponseEntity<DiagnosticoDto> agregarSigno(@PathVariable Long id,
                                                       @RequestParam("signo-id") Long signoId){
        return ResponseEntity.ok(service.agregarSigno(id, signoId));
    }

    @PatchMapping("/{id}/quitar-signo") // funciona
    public ResponseEntity<DiagnosticoDto> quitarSigno(@PathVariable Long id,
                                                      @RequestParam("signo-id") Long signoId){
        return ResponseEntity.ok(service.quitarSigno(id, signoId));
    }
}
