package com.f_rafael.farmacia_servicio.controller;

import com.f_rafael.farmacia_servicio.dto.MedicamentoDto;
import com.f_rafael.farmacia_servicio.model.Medicamento;
import com.f_rafael.farmacia_servicio.model.PrincipioActivo;
import com.f_rafael.farmacia_servicio.service.IMedicamentoService;
import com.f_rafael.farmacia_servicio.utils.TransformacionMedicamento;
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
        return ResponseEntity.ok(TransformacionMedicamento.obtenerDto(service.buscarPorId(id).get()));
    }

    @GetMapping
    public ResponseEntity<List<MedicamentoDto>> buscarTodos(){
        return ResponseEntity.ok(service.buscarTodos2());
    }

    @GetMapping
    public ResponseEntity<List<MedicamentoDto>> buscarPorPrincipioActivo(@RequestParam("nombre-principio-activo") String nombrePrincipioActivo){
        return ResponseEntity.ok(service.buscarPorPrincipioActivo2(nombrePrincipioActivo));
    }

    @GetMapping
    public ResponseEntity<List<MedicamentoDto>> buscarPorFormaFarmaceutica(@RequestParam("nombre-forma-farmaceutica") String nombreFormaFarmaceutica){
        return ResponseEntity.ok(service.buscarPorFormaFarmaceutica2(nombreFormaFarmaceutica));
    }

    @GetMapping
    public ResponseEntity<List<MedicamentoDto>> buscarPorAdminiastracion(@RequestParam("via") String via){
        return ResponseEntity.ok(service.buscarPorAdministracion2(via));
    }

    @GetMapping
    public ResponseEntity<List<MedicamentoDto>> buscarPorMarca(@RequestParam("nombre-marca") String nombreMarca){
        return ResponseEntity.ok(service.buscarPorMarca2(nombreMarca));
    }

    @PostMapping
    public ResponseEntity<MedicamentoDto> guardar(@RequestBody Medicamento medicamento){
        return new ResponseEntity<>(service.guardar2(medicamento),HttpStatusCode.valueOf(201));
    }

    @PutMapping
    public ResponseEntity<MedicamentoDto> actualizar(@RequestBody Medicamento medicamento){
        return ResponseEntity.ok(service.actualizar2(medicamento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        service.borrarPorId2(id);
        return new ResponseEntity<>("Entidad borrada correctamente",HttpStatusCode.valueOf(204));
    }
}
