package com.f_rafael.hospital_servicio.service;

import com.f_rafael.hospital_servicio.dto.MedicamentoPacienteDto;
import com.f_rafael.hospital_servicio.dto.PacienteDto;
import com.f_rafael.hospital_servicio.dto.PrincipioActivoDto;
import com.f_rafael.hospital_servicio.exception.CampoNuloException;
import com.f_rafael.hospital_servicio.exception.DatoIncorrectoException;
import com.f_rafael.hospital_servicio.exception.EntidadNoEncontradaException;
import com.f_rafael.hospital_servicio.mapper.MedicamentoPacienteMapper;
import com.f_rafael.hospital_servicio.mapper.StringMapper;
import com.f_rafael.hospital_servicio.model.MedicamentoPaciente;
import com.f_rafael.hospital_servicio.repository.IFarmaciaClient;
import com.f_rafael.hospital_servicio.repository.IMedicamentoClient;
import com.f_rafael.hospital_servicio.repository.IMedicamentoPacienteRepository;
import com.f_rafael.hospital_servicio.repository.IPacienteClient;
import com.f_rafael.hospital_servicio.utils.Verificador;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class MedicamentoPacienteService implements IMedicamentoPacienteService{
    private MedicamentoPacienteMapper mapper;
    private IMedicamentoPacienteRepository repository;
    private Verificador verificador;
    private IPacienteClient pacienteClient;
    // private IMedicamentoClient medicamentoClient;
    private IFarmaciaClient farmaciaClient;
    private StringMapper stringMapper;
    @Override
    public MedicamentoPacienteDto buscarPorId(Long id) {
        return mapper.obtenerDto(repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Tratamiento con medicamentoso no encontrado")));
    }

    @Override
    public List<MedicamentoPacienteDto> buscarTodos() {
        return mapper.obtenerListaDto(repository.findAll());
    }

    @Override
    public MedicamentoPacienteDto guardar(MedicamentoPaciente medicamentoPaciente) {

        if(medicamentoPaciente.getMedicamentoId() == null || medicamentoPaciente.getPacienteId() == null || medicamentoPaciente.getInicio() == null || medicamentoPaciente.getDosisId() == null){
            throw new CampoNuloException("Algunos campos de tratamiento medicamentoso no pueden ser nulos");
        }

        pacienteClient.buscarPacientePorId(medicamentoPaciente.getPacienteId());
        farmaciaClient.buscarMedicamentoPorId(medicamentoPaciente.getMedicamentoId());
        farmaciaClient.buscarDosisPorId(medicamentoPaciente.getDosisId());

        verificador.esAnterior(medicamentoPaciente.getInicio(),medicamentoPaciente.getFin());

        return mapper.obtenerDto(repository.save(medicamentoPaciente));
    }

    @Override
    public MedicamentoPacienteDto actualizar(MedicamentoPaciente medicamentoPaciente) {
        if(medicamentoPaciente.getDosisId() == null){
            throw new CampoNuloException("El id durante una actualización no puede ser nulo");
        }

        return this.guardar(medicamentoPaciente);
    }

    @Override
    public void borrarPorId(Long id) {

        if(!repository.existsById(id)){
            throw new EntidadNoEncontradaException("Tratamiento medicamentoso no encontrado");
        }

        repository.deleteById(id);
    }

    @Override
    public List<MedicamentoPacienteDto> buscarPorPaciente(Long idODni, String opcion) {
        List<MedicamentoPacienteDto> listaParaRetornar = new LinkedList<>();
        List<MedicamentoPaciente> informacionTratamientos;
        PacienteDto paciente;

        verificador.esIdODni(opcion);

        if(opcion.equals("id")){
            listaParaRetornar = mapper.obtenerListaDto(repository.findByPacienteId(idODni));
            System.gc();
        }

        if(opcion.equals("dni")){
            informacionTratamientos = repository.findAll();
            paciente = pacienteClient.buscarPacientePorDni(idODni);

            for(MedicamentoPaciente mp : informacionTratamientos){
                if(mp.getPacienteId().equals(paciente.getId())){
                    listaParaRetornar.add(mapper.obtenerDto(mp));
                }
            }

        }

        return listaParaRetornar;
    }

    @Override
    public List<MedicamentoPacienteDto> buscarPorPrincipioActivo(String principioActivo) {
        List<MedicamentoPacienteDto> listaParaRetornar = new LinkedList<>();
        List<MedicamentoPaciente> informacionTratamientos = repository.findAll();
        Set<PrincipioActivoDto> pricipiosActivos;
        String principioActivosSinGuiones = stringMapper.quitarGuionesBajos(principioActivo);

        for(MedicamentoPaciente mp : informacionTratamientos){

            pricipiosActivos = farmaciaClient.buscarMedicamentoPorId(mp.getMedicamentoId()).getPrincipiosActivos();

            for(PrincipioActivoDto pad : pricipiosActivos){

                if(pad.getNombre().equals(principioActivosSinGuiones)){
                    listaParaRetornar.add(mapper.obtenerDto(mp));
                }
            }
        }

        return listaParaRetornar;
    }

    @Override
    public List<MedicamentoPacienteDto> buscarPorFechaDeInicio(LocalDate desde, LocalDate hasta) {
        return mapper.obtenerListaDto(repository.buscarPorFechaDeInicio(desde,hasta));
    }

    @Override
    public List<MedicamentoPacienteDto> buscarPorFechaDeFinal(LocalDate desde, LocalDate hasta) {
        return mapper.obtenerListaDto(repository.buscarPorFechaDeFinal(desde,hasta));
    }

    @Override
    public MedicamentoPacienteDto modificarPaciente(Long id, Long idODni, String opcion) {
        MedicamentoPaciente medicamentoParaActualizar = devolverPorId(id);
        verificador.esIdODni(opcion);

        if(opcion.equals("id")){
            medicamentoParaActualizar.setPacienteId(idODni);
        }

        if(opcion.equals("dni")){
            medicamentoParaActualizar.setPacienteId(pacienteClient.buscarPacientePorDni(idODni).getId());
        }

        return this.actualizar(medicamentoParaActualizar);
    }

    @Override
    public MedicamentoPacienteDto modificarMedicamento(Long id, Long medicamentoId) {
        MedicamentoPaciente medicamentoParaActualizar = devolverPorId(id);
        medicamentoParaActualizar.setMedicamentoId(medicamentoId);

        return this.actualizar(medicamentoParaActualizar);
    }

    @Override
    public MedicamentoPacienteDto modificarDosis(Long id, Long dosisId) {
        MedicamentoPaciente medicamentoParaActualizar = devolverPorId(id);
        medicamentoParaActualizar.setDosisId(dosisId);

        return this.actualizar(medicamentoParaActualizar);
    }

    @Override
    public MedicamentoPacienteDto modificarFechaDeInicio(Long id, LocalDate inicio) {
        MedicamentoPaciente medicamentoParaActualizar = devolverPorId(id);

        verificador.esAnterior(inicio,medicamentoParaActualizar.getFin());

        medicamentoParaActualizar.setInicio(inicio);

        return this.actualizar(medicamentoParaActualizar);
    }

    @Override
    public MedicamentoPacienteDto modificarFechaDeFinal(Long id, LocalDate fin) {
        MedicamentoPaciente medicamentoParaActualizar = devolverPorId(id);

        verificador.esAnterior(medicamentoParaActualizar.getInicio(),fin);

        medicamentoParaActualizar.setFin(fin);

        return this.actualizar(medicamentoParaActualizar);
    }

    public MedicamentoPaciente devolverPorId(Long id){
        return repository.findById(id).orElseThrow(()-> new EntidadNoEncontradaException("Tratamiento no encontrado"));
    }
}
