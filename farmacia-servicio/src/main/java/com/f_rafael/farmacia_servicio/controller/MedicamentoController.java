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

        if(service.buscarPorId(id).isEmpty()){
            return new ResponseEntity<>(TransformacionMedicamento.obtenerDto(new Medicamento(-99999L,
                    new PrincipioActivo(-99999L,"Entidad no encontrada",null,null),
                    null,
                    null,
                    null)),
                    HttpStatusCode.valueOf(204));
        }

        return ResponseEntity.ok(TransformacionMedicamento.obtenerDto(service.buscarPorId(id).get()));
    }

    @GetMapping
    public ResponseEntity<List<MedicamentoDto>> buscarTodos(){
        return ResponseEntity.ok(TransformacionMedicamento.obtenerListaDto(service.buscarTodos()));
    }

    @GetMapping
    public ResponseEntity<List<MedicamentoDto>> buscarPorPrincipioActivo(@RequestParam("nombre-principio-activo") String nombrePrincipioActivo){
        return ResponseEntity.ok(TransformacionMedicamento.obtenerListaDto(service.buscarPorPrincipioActivo(nombrePrincipioActivo)));
    }

    @GetMapping
    public ResponseEntity<List<MedicamentoDto>> buscarPorFormaFarmaceutica(@RequestParam("nombre-forma-farmaceutica") String nombreFormaFarmaceutica){
        return ResponseEntity.ok(TransformacionMedicamento.obtenerListaDto(service.buscarPorFormaFarmaceutica(nombreFormaFarmaceutica)));
    }

    @GetMapping
    public ResponseEntity<List<MedicamentoDto>> buscarPorAdminiastracion(@RequestParam("via") String via){
        return ResponseEntity.ok(TransformacionMedicamento.obtenerListaDto(service.buscarPorAdministracion(via)));
    }

    @GetMapping
    public ResponseEntity<List<MedicamentoDto>> buscarPorMarca(@RequestParam("nombre-marca") String nombreMarca){
        return ResponseEntity.ok(TransformacionMedicamento.obtenerListaDto(service.buscarPorMarca(nombreMarca)));
    }

    @PostMapping
    public ResponseEntity<MedicamentoDto> guardar(@RequestBody Medicamento medicamento){
        return ResponseEntity.ok(TransformacionMedicamento.obtenerDto(service.guardar(medicamento)));
    }

    @PutMapping
    public ResponseEntity<MedicamentoDto> actualizar(@RequestBody Medicamento medicamento){
        Long id = medicamento.getId();

        if(id == null){
            return new ResponseEntity<>(TransformacionMedicamento.obtenerDto(new Medicamento(-99999L,
                    new PrincipioActivo(-9999L,"El id no puede ser nulo",null,null),
                    null,null,null)) ,HttpStatusCode.valueOf(204));
        }

        if(service.buscarPorId(id).isEmpty()){
            return new ResponseEntity<>(TransformacionMedicamento.obtenerDto(new Medicamento(-999999L,
                    new PrincipioActivo(-9999L,"Entidad no encontrada",null,null),
                    null,null,null)) ,HttpStatusCode.valueOf(204));
        }

        return ResponseEntity.ok(TransformacionMedicamento.obtenerDto(service.actualizar(medicamento)));
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
