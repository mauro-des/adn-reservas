package com.ceiba.hospedaje.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.hospedaje.modelo.entidad.Hospedaje;
import com.ceiba.hospedaje.servicio.testdatabuilder.HospedajeTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HospedajeTest {

    @Test
    @DisplayName("Debería crear correctamente un hospedaje")
    void deberiaCrearCorrectamenteElUshospedaje() {
        // arrange
        LocalDateTime fechaCreacion = LocalDateTime.now();
        //act
        Hospedaje hospedaje = new HospedajeTestDataBuilder().
                conFechaCreacion(fechaCreacion).conId(1L).
                conCapacidadPersonas(1).
                build();
        //assert
        assertEquals(1, hospedaje.getId());
        assertEquals("HOSPEDAJEPRUEBA", hospedaje.getNombre());
        assertEquals("ACT", hospedaje.getEstado());
        assertEquals(fechaCreacion, hospedaje.getFechaCreacion());
        assertEquals(fechaCreacion, hospedaje.getFechaCreacion());
    }

    @Test
    void deberiaFallarSinNombreDeHabitacion() {

        //Arrange
        HospedajeTestDataBuilder hospedajeTestDataBuilder = new HospedajeTestDataBuilder().conNombre(null);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    hospedajeTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el nombre del hospedaje");
    }

    @Test
    void deberiaFallarSinEstado() {

        //Arrange
        HospedajeTestDataBuilder hospedajeTestDataBuilder = new HospedajeTestDataBuilder().conEstado(null);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    hospedajeTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el estado");
    }

    @Test
    void deberiaFallarSinCapacidadPersonas() {

        //Arrange
        HospedajeTestDataBuilder hospedajeTestDataBuilder = new HospedajeTestDataBuilder().conCapacidadPersonas(0);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    hospedajeTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "La capacidad debe ser mayor a cero");
    }

    @Test
    void deberiaFallarConCapacidadPersonasNegativa() {

        //Arrange
        HospedajeTestDataBuilder hospedajeTestDataBuilder = new HospedajeTestDataBuilder().conCapacidadPersonas(-1);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    hospedajeTestDataBuilder.build();
                },
                ExcepcionValorInvalido.class, "La capacidad debe ser mayor a cero");
    }

    @Test
    void deberiaFallarSinFechaCreacion() {

        //Arrange
        HospedajeTestDataBuilder hospedajeTestDataBuilder = new HospedajeTestDataBuilder().conFechaCreacion(null);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    hospedajeTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la fecha de creación");
    }


}
