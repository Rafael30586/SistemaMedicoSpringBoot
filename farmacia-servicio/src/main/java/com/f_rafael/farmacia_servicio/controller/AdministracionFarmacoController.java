package com.f_rafael.farmacia_servicio.controller;

import com.f_rafael.farmacia_servicio.dto.AdministracionFarmacoDto;
import com.f_rafael.farmacia_servicio.model.AdministracionFarmaco;
import com.f_rafael.farmacia_servicio.service.IAdministracionFarmacoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("administraciones-de-farmaco")
@AllArgsConstructor
public class AdministracionFarmacoController {

    private IAdministracionFarmacoService service;

    @GetMapping("/{id}")
    public ResponseEntity<AdministracionFarmacoDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<AdministracionFarmacoDto>> buscarTodas(){
        return ResponseEntity.ok(service.buscarTodas());
    }

    @GetMapping
    public ResponseEntity<AdministracionFarmacoDto> buscarPorVia(@RequestParam String via){
        return ResponseEntity.ok(service.buscarPorVia(via));
    }

    @PostMapping
    public ResponseEntity<AdministracionFarmacoDto> guardar(@RequestBody AdministracionFarmaco administracionFarmaco){
        return new ResponseEntity<>(service.guardar(administracionFarmaco),
                HttpStatusCode.valueOf(201));
    }

    @PutMapping
    public ResponseEntity<AdministracionFarmacoDto> actualizar(@RequestBody AdministracionFarmaco administracionFarmaco){
        return ResponseEntity.ok(service.actualizar(administracionFarmaco));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        service.buscarPorId(id);
        return new ResponseEntity<>("Entidad borrada correctamente", HttpStatusCode.valueOf(204));
    }
}
