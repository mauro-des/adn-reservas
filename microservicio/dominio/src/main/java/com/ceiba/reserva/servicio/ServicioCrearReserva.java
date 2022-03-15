package com.ceiba.reserva.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.hospedaje.modelo.dto.DtoHospedaje;
import com.ceiba.hospedaje.puerto.dao.DaoHospedaje;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;

import java.time.DayOfWeek;
import java.time.LocalDateTime;


public class ServicioCrearReserva {

    private static final String LA_RESERVA_YA_EXISTE_EN_EL_SISTEMA = "La reserva ya existe en el sistema";
    private static final String EL_HOSPEDAJE_SELECCIONADO_NO_EXISTE = "El hospedaje seleccionado no existe";
    private static final String LA_CANTIDAD_DE_PERSONAS_SOBREPASA_LA_CAPACIDAD_DEL_HOSPEDAJE = "La cantidad de personas sobrepasa la capacidad del hospedaje";

    private final RepositorioReserva repositorioReserva;
    private final DaoHospedaje daoHospedaje;

    public ServicioCrearReserva(RepositorioReserva repositorioReserva, DaoHospedaje daoHospedaje) {
        this.repositorioReserva = repositorioReserva;
        this.daoHospedaje = daoHospedaje;
    }

    public Long ejecutar(Reserva reserva) {
        validarExistenciaPrevia(reserva);
        DtoHospedaje hospedaje = obtenerHospedaje (reserva.getIdHospedaje());
        if(hospedaje.getCapacidadPersonas() < reserva.getCantidadPersonas()){
            throw new ExcepcionValorInvalido(LA_CANTIDAD_DE_PERSONAS_SOBREPASA_LA_CAPACIDAD_DEL_HOSPEDAJE);
        }
        reserva.setValorReservar(calcularCostoReserva(reserva, hospedaje));

        Long idGenerado = repositorioReserva.crear(reserva);
        return idGenerado;
    }

    private void validarExistenciaPrevia(Reserva reserva) {
        boolean existe = repositorioReserva.existePorHospedaje(reserva.getIdHospedaje());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_RESERVA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

    private DtoHospedaje obtenerHospedaje(Long idHospedaje) {
        DtoHospedaje hospedaje;
        try{
            hospedaje = daoHospedaje.consultarPorId(idHospedaje);
        }catch (Exception e){
            throw new ExcepcionValorInvalido(EL_HOSPEDAJE_SELECCIONADO_NO_EXISTE);
        }

        return hospedaje;
    }

    public static Double calcularCostoReserva(Reserva reserva, DtoHospedaje hospedaje){
        double costoHospedaje = 0;
        LocalDateTime fecha = reserva.getFechaInicio();

        for (int numDias = 0; numDias < reserva.getCantidadDias(); numDias++) {
            if(fecha.getDayOfWeek() == DayOfWeek.SATURDAY || fecha.getDayOfWeek() == DayOfWeek.SUNDAY){
                costoHospedaje += (hospedaje.getValorNoche()+hospedaje.getValorRecargoFinSemana());
            }else{
                costoHospedaje += hospedaje.getValorNoche();;
            }
            fecha = fecha.plusDays(1);
        }

        return costoHospedaje;
    }
}
