package com.f_rafael.hospital_servicio.controller;

import com.f_rafael.hospital_servicio.dto.SintomaDto;
import com.f_rafael.hospital_servicio.model.Sintoma;
import com.f_rafael.hospital_servicio.service.ISintomaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/sintomas")
public class SintomaController {

    private ISintomaService service;

    @GetMapping("/{id}") // funciona
    public ResponseEntity<SintomaDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping // funciona
    public ResponseEntity<List<SintomaDto>> buscarTodos(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("/nombre") // funciona
    public ResponseEntity<SintomaDto> buscarPorNombre(@RequestParam String nombre){
        return ResponseEntity.ok(service.buscarPorNombre(nombre));
    }

    @PostMapping // funciona
    public ResponseEntity<SintomaDto> guardar(@RequestBody Sintoma sintoma){
        return new ResponseEntity<>(service.guardar(sintoma), HttpStatusCode.valueOf(201));
    }

    @PutMapping // funciona
    public ResponseEntity<SintomaDto> actualizar(@RequestBody Sintoma sintoma){
        return ResponseEntity.ok(service.actualizar(sintoma));
    }

    @DeleteMapping("/{id}") // funciona
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        service.borrarPorId(id);
        return new ResponseEntity<>("El síntoma ha sido borrado", HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}/nombre") // funciona
    public ResponseEntity<SintomaDto> modificarNombre(@PathVariable Long id, @RequestParam String nombre){
        return ResponseEntity.ok(service.modificarNombre(id, nombre));
    }
}
