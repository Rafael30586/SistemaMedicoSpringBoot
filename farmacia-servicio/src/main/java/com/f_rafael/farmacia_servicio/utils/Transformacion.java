package com.f_rafael.farmacia_servicio.utils;

import com.f_rafael.farmacia_servicio.dto.*;
import com.f_rafael.farmacia_servicio.model.AccionTerapeutica;
import com.f_rafael.farmacia_servicio.model.AdministracionFarmaco;
import com.f_rafael.farmacia_servicio.model.Medicamento;
import com.f_rafael.farmacia_servicio.model.PrincipioActivo;

import java.util.*;

public class Transformacion {

    public static String removerGuionesBajos(String texto){
        return texto.replace('_',' ');
    }

}
