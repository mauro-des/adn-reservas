package com.ceiba.hospedaje.servicio;

import com.ceiba.hospedaje.puerto.repositorio.RepositorioHospedaje;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarHospedajeTest {

    @Test
    @DisplayName("Deberia eliminar el hospedaje llamando al repositorio")
    void deberiaEliminarElHospedajeLlamandoAlRepositorio() {
        RepositorioHospedaje repositorioHospedaje = Mockito.mock(RepositorioHospedaje.class);
        ServicioEliminarHospedaje servicioEliminarHospedaje = new ServicioEliminarHospedaje(repositorioHospedaje);

        servicioEliminarHospedaje.ejecutar(1l);

        Mockito.verify(repositorioHospedaje, Mockito.times(1)).eliminar(1l);

    }

}
