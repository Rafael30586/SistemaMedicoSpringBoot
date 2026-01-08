package com.f_rafael.farmacia_servicio.controller;

import com.f_rafael.farmacia_servicio.dto.AccionTerapeuticaDto;
import com.f_rafael.farmacia_servicio.dto.DescripcionDto;
import com.f_rafael.farmacia_servicio.model.AccionTerapeutica;
import com.f_rafael.farmacia_servicio.service.IAccionTerapeuticaService;
import com.f_rafael.farmacia_servicio.utils.Transformacion;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acciones-terapeuticas")
@AllArgsConstructor
public class AccionTerapeuticaController {

    private IAccionTerapeuticaService service;

    @GetMapping("/{id}") // funciona
    public ResponseEntity<AccionTerapeuticaDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping // funciona
    public ResponseEntity<List<AccionTerapeuticaDto>> buscarTodas(){
        return ResponseEntity.ok(service.buscarTodas());
    }

    @GetMapping("/nombre") // funciona
    public ResponseEntity<AccionTerapeuticaDto> buscarPorNombre(@RequestParam String nombre){
        String nombreSinGuiones = Transformacion.removerGuionesBajos(nombre);
        return ResponseEntity.ok(service.buscarPorNombre(nombreSinGuiones));
    }

    @GetMapping("/secuencia-descripcion") // funciona
    public ResponseEntity<List<AccionTerapeuticaDto>> buscarPorSecuenciaEnDescripcion(@RequestParam String secuencia){
        // String secuenciaSinGuiones = Transformacion.removerGuionesBajos(secuencia);
        return ResponseEntity.ok(service.buscarPorSecuenciaEnDescripcion(secuencia));
    }

    @PostMapping // funciona
    public ResponseEntity<AccionTerapeuticaDto> guardar(@RequestBody AccionTerapeutica accionTerapeutica){
        return new ResponseEntity<>(service.guardar(accionTerapeutica),HttpStatusCode.valueOf(201));
    }

    @PutMapping // funciona
    public ResponseEntity<AccionTerapeuticaDto> actualizar(@RequestBody AccionTerapeutica accionTerapeutica){
        return ResponseEntity.ok(service.actualizar(accionTerapeutica));
    }

    @DeleteMapping("/{id}") // funciona
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        service.borrarPorId(id);
        return new ResponseEntity<>("Entidad borrada correctamente", HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}/nombre") // funciona
    public ResponseEntity<String> modificarNombre(@PathVariable Long id, @RequestParam String nombre){
        // String nombreSinGuiones = Transformacion.removerGuionesBajos(nombre);
        service.modificarNombre(id,nombre);
        return new ResponseEntity<>("Entidad modificada correctamente",HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}/descripcion") // funciona
    public ResponseEntity<String> modificarDescripcion(@PathVariable Long id, @RequestBody DescripcionDto descripcion){
        service.modificarDescripcion(id,descripcion);
        return new ResponseEntity<>("Entidad modificada correctamente", HttpStatusCode.valueOf(204));
    }
}
