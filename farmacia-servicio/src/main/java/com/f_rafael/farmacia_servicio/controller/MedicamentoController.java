package com.f_rafael.farmacia_servicio.controller;

import com.f_rafael.farmacia_servicio.dto.MedicamentoDto;
import com.f_rafael.farmacia_servicio.model.Medicamento;
import com.f_rafael.farmacia_servicio.service.IMedicamentoService;
import com.f_rafael.farmacia_servicio.utils.Transformacion;
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

    @GetMapping("/principio-activo")
    public ResponseEntity<List<MedicamentoDto>> buscarPorPrincipioActivo(@RequestParam("nombre-principio-activo") String nombrePrincipioActivo){
        String principioActivoSinGuiones = Transformacion.removerGuionesBajos(nombrePrincipioActivo);
        return ResponseEntity.ok(service.buscarPorPrincipioActivo(principioActivoSinGuiones));
    }

    @GetMapping("/forma-farmaceutica")
    public ResponseEntity<List<MedicamentoDto>> buscarPorFormaFarmaceutica(@RequestParam("nombre-forma-farmaceutica") String nombreFormaFarmaceutica){
        String formaFarmaceuticaSinGuiones = Transformacion.removerGuionesBajos(nombreFormaFarmaceutica);
        return ResponseEntity.ok(service.buscarPorFormaFarmaceutica(formaFarmaceuticaSinGuiones));
    }

    @GetMapping("/administracion")
    public ResponseEntity<List<MedicamentoDto>> buscarPorAdminiastracion(@RequestParam("via") String via){
        String viaSinGuiones = Transformacion.removerGuionesBajos(via);
        return ResponseEntity.ok(service.buscarPorAdministracion(viaSinGuiones));
    }

    @GetMapping("/marca")
    public ResponseEntity<List<MedicamentoDto>> buscarPorMarca(@RequestParam("nombre-marca") String nombreMarca){
        String marcaSinGuiones = Transformacion.removerGuionesBajos(nombreMarca);
        return ResponseEntity.ok(service.buscarPorMarca(marcaSinGuiones));
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
/*
    @PatchMapping("/{id}/principio-activo")
    public ResponseEntity<String> asignarPrincipioActivo(@RequestParam Long id,
                                                         @RequestParam("principio-activo-id") Long principioActivoId){
        service.asignarPrincipioActivo(id,principioActivoId);
        return new ResponseEntity<>("Entidad midificada correctamente",HttpStatusCode.valueOf(204));
    }*/

    @PatchMapping("/{id}/principio-activo")
    public ResponseEntity<String> agregarPrincipioActivo(@PathVariable Long id,
                                                         @RequestParam("principio-activo-id") Long principioActivoId){
        service.agregarPrincpioActivo(id, principioActivoId);
        return new ResponseEntity<>("Entidad modificada correctamente", HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}/principio-activo")
    public ResponseEntity<String> quitarPrincipioActivo(@PathVariable Long id,
                                                        @RequestParam("principio-activo-id") Long principioActivoId){
        service.quitarPrincipioActivo(id, principioActivoId);
        return new ResponseEntity<>("Entidad modificada correctamente", HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}/forma-farmaceutica")
    public ResponseEntity<String> asignarFormaFarmaceutica(@RequestParam Long id,
                                                           @RequestParam("forma-farmaceutica-id") Long formaFarmaceuticaId){
        service.asignarFormaFarmaceutica(id,formaFarmaceuticaId);
        return new ResponseEntity<>("Entidad modificada correctamente", HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}/administracion")
    public ResponseEntity<String> asignarAdministracion(@RequestParam Long id,
                                                        @RequestParam("administracion-id") Long administracionId){
        service.asignarAdministracion(id,administracionId);
        return new ResponseEntity<>("Entidad modificada correctamente", HttpStatusCode.valueOf(204));
    }

    @PatchMapping("/{id}/marca")
    public ResponseEntity<String> asignarMarca(@RequestParam Long id,
                                               @RequestParam("marca-id") Long marcaId){
        service.asignarMarca(id,marcaId);
        return new ResponseEntity<>("Entidad modificada correctamente",HttpStatusCode.valueOf(204));
    }
}
