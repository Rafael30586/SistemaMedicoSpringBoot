package com.f_rafael.pacientes_servicio.repository;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "HOSPITAL_SERVICIO")
public interface IMedicoClient {

    public obtenerInformacionMedico()
}
