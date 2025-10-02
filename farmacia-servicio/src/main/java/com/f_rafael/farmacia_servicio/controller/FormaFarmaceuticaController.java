package com.f_rafael.farmacia_servicio.controller;

import com.f_rafael.farmacia_servicio.dto.FormaFarmaceuticaDto;
import com.f_rafael.farmacia_servicio.model.FormaFarmaceutica;
import com.f_rafael.farmacia_servicio.service.IFormaFarmaceuticaService;
import com.f_rafael.farmacia_servicio.utils.TransformacionFormaFarmaceutica;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formas-farmaceuticas")
@AllArgsConstructor
public class FormaFarmaceuticaController {

    private IFormaFarmaceuticaService service;

    @GetMapping("/{id}")
    public ResponseEntity<FormaFarmaceuticaDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId2(id));
    }

    @GetMapping
    public ResponseEntity<List<FormaFarmaceuticaDto>> buscarTodas(){
        return ResponseEntity.ok(service.buscarTodas2());
    }

    @GetMapping
    public ResponseEntity<FormaFarmaceuticaDto> buscarPorNombre(@RequestParam String nombre){
        return ResponseEntity.ok(service.buscarPorNombre2(nombre));
    }

    @PostMapping
    public ResponseEntity<FormaFarmaceuticaDto> guardar(@RequestBody FormaFarmaceutica formaFarmaceutica){
        return ResponseEntity.ok(service.guardar2(formaFarmaceutica));
    }

    @PutMapping
    public ResponseEntity<FormaFarmaceuticaDto> actualizar(@RequestBody FormaFarmaceutica formaFarmaceutica){
        return ResponseEntity.ok(service.actualizar2(formaFarmaceutica));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        service.borrarPorId2(id);
        return new ResponseEntity<>("Entidad borrada correctamente",HttpStatusCode.valueOf(204));
    }
}
