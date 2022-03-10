package com.ceiba.hospedaje.comando.fabrica;

import com.ceiba.hospedaje.comando.ComandoHospedaje;
import com.ceiba.hospedaje.modelo.entidad.Hospedaje;
import com.ceiba.usuario.modelo.entidad.Usuario;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FabricaHospedaje {

    public Hospedaje crear(ComandoHospedaje comandoHospedaje) {
        return new Hospedaje(
                comandoHospedaje.getId(),
                comandoHospedaje.getNombre(),
                comandoHospedaje.getCapacidadPersonas(),
                comandoHospedaje.getEstado(),
                LocalDateTime.now(),
                comandoHospedaje.getValorNoche(),
                comandoHospedaje.getActivo(),
                comandoHospedaje.getValorRecargoFinSemana()
        );
    }

}
