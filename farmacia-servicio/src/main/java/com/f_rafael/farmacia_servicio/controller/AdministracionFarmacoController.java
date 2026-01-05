package com.f_rafael.farmacia_servicio.controller;

import com.f_rafael.farmacia_servicio.dto.AdministracionFarmacoDto;
import com.f_rafael.farmacia_servicio.model.AdministracionFarmaco;
import com.f_rafael.farmacia_servicio.service.IAdministracionFarmacoService;
import com.f_rafael.farmacia_servicio.utils.Transformacion;
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

    @GetMapping("/{id}") // funciona
    public ResponseEntity<AdministracionFarmacoDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping // funciona
    public ResponseEntity<List<AdministracionFarmacoDto>> buscarTodas(){
        return ResponseEntity.ok(service.buscarTodas());
    }

    @GetMapping("/via") // funciona
    public ResponseEntity<AdministracionFarmacoDto> buscarPorVia(@RequestParam String via){
        String viaSinGuiones = Transformacion.removerGuionesBajos(via);
        return ResponseEntity.ok(service.buscarPorVia(viaSinGuiones));
    }

    @PostMapping // funciona
    public ResponseEntity<AdministracionFarmacoDto> guardar(@RequestBody AdministracionFarmaco administracionFarmaco){
        return new ResponseEntity<>(service.guardar(administracionFarmaco),
                HttpStatusCode.valueOf(201));
    }

    @PutMapping // funciona
    public ResponseEntity<AdministracionFarmacoDto> actualizar(@RequestBody AdministracionFarmaco administracionFarmaco){
        return ResponseEntity.ok(service.actualizar(administracionFarmaco));
    }

    @DeleteMapping("/{id}") // funciona
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        service.buscarPorId(id);
        return new ResponseEntity<>("Entidad borrada correctamente", HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}/via") // funciona
    public ResponseEntity<String> modificarVia(@PathVariable Long id,@RequestParam String via){
        service.modificarVia(id, via);
        return new ResponseEntity<>("Administración modificada correctamente",HttpStatusCode.valueOf(204));
    }
}
