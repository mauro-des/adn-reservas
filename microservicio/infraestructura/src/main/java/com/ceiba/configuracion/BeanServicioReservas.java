package com.ceiba.configuracion;

import com.ceiba.hospedaje.puerto.dao.DaoHospedaje;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.servicio.ServicioActualizarReserva;
import com.ceiba.reserva.servicio.ServicioCrearReserva;
import com.ceiba.reserva.servicio.ServicioEliminarReserva;
import com.ceiba.reserva.servicio.ServicioPagarReserva;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioReservas {

    @Bean
    public ServicioCrearReserva servicioCrearReserva(RepositorioReserva repositorioReserva, DaoHospedaje daoHospedaje) {
        return new ServicioCrearReserva(repositorioReserva, daoHospedaje);
    }

    @Bean
    public ServicioEliminarReserva servicioEliminarReserva(RepositorioReserva repositorioReserva) {
        return new ServicioEliminarReserva(repositorioReserva);
    }

    @Bean
    public ServicioActualizarReserva servicioActualizarReserva(RepositorioReserva repositorioReserva) {
        return new ServicioActualizarReserva(repositorioReserva);
    }

    @Bean
    public ServicioPagarReserva servicioPagarReserva(RepositorioReserva repositorioReserva) {
        return new ServicioPagarReserva(repositorioReserva);
    }

}
