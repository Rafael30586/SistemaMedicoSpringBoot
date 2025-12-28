package com.f_rafael.pacientes_servicio.repository;

import com.f_rafael.pacientes_servicio.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Long> {

    public Optional<Paciente> findByDni(Long dni);

    @Query("SELECT p FROM Paciente p WHERE p.primerNombre = :nombre OR p.segundoNombre = :nombre")
    public List<Paciente> buscarPorNombre(@Param("nombre") String nombre);

    @Query("SELECT p FROM Paciente p WHERE p.apellidoPaterno = :apellido OR p.apellidoMaterno = :apellido")
    public List<Paciente> buscarPorApellido(@Param("apellido") String apellido);

    public Optional<Paciente> findByEmail(String email);

    @Query("SELECT p FROM Paciente p JOIN p.telefonos t WHERE t = :numero")
    public List<Paciente> buscarPorNumeroTelefonico(@Param("numero") String numero);

    @Query("SELECT p FROM Paciente p WHERE YEAR(p.fechaNacimiento) BETWEEN :desde AND :hasta ")
    public List<Paciente> buscarPorIntervaloNacimiento(@Param("desde") Integer desde, @Param("hasta") Integer hasta);
}
