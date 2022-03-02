package com.ceiba.configuracion;

import com.ceiba.hospedaje.puerto.repositorio.RepositorioHospedaje;
import com.ceiba.hospedaje.servicio.ServicioActualizarHospedaje;
import com.ceiba.hospedaje.servicio.ServicioCrearHospedaje;
import com.ceiba.hospedaje.servicio.ServicioEliminarHospedaje;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioHospedaje {

    @Bean
    public ServicioCrearHospedaje servicioCrearHospedaje(RepositorioHospedaje repositorioHospedaje) {
        return new ServicioCrearHospedaje(repositorioHospedaje);
    }

    @Bean
    public ServicioEliminarHospedaje servicioEliminarHospedaje(RepositorioHospedaje repositorioHospedaje) {
        return new ServicioEliminarHospedaje(repositorioHospedaje);
    }

    @Bean
    public ServicioActualizarHospedaje servicioActualizarHospedaje(RepositorioHospedaje repositorioHospedaje) {
        return new ServicioActualizarHospedaje(repositorioHospedaje);
    }
	

}
