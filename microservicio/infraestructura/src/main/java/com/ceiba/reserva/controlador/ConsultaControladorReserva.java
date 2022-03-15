package com.ceiba.reserva.controlador;

import com.ceiba.reserva.consulta.ManejadorListarReservas;
import com.ceiba.reserva.modelo.dto.DtoReserva;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
@Api(tags={"Controlador de consulta de reservas"})
public class ConsultaControladorReserva {

    private final ManejadorListarReservas manejadorListarReservas;

    public ConsultaControladorReserva(ManejadorListarReservas manejadorListarReservas) {
        this.manejadorListarReservas = manejadorListarReservas;
    }

    @GetMapping
    @ApiOperation("Listar Reservas")
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET})
    public List<DtoReserva> listar() {
        return manejadorListarReservas.ejecutar();
    }

}
