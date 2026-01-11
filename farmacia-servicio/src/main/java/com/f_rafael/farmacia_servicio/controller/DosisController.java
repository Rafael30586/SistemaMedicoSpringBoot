package com.f_rafael.farmacia_servicio.controller;

import com.f_rafael.farmacia_servicio.model.Dosis;
import com.f_rafael.farmacia_servicio.model.UnidadDeMedida;
import com.f_rafael.farmacia_servicio.service.IDosisService;
import com.f_rafael.farmacia_servicio.utils.Transformacion;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dosis")
@AllArgsConstructor
public class DosisController {

    private IDosisService service;

    @GetMapping("/{id}") // funciona
    public ResponseEntity<Dosis> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping // funciona
    public ResponseEntity<List<Dosis>> buscarTodas(){
        return ResponseEntity.ok(service.buscarTodas());
    }

    @GetMapping("/cantidad-unidad-intervalo") // funciona
    public ResponseEntity<Dosis> buscarPorCantidadUnidadEIntervalo(@RequestParam Float cantidad,
                                                                   @RequestParam("nombre-unidad") String nombreUnidad,
                                                                   @RequestParam Integer intervalo){
        // String nombreUnidadSinGuiones = Transformacion.removerGuionesBajos(nombreUnidad);
        return ResponseEntity.ok(service.buscarPorCantidadUnidadEIntervalo(cantidad,nombreUnidad,intervalo));
    }

    @PostMapping // funciona
    public ResponseEntity<Dosis> guardar(@RequestBody Dosis dosis){
        return new ResponseEntity<>(service.guardar(dosis),
                HttpStatusCode.valueOf(201));
    }

    @PutMapping // funciona
    public ResponseEntity<Dosis> actualizar(@RequestBody Dosis dosis){
        return ResponseEntity.ok(service.actualizar(dosis));
    }

    @DeleteMapping("/{id}") // funciona
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){

        service.borrarPorId(id);
        return new ResponseEntity<>("Entidad borrada correctamente",
                HttpStatusCode.valueOf(204));

    }

    @PatchMapping("/{id}/cantidad") // funciona
    public ResponseEntity<String> modificarCantidad(@PathVariable Long id, @RequestParam Float cantidad){
        service.modificarCantidad(id, cantidad);
        return new ResponseEntity<>("La entidad ha sido modificada", HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}/unidad") // funciona
    public ResponseEntity<String> modificarUnidad(@PathVariable Long id, @RequestParam("unidad-id") Long unidadId){
        service.modificarUnidad(id, unidadId);
        return new ResponseEntity<>("La entidad ha sido modificada", HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}/intervalo") // funciona
    public ResponseEntity<String> modificarIntervalo(@PathVariable Long id, @RequestParam Integer intervalo){
        service.modificarIntervalo(id,intervalo);
        return new ResponseEntity<>("La entidad ha sido modificada", HttpStatusCode.valueOf(204));
    }
}
