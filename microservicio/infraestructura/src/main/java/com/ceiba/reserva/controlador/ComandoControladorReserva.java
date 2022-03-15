package com.ceiba.reserva.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.reserva.comando.ComandoReserva;
import com.ceiba.reserva.comando.manejador.ManejadorActualizarReserva;
import com.ceiba.reserva.comando.manejador.ManejadorCrearReserva;
import com.ceiba.reserva.comando.manejador.ManejadorEliminarReserva;
import com.ceiba.reserva.comando.manejador.ManejadorPagarReserva;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservas")
@Api(tags = { "Controlador comando reservas"})
public class ComandoControladorReserva {

    private final ManejadorCrearReserva manejadorCrearReserva;
	private final ManejadorEliminarReserva manejadorEliminarReserva;
	private final ManejadorActualizarReserva manejadorActualizarReserva;
	private final ManejadorPagarReserva manejadorPagarReserva;

    @Autowired
    public ComandoControladorReserva(ManejadorCrearReserva manejadorCrearReserva,
									   ManejadorEliminarReserva manejadorEliminarReserva,
									   ManejadorActualizarReserva manejadorActualizarReserva,
									 ManejadorPagarReserva manejadorPagarReserva
    ) {
        this.manejadorCrearReserva = manejadorCrearReserva;
		this.manejadorEliminarReserva = manejadorEliminarReserva;
		this.manejadorActualizarReserva = manejadorActualizarReserva;
		this.manejadorPagarReserva = manejadorPagarReserva;
    }

    @PostMapping
    @ApiOperation("Crear Reserva")
	@CrossOrigin(origins = "*", methods= {RequestMethod.POST})
	public ComandoRespuesta<Long> crear(@RequestBody ComandoReserva comandoReserva) {
        return manejadorCrearReserva.ejecutar(comandoReserva);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar Reserva")
	@CrossOrigin(origins = "*", methods= {RequestMethod.DELETE})
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarReserva.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Reserva")
	@CrossOrigin(origins = "*", methods= {RequestMethod.PUT})
	public void actualizar(@RequestBody ComandoReserva comandoReserva,@PathVariable Long id) {
		comandoReserva.setId(id);
		manejadorActualizarReserva.ejecutar(comandoReserva);
	}


	@PutMapping(value="pagar/{id}")
	@ApiOperation("Pagar Reserva")
	@CrossOrigin(origins = "*", methods= {RequestMethod.PUT})
	public void pagar(@RequestBody ComandoReserva comandoReserva,@PathVariable Long id) {
		comandoReserva.setId(id);
		manejadorPagarReserva.ejecutar(comandoReserva);
	}
}
