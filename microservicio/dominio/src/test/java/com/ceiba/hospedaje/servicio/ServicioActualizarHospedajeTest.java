package com.ceiba.hospedaje.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.hospedaje.modelo.entidad.Hospedaje;
import com.ceiba.hospedaje.puerto.repositorio.RepositorioHospedaje;
import com.ceiba.hospedaje.servicio.testdatabuilder.HospedajeTestDataBuilder;
import com.ceiba.hospedaje.modelo.entidad.Hospedaje;
import com.ceiba.hospedaje.puerto.repositorio.RepositorioHospedaje;
import com.ceiba.hospedaje.servicio.ServicioActualizarHospedaje;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioActualizarHospedajeTest {

    @Test
    @DisplayName("Debería validar la existencia previa de un hospedaje")
    void deberiaValidarLaExistenciaPreviaDelHospedaje() {
        // arrange
        Hospedaje hospedaje = new HospedajeTestDataBuilder().conId(1L).build();
        RepositorioHospedaje repositorioHospedate = Mockito.mock(RepositorioHospedaje.class);
        Mockito.when(repositorioHospedate.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarHospedaje servicioActualizarHospedaje = new ServicioActualizarHospedaje(repositorioHospedate);

          // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarHospedaje.ejecutar(hospedaje),
                ExcepcionDuplicidad.class,"El hospedaje no existe");
    }

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio() {
        // arrange
        Hospedaje hospedaje = new HospedajeTestDataBuilder().conId(1L).build();
        RepositorioHospedaje repositorioHospedate = Mockito.mock(RepositorioHospedaje.class);
        Mockito.when(repositorioHospedate.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarHospedaje servicioActualizarHospedaje = new ServicioActualizarHospedaje(repositorioHospedate);
        // act
        servicioActualizarHospedaje.ejecutar(hospedaje);
        //assert
        Mockito.verify(repositorioHospedate,Mockito.times(1)).actualizar(hospedaje);
    }
}
