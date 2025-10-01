package com.f_rafael.lugares_servicio.repository;

import com.f_rafael.lugares_servicio.model.NumeroTelefonico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface INumeroTelefonicoRepository extends JpaRepository<NumeroTelefonico, Long> {

    public Optional<NumeroTelefonico> findByNumero(String numero);
    @Query("SELECT nt FROM NumeroTelefonico nt WHERE nt.tipo = :tipo")
    public List<NumeroTelefonico> buscarPorTipo(@Param("tipo") String tipo);
}
