package com.ceiba.reserva.servicio;

import com.ceiba.Activo;
import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.hospedaje.modelo.dto.DtoHospedaje;
import com.ceiba.hospedaje.modelo.entidad.EstadoHospedaje;
import com.ceiba.hospedaje.modelo.entidad.Hospedaje;
import com.ceiba.hospedaje.puerto.dao.DaoHospedaje;
import com.ceiba.hospedaje.puerto.repositorio.RepositorioHospedaje;
import com.ceiba.hospedaje.servicio.ServicioCrearHospedaje;
import com.ceiba.hospedaje.servicio.testdatabuilder.HospedajeTestDataBuilder;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServicioCrearReservaTest {

//    @Test
//    @DisplayName("Debería lanzar una excepción cuando se valide la existencia de la reserva")
//    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelaReserva() {
//        // arrange
//        Reserva reserva = new ReservaTestDataBuilder().build();
//
//        DaoHospedaje daoHospedaje = Mockito.mock(DaoHospedaje.class);
//        Mockito.when(daoHospedaje.consultarPorId(Mockito.anyLong())).thenReturn(new DtoHospedaje());
//
//        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
//        Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(true);
//
//        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, daoHospedaje);
//
//        // act - assert
//        BasePrueba.assertThrows(() -> servicioCrearReserva.ejecutar(reserva), ExcepcionDuplicidad.class,"La reserva ya existe en el sistema");
//    }

    void deberiaCrearElHospedajeDeManeraCorrecta() {
        // arrange
        Hospedaje hospedaje = new HospedajeTestDataBuilder().build();
        RepositorioHospedaje repositorioHospedaje = Mockito.mock(RepositorioHospedaje.class);
        Mockito.when(repositorioHospedaje.existe(Mockito.anyString())).thenReturn(true);
        Mockito.when(repositorioHospedaje.crear(hospedaje)).thenReturn(10L);
        ServicioCrearHospedaje servicioCrearHospedaje = new ServicioCrearHospedaje(repositorioHospedaje);
        // act
        Long idHospedaje = servicioCrearHospedaje.ejecutar(hospedaje);
        //- assert
        assertEquals(10L,idHospedaje);
        Mockito.verify(repositorioHospedaje, Mockito.times(1)).crear(hospedaje);
    }

    @Test
    @DisplayName("Debería Crear la reserva de manera correcta")
    void deberiaCrearLaReservaDeManeraCorrecta() {
        // arrange
        Reserva reserva = new ReservaTestDataBuilder().build();

        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioReserva.crear(reserva)).thenReturn(1L);

        DaoHospedaje daoHospedaje = Mockito.mock(DaoHospedaje.class);
        Mockito.when(daoHospedaje.consultarPorId(Mockito.anyLong())).thenReturn(new DtoHospedaje(1L, "Hospedaje 1", 4, EstadoHospedaje.DISP.name(), LocalDateTime.now(), 40000.0, Activo.SI.name(), 5000.0));

        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, daoHospedaje);
        // act
        Long idReserva = servicioCrearReserva.ejecutar(reserva);

        //- assert
        assertEquals(1L,idReserva);

        Mockito.verify(repositorioReserva, Mockito.times(1)).crear(reserva);
    }




    @Test
    @DisplayName("Debería fallar si se sobrepasa el cupo del hospedaje")
    void deberiaFallarSiSeSobrepasaElCupoDelHospedaje() {
        // arrange
        Reserva reserva = new ReservaTestDataBuilder().
                conCantidadPersonas(5).
        build();

        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioReserva.crear(reserva)).thenReturn(1L);

        DaoHospedaje daoHospedaje = Mockito.mock(DaoHospedaje.class);
        Mockito.when(daoHospedaje.consultarPorId(Mockito.anyLong())).thenReturn(new DtoHospedaje(1L, "Hospedaje 1", 4, EstadoHospedaje.DISP.name(), LocalDateTime.now(), 40000.0, Activo.SI.name(), 5000.0));

        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, daoHospedaje);

        // act - assert
        BasePrueba.assertThrows(() ->
                servicioCrearReserva.ejecutar(reserva), ExcepcionValorInvalido.class,"La cantidad de personas sobrepasa la capacidad del hospedaje");
    }
}
