package com.ceiba.hospedaje.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
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
    void deberiaCrearCorrectamenteElUsusuario() {
        // arrange
        LocalDateTime fechaCreacion = LocalDateTime.now();
        //act
        Hospedaje hospedaje = new HospedajeTestDataBuilder().
                conFechaCreacion(fechaCreacion).conId(1L).
                conCantidadPersonas(1).
                build();
        //assert
        assertEquals(1, hospedaje.getId());
        assertEquals("HospedajePrueba", hospedaje.getNombre());
        assertEquals("ACT", hospedaje.getEstado());
        assertEquals(fechaCreacion, hospedaje.getFechaCreacion());
        assertEquals(fechaCreacion, hospedaje.getFechaCreacion());
    }
//
//    @Test
//    void deberiaFallarSinNombreDeUsuario() {
//
//        //Arrange
//        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conNombre(null).conId(1L);
//        //act-assert
//        BasePrueba.assertThrows(() -> {
//                    usuarioTestDataBuilder.build();
//                },
//                ExcepcionValorObligatorio.class, "Se debe ingresar el nombre de usuario");
//    }
//
//    @Test
//    void deberiaFallarSinClave() {
//
//        //Arrange
//        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conClave(null).conId(1L);
//        //act-assert
//        BasePrueba.assertThrows(() -> {
//                    usuarioTestDataBuilder.build();
//                },
//                ExcepcionValorObligatorio.class, "Se debe ingresar la clave");
//    }
//
//    @Test
//    void deberiaFallarSinTamanioClave() {
//
//        //Arrange
//        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conClave("123").conId(1L);
//        //act-assert
//        BasePrueba.assertThrows(() -> {
//                    usuarioTestDataBuilder.build();
//                },
//                ExcepcionLongitudValor.class, "La clave debe tener una longitud mayor o igual a 4");
//    }
//
//    @Test
//    void deberiaFallarSinFechaCreacion() {
//
//        //Arrange
//        UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conFechaCreacion(null).conId(1L);
//        //act-assert
//        BasePrueba.assertThrows(() -> {
//                    usuarioTestDataBuilder.build();
//                },
//                ExcepcionValorObligatorio.class, "Se debe ingresar la fecha de creación");
//    }


}
