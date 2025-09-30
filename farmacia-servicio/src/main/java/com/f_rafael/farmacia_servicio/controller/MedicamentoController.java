package com.f_rafael.farmacia_servicio.controller;

import com.f_rafael.farmacia_servicio.model.Medicamento;
import com.f_rafael.farmacia_servicio.model.PrincipioActivo;
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
    public ResponseEntity<Medicamento> buscarPorId(@PathVariable Long id){

        if(service.buscarPorId(id).isEmpty()){
            return new ResponseEntity<>(new Medicamento(-99999L,
                    new PrincipioActivo(-99999L,"Entidad no encontrada",null),
                    null,
                    null,
                    null),
                    HttpStatusCode.valueOf(204));
        }

        return ResponseEntity.ok(service.buscarPorId(id).get());
    }

    @GetMapping
    public ResponseEntity<List<Medicamento>> buscarTodos(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping
    public ResponseEntity<List<Medicamento>> buscarPorPrincipioActivo(@RequestParam("nombre-principio-activo") String nombrePrincipioActivo){
        return ResponseEntity.ok(service.buscarPorPrincipioActivo(nombrePrincipioActivo));
    }

    @GetMapping
    public ResponseEntity<List<Medicamento>> buscarPorFormaFarmaceutica(@RequestParam("nombre-forma-farmaceutica") String nombreFormaFarmaceutica){
        return ResponseEntity.ok(service.buscarPorFormaFarmaceutica(nombreFormaFarmaceutica));
    }

    @GetMapping
    public ResponseEntity<List<Medicamento>> buscarPorAdminiastracion(@RequestParam("via") String via){
        return ResponseEntity.ok(service.buscarPorAdministracion(via));
    }

    @GetMapping
    public ResponseEntity<List<Medicamento>> buscarPorMarca(@RequestParam("nombre-marca") String nombreMarca){
        return ResponseEntity.ok(service.buscarPorMarca(nombreMarca));
    }

    @PostMapping
    public ResponseEntity<Medicamento> guardar(@RequestBody Medicamento medicamento){
        return ResponseEntity.ok(service.guardar(medicamento));
    }

    @PutMapping
    public ResponseEntity<Medicamento> actualizar(@RequestBody Medicamento medicamento){
        Long id = medicamento.getId();

        if(id == null){
            return new ResponseEntity<>(new Medicamento(-99999L,
                    new PrincipioActivo(-9999L,"El id no puede ser nulo",null),
                    null,null,null),HttpStatusCode.valueOf(204));
        }

        if(service.buscarPorId(id).isEmpty()){
            return new ResponseEntity<>(new Medicamento(-999999L,
                    new PrincipioActivo(-9999L,"Entidad no encontrada",null),
                    null,null,null),HttpStatusCode.valueOf(204));
        }

        return ResponseEntity.ok(service.actualizar(medicamento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPorId(@PathVariable Long id){
        if(service.buscarPorId(id).isEmpty()){
            return new ResponseEntity<>("Entidad no encontrada",HttpStatusCode.valueOf(204));
        }

        service.borrarPorId(id);
        return ResponseEntity.ok("Entidad borrada exitosamente");
    }
}
