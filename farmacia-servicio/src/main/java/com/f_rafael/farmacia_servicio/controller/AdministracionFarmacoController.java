package com.f_rafael.farmacia_servicio.controller;

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
    public ResponseEntity<AdministracionFarmaco> buscarPorId(@PathVariable Long id){

        if(service.buscarPorId(id).isPresent()){
            return ResponseEntity.ok(service.buscarPorId(id).get());
        }else{
            return new ResponseEntity<>(new AdministracionFarmaco(-9999L,"Entidad no encontrada"),
                    HttpStatusCode.valueOf(204));
        }
    }

    @GetMapping
    public ResponseEntity<List<AdministracionFarmaco>> buscarTodas(){
        return ResponseEntity.ok(service.buscarTodas());
    }

    @GetMapping
    public ResponseEntity<AdministracionFarmaco> buscarPorVia(@RequestParam String via){

        if(service.buscarPorVia(via).isEmpty()){
            return new ResponseEntity<>(new AdministracionFarmaco(-9999L,"Entidad no encontrada"),
                    HttpStatusCode.valueOf(204));
        }

        return ResponseEntity.ok(service.buscarPorVia(via).get());
    }

    @PostMapping
    public ResponseEntity<AdministracionFarmaco> guardar(@RequestBody AdministracionFarmaco administracionFarmaco){
        return new ResponseEntity<>(service.guardar(administracionFarmaco),
                HttpStatusCode.valueOf(201));
    }

    @PutMapping
    public ResponseEntity<AdministracionFarmaco> actualizar(@RequestBody AdministracionFarmaco administracionFarmaco){
        Long id = administracionFarmaco.getId();

        if(id == null){
            return new ResponseEntity<>(new AdministracionFarmaco(-999999L,"El id no debe ser nulo"),
                    HttpStatusCode.valueOf(204));
        }

        if(service.buscarPorId(id).isEmpty()){
            return new ResponseEntity<>(new AdministracionFarmaco(-999999L,"Entidad no encontrada"),
                    HttpStatusCode.valueOf(204));
        }

        return ResponseEntity.ok(service.actualizar(administracionFarmaco));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        if(service.buscarPorId(id).isEmpty()){
            return new ResponseEntity<>("Entidad no encontrada",HttpStatusCode.valueOf(204));
        }else{
            service.borrarPorId(id);
            return ResponseEntity.ok("Entidad borrada");
        }
    }
}
