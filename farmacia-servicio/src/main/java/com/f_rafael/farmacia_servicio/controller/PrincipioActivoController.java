package com.f_rafael.farmacia_servicio.controller;

import com.f_rafael.farmacia_servicio.dto.PrincipioActivoDto;
import com.f_rafael.farmacia_servicio.model.PrincipioActivo;
import com.f_rafael.farmacia_servicio.service.IPrincipioActivoService;
import com.f_rafael.farmacia_servicio.utils.TransformacionPrincipioActivo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/principios-activos")
@AllArgsConstructor
public class PrincipioActivoController {

    private IPrincipioActivoService service;

    @GetMapping("/{id}")
    public ResponseEntity<PrincipioActivoDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId2(id));
    }

    @GetMapping
    public ResponseEntity<List<PrincipioActivoDto>> buscarTodos(){
        return ResponseEntity.ok(service.buscarTodos2());
    }

    @GetMapping
    public ResponseEntity<List<PrincipioActivoDto>> buscarPorAccionTerapeutica(@RequestParam("nombre-accion-terapeutica") String nombreAccionTerapeutica){
        return ResponseEntity.ok(service.buscarPorAccionTerapeutica2(nombreAccionTerapeutica));
    }

    @PostMapping
    public ResponseEntity<PrincipioActivoDto> guardar(@RequestBody PrincipioActivo principioActivo){
        return new ResponseEntity<>(service.guardar2(principioActivo),HttpStatusCode.valueOf(201));
    }

    @PutMapping
    public ResponseEntity<PrincipioActivoDto> actualizar(@RequestBody PrincipioActivo principioActivo){
        return ResponseEntity.ok(service.actualizar2(principioActivo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        service.borrarPorId2(id);
        return new ResponseEntity<>("Entidad borrada corrctamente",HttpStatusCode.valueOf(204));
    }
}
