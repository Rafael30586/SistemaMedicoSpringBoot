package com.f_rafael.farmacia_servicio.controller;

import com.f_rafael.farmacia_servicio.dto.MarcaMedicamentoDto;
import com.f_rafael.farmacia_servicio.model.MarcaMedicamento;
import com.f_rafael.farmacia_servicio.service.IMarcaMedicamentoService;
import com.f_rafael.farmacia_servicio.utils.TransformacionMarcaMedicamento;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marcas")
@AllArgsConstructor
public class MarcaMedicamentoController {

    private IMarcaMedicamentoService service;

    @GetMapping("/{id}")
    public ResponseEntity<MarcaMedicamentoDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId2(id));
    }

    @GetMapping
    public ResponseEntity<List<MarcaMedicamentoDto>> buscarTodas(){
        return ResponseEntity.ok(service.buscarTodas2());
    }

    @GetMapping
    public ResponseEntity<MarcaMedicamentoDto> buscarPorNombre(@RequestParam String nombre){
        return ResponseEntity.ok(service.buscarPorNombre2(nombre));
    }

    @PostMapping
    public ResponseEntity<MarcaMedicamentoDto> guardar(@RequestBody MarcaMedicamento marcaMedicamento){
        return new ResponseEntity<>(service.guardar2(marcaMedicamento),HttpStatusCode.valueOf(201));
    }

    @PutMapping
    public ResponseEntity<MarcaMedicamentoDto> actualizar(@RequestBody MarcaMedicamento marcaMedicamento){
        return ResponseEntity.ok(service.actualizar2(marcaMedicamento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        service.borrarPorId2(id);
        return new ResponseEntity<>("Entidad borrada exitosamente", HttpStatusCode.valueOf(204));
    }
}
