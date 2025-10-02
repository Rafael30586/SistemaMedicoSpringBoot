package com.f_rafael.farmacia_servicio.controller;

import com.f_rafael.farmacia_servicio.dto.MedicamentoDto;
import com.f_rafael.farmacia_servicio.model.Medicamento;
import com.f_rafael.farmacia_servicio.service.IMedicamentoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicamentos")
@AllArgsConstructor
public class MedicamentoController {

    private IMedicamentoService service;

    @GetMapping("/{id}")
    public ResponseEntity<MedicamentoDto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<MedicamentoDto>> buscarTodos(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping
    public ResponseEntity<List<MedicamentoDto>> buscarPorPrincipioActivo(@RequestParam("nombre-principio-activo") String nombrePrincipioActivo){
        return ResponseEntity.ok(service.buscarPorPrincipioActivo(nombrePrincipioActivo));
    }

    @GetMapping
    public ResponseEntity<List<MedicamentoDto>> buscarPorFormaFarmaceutica(@RequestParam("nombre-forma-farmaceutica") String nombreFormaFarmaceutica){
        return ResponseEntity.ok(service.buscarPorFormaFarmaceutica(nombreFormaFarmaceutica));
    }

    @GetMapping
    public ResponseEntity<List<MedicamentoDto>> buscarPorAdminiastracion(@RequestParam("via") String via){
        return ResponseEntity.ok(service.buscarPorAdministracion(via));
    }

    @GetMapping
    public ResponseEntity<List<MedicamentoDto>> buscarPorMarca(@RequestParam("nombre-marca") String nombreMarca){
        return ResponseEntity.ok(service.buscarPorMarca(nombreMarca));
    }

    @PostMapping
    public ResponseEntity<MedicamentoDto> guardar(@RequestBody Medicamento medicamento){
        return new ResponseEntity<>(service.guardar(medicamento),HttpStatusCode.valueOf(201));
    }

    @PutMapping
    public ResponseEntity<MedicamentoDto> actualizar(@RequestBody Medicamento medicamento){
        return ResponseEntity.ok(service.actualizar(medicamento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        service.borrarPorId(id);
        return new ResponseEntity<>("Entidad borrada correctamente",HttpStatusCode.valueOf(204));
    }
}
