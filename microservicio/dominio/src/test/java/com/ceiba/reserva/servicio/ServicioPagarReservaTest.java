package com.ceiba.reserva.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioPagarReservaTest {

    @Test
    @DisplayName("Debería validar la existencia previa de la reserva")
    void deberiaValidarLaExistenciaPreviaDeLaReserva() {
        // arrange
        Reserva reserva = new ReservaTestDataBuilder().conId(1L).build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(false);
        ServicioPagarReserva servicioPagarReserva = new ServicioPagarReserva(repositorioReserva);
        // act - assert
        BasePrueba.assertThrows(() -> servicioPagarReserva.ejecutar(reserva), ExcepcionDuplicidad.class,"La reserva no existe");
    }
    
}
