package com.ceiba.hospedaje.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.hospedaje.modelo.entidad.Hospedaje;
import com.ceiba.hospedaje.puerto.repositorio.RepositorioHospedaje;
import com.ceiba.hospedaje.servicio.ServicioCrearHospedaje;
import com.ceiba.hospedaje.servicio.testdatabuilder.HospedajeTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearHospedajeTest {

//    @Test
//    @DisplayName("Debería lanzar una excepción cuando la longitud de la clave sea menor a 4")
//    void deberiaLanzarUnaExepcionCuandoLaLongitudDeLaClaveSeaMenorACuatro() {
//        // arrange
//        HospedajeTestDataBuilder hospedajeTestDataBuilder = new HospedajeTestDataBuilder();
//        // act - assert
//        BasePrueba.assertThrows(hospedajeTestDataBuilder::build, ExcepcionLongitudValor.class, "La clave debe tener una longitud mayor o igual a 4");
//    }

    @Test
    @DisplayName("Debería lanzar una excepción cuando se valide la existencia del Hospedaje")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelHospedaje() {
        // arrange
        Hospedaje hospedaje = new HospedajeTestDataBuilder().build();
        RepositorioHospedaje repositorioHospedaje = Mockito.mock(RepositorioHospedaje.class);
        Mockito.when(repositorioHospedaje.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearHospedaje servicioCrearHospedaje = new ServicioCrearHospedaje(repositorioHospedaje);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearHospedaje.ejecutar(hospedaje), ExcepcionDuplicidad.class,"El hospedaje ya existe en el sistema");
    }

    @Test
    @DisplayName("Deberia Crear el hospedaje de manera correcta")
    void deberiaCrearElHospedajeDeManeraCorrecta() {
        // arrange
        Hospedaje hospedaje = new HospedajeTestDataBuilder().build();
        RepositorioHospedaje repositorioHospedaje = Mockito.mock(RepositorioHospedaje.class);
        Mockito.when(repositorioHospedaje.existe(Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioHospedaje.crear(hospedaje)).thenReturn(10L);
        ServicioCrearHospedaje servicioCrearHospedaje = new ServicioCrearHospedaje(repositorioHospedaje);
        // act
        Long idHospedaje = servicioCrearHospedaje.ejecutar(hospedaje);
        //- assert
        assertEquals(10L,idHospedaje);
        Mockito.verify(repositorioHospedaje, Mockito.times(1)).crear(hospedaje);
    }
}
