package com.f_rafael.farmacia_servicio.controller;

import com.f_rafael.farmacia_servicio.dto.AdministracionFarmacoDto;
import com.f_rafael.farmacia_servicio.model.AdministracionFarmaco;
import com.f_rafael.farmacia_servicio.service.IAdministracionFarmacoService;
import com.f_rafael.farmacia_servicio.utils.TransformacionAdministracionFarmaco;
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

        if(service.buscarPorId(id).isPresent()){
            return ResponseEntity.ok(TransformacionAdministracionFarmaco.obtenerDto(service.buscarPorId(id).get()));
        }else{
            return new ResponseEntity<>(TransformacionAdministracionFarmaco.obtenerDto(new AdministracionFarmaco(-9999L,"Entidad no encontrada",null)) ,
                    HttpStatusCode.valueOf(204));
        }
    }

    @GetMapping
    public ResponseEntity<List<AdministracionFarmacoDto>> buscarTodas(){
        return ResponseEntity.ok(TransformacionAdministracionFarmaco.obtenerListaDtos(service.buscarTodas()));
    }

    @GetMapping
    public ResponseEntity<AdministracionFarmacoDto> buscarPorVia(@RequestParam String via){

        if(service.buscarPorVia(via).isEmpty()){
            return new ResponseEntity<>(TransformacionAdministracionFarmaco.obtenerDto(new AdministracionFarmaco(-9999L,"Entidad no encontrada",null)),
                    HttpStatusCode.valueOf(204));
        }

        return ResponseEntity.ok(TransformacionAdministracionFarmaco.obtenerDto(service.buscarPorVia(via).get()));
    }

    @PostMapping
    public ResponseEntity<AdministracionFarmacoDto> guardar(@RequestBody AdministracionFarmaco administracionFarmaco){
        return new ResponseEntity<>(TransformacionAdministracionFarmaco.obtenerDto(service.guardar(administracionFarmaco)),
                HttpStatusCode.valueOf(201));
    }

    @PutMapping
    public ResponseEntity<AdministracionFarmacoDto> actualizar(@RequestBody AdministracionFarmaco administracionFarmaco){
        Long id = administracionFarmaco.getId();

        if(id == null){
            return new ResponseEntity<>(TransformacionAdministracionFarmaco.obtenerDto(new AdministracionFarmaco(-999999L,"El id no debe ser nulo",null)),
                    HttpStatusCode.valueOf(204));
        }

        if(service.buscarPorId(id).isEmpty()){
            return new ResponseEntity<>(TransformacionAdministracionFarmaco.obtenerDto(new AdministracionFarmaco(-999999L,"Entidad no encontrada",null)),
                    HttpStatusCode.valueOf(204));
        }

        return ResponseEntity.ok(TransformacionAdministracionFarmaco.obtenerDto(service.actualizar(administracionFarmaco)));
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
