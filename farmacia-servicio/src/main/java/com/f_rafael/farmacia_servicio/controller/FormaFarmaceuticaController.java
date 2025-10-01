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

        if(service.buscarPorId(id).isEmpty()){
            return new ResponseEntity<>(TransformacionFormaFarmaceutica.obtenerDto(new FormaFarmaceutica(-99999L,"Entidad no encontrada",null)),
                    HttpStatusCode.valueOf(204));
        }

        return ResponseEntity.ok(TransformacionFormaFarmaceutica.obtenerDto(service.buscarPorId(id).get()));
    }

    @GetMapping
    public ResponseEntity<List<FormaFarmaceuticaDto>> buscarTodas(){

        return ResponseEntity.ok(TransformacionFormaFarmaceutica.obtenerListaDtos(service.buscarTodas()));
    }

    @GetMapping
    public ResponseEntity<FormaFarmaceuticaDto> buscarPorNombre(@RequestParam String nombre){

        if(service.buscarPorNombre(nombre).isEmpty()){
            return new ResponseEntity<>(TransformacionFormaFarmaceutica.obtenerDto(new FormaFarmaceutica(-9999L,"Entidad no encontrada",null)),
                    HttpStatusCode.valueOf(204));
        }

        return ResponseEntity.ok(TransformacionFormaFarmaceutica.obtenerDto(service.buscarPorNombre(nombre).get()));
    }

    @PostMapping
    public ResponseEntity<FormaFarmaceuticaDto> guardar(@RequestBody FormaFarmaceutica formaFarmaceutica){
        return ResponseEntity.ok(TransformacionFormaFarmaceutica.obtenerDto(service.guardar(formaFarmaceutica)));
    }

    @PutMapping
    public ResponseEntity<FormaFarmaceuticaDto> actualizar(@RequestBody FormaFarmaceutica formaFarmaceutica){
        Long id = formaFarmaceutica.getId();

        if(id == null){
            return new ResponseEntity<>(TransformacionFormaFarmaceutica.obtenerDto(new FormaFarmaceutica(-9999L,"El id no debe ser nulo",null)),
                    HttpStatusCode.valueOf(204));
        }

        if(service.buscarPorId(id).isEmpty()){
            return new ResponseEntity<>(TransformacionFormaFarmaceutica.obtenerDto(new FormaFarmaceutica(-99999L,"Entidad no encontrada",null)),
                    HttpStatusCode.valueOf(204));
        }

        return ResponseEntity.ok(TransformacionFormaFarmaceutica.obtenerDto(service.actualizar(formaFarmaceutica)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        if(service.buscarPorId(id).isEmpty()){
            return new ResponseEntity<>("Entidad no encontrada",
                    HttpStatusCode.valueOf(204));
        }

        service.borrarPorId(id);
        return ResponseEntity.ok("Entidad borrada correctamente");
    }
}
