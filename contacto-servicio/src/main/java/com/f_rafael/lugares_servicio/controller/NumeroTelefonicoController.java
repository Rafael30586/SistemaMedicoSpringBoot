package com.f_rafael.lugares_servicio.controller;

import com.f_rafael.lugares_servicio.model.NumeroTelefonico;
import com.f_rafael.lugares_servicio.service.INumeroTelefonicoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/numeros-telefonicos")
@AllArgsConstructor
public class NumeroTelefonicoController { // Clase para borrar

    private INumeroTelefonicoService service;

    @GetMapping("/{id}")
    public ResponseEntity<NumeroTelefonico> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<NumeroTelefonico>> buscarTodos(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping
    public ResponseEntity<NumeroTelefonico> buscarPorNumero(@RequestParam String numero){
        return ResponseEntity.ok(service.buscarPorNumero(numero));
    }

    @GetMapping
    public ResponseEntity<List<NumeroTelefonico>> buscarPorTipo(@RequestParam String tipo){
        String tipoEnMayusculas = tipo.toUpperCase();
        return ResponseEntity.ok(service.buscarPorTipo(tipoEnMayusculas));
    }

    @PostMapping
    public ResponseEntity<NumeroTelefonico> guardar(@RequestBody NumeroTelefonico telefono){
        return new ResponseEntity<>(service.guardar(telefono),HttpStatusCode.valueOf(201));
    }

    @PutMapping
    public ResponseEntity<NumeroTelefonico> actualizar(@RequestBody NumeroTelefonico telefono){
        return ResponseEntity.ok(service.actualizar(telefono));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        service.borrarPorId(id);
        return new ResponseEntity<>("Entidad borrada correctamente",HttpStatusCode.valueOf(204));
    }
}
