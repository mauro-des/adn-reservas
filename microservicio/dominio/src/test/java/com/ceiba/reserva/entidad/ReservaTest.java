package com.ceiba.reserva.entidad;

import com.ceiba.Activo;
import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.reserva.modelo.entidad.EstadoReserva;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReservaTest {

    @Test
    @DisplayName("Debería crear correctamente un reserva")
    void deberiaCrearCorrectamenteLaReserva() {
        // arrange
        LocalDateTime fechaCreacion = LocalDateTime.now();
        LocalDateTime fechaInicio = LocalDateTime.now().plusDays(1);
        LocalDateTime fechaFin = LocalDateTime.now().plusDays(4);
        //act
        Reserva reserva = new ReservaTestDataBuilder().
                conFechaCreacion(fechaCreacion).conId(1L).
                conCantidadPersonas(4).
                conNombreCliente("Cliente Prueba").
                conIdentificacionCliente("12345678").
                conFechaInicio(fechaInicio).
                conFechaFin(fechaFin).
                conEstado(EstadoReserva.PEN).
                conValorReserva(200000.0).
                conActivo(Activo.SI).
                conIdHospedaje(1L).
                build();
        //assert
        assertEquals(fechaCreacion, reserva.getFechaCreacion());
        assertEquals(1, reserva.getId());
        assertEquals(4, reserva.getCantidadPersonas());
        assertEquals("Cliente Prueba", reserva.getNombreCliente());
        assertEquals("12345678", reserva.getIdentificacionCliente());
        assertEquals(fechaInicio, reserva.getFechaInicio());
        assertEquals(fechaFin, reserva.getFechaFin());
        assertEquals("PEN", reserva.getEstado().name());
        assertEquals(200000.0, reserva.getValorReserva());
        assertEquals("SI", reserva.getActivo().name());
        assertEquals(1L, reserva.getIdHospedaje());
        assertEquals(3, reserva.getCantidadDias());
    }

    @Test
    @DisplayName("Debería fallar si no hay nombre del cliente")
    void deberiaFallarSinNombreDeCliente() {

        //Arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conNombreCliente(null);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    reservaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se deben ingresar los datos del cliente");
    }

    @Test
    @DisplayName("Debería fallar si no hay identificación del cliente")
    void deberiaFallarSinIdentificacionDeCliente() {

        //Arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conIdentificacionCliente(null);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    reservaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se deben ingresar los datos del cliente");
    }

    @Test
    @DisplayName("Debería crear reserva con estado PEN si el estado es Null")
    void deberiaCrearReservaConEstadoPENSiEstadoEsNull() {

        //Arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conEstado(null);

        //act-assert
        assertEquals("PEN", reservaTestDataBuilder.build().getEstado().name());

    }

    @Test
    @DisplayName("Debería crear reserva con el estado establecido")
    void deberiaCrearReservaConEstadoEstablecido() {

        //Arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conEstado(EstadoReserva.PAG);

        //act-assert
        assertEquals("PAG", reservaTestDataBuilder.build().getEstado().name());

    }

    @Test
    @DisplayName("Debería fallar sin cantidad de personas")
    void deberiaFallarSinCantidadDePersonas() {

        //Arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conCantidadPersonas(0);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    reservaTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "La cantidad de personas debe ser mayor a cero");
    }

    @Test
    @DisplayName("Debería fallar con cantidad de personas negativa")
    void deberiaFallarConCantidadPersonasNegativa() {

        //Arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conCantidadPersonas(-1);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    reservaTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "La cantidad de personas debe ser mayor a cero");
    }

    @Test
    @DisplayName("Debería fallar sin fecha de creación")
    void deberiaFallarSinFechaCreacion() {

        //Arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conFechaCreacion(null);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    reservaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la fecha de creación");
    }

    @Test
    @DisplayName("Debería fallar con fecha inicio mayor a fecha fin")
    void deberiaFallarConFechaInicioMayorAFechaFin() {

        //Arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().
                conFechaInicio(LocalDateTime.now().plusDays(2)).
                conFechaFin(LocalDateTime.now());
        //act-assert
        BasePrueba.assertThrows(() -> {
                    reservaTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "La fecha inicial debe ser menor a la fecha final");
    }

    @Test
    @DisplayName("Debería fallar con fecha inicio igual a fecha fin")
    void deberiaFallarConFechaInicioIgualAFechaFin() {

        //Arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().
                conFechaInicio(LocalDateTime.now()).
                conFechaFin(LocalDateTime.now());
        //act-assert
        BasePrueba.assertThrows(() -> {
                    reservaTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "La fecha inicial debe ser menor a la fecha final");
    }


    @Test
    @DisplayName("Debería fallar sin hospedaje")
    void deberiaFallarSinHospedaje() {

        //Arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conIdHospedaje(null);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    reservaTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar un hospedaje");
    }


}
