package com.ceiba.hospedajes.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.hospedaje.comando.ComandoHospedaje;
import com.ceiba.hospedaje.comando.manejador.ManejadorActualizarHospedaje;
import com.ceiba.hospedaje.comando.manejador.ManejadorCrearHospedaje;
import com.ceiba.hospedaje.comando.manejador.ManejadorEliminarHospedaje;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hospedajes")
@Api(tags = { "Controlador comando hospedajes"})
public class ComandoControladorHospedaje {

    private final ManejadorCrearHospedaje manejadorCrearHospedaje;
	private final ManejadorEliminarHospedaje manejadorEliminarHospedaje;
	private final ManejadorActualizarHospedaje manejadorActualizarHospedaje;

    @Autowired
    public ComandoControladorHospedaje(ManejadorCrearHospedaje manejadorCrearHospedaje,
									   ManejadorEliminarHospedaje manejadorEliminarHospedaje,
									   ManejadorActualizarHospedaje manejadorActualizarHospedaje
    ) {
        this.manejadorCrearHospedaje = manejadorCrearHospedaje;
		this.manejadorEliminarHospedaje = manejadorEliminarHospedaje;
		this.manejadorActualizarHospedaje = manejadorActualizarHospedaje;
    }

    @PostMapping
    @ApiOperation("Crear Hospedaje")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoHospedaje comandoHospedaje) {
        return manejadorCrearHospedaje.ejecutar(comandoHospedaje);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar Hospedaje")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarHospedaje.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Hospedaje")
	public void actualizar(@RequestBody ComandoHospedaje comandoUsuario,@PathVariable Long id) {
		comandoUsuario.setId(id);
		manejadorActualizarHospedaje.ejecutar(comandoUsuario);
	}
}
