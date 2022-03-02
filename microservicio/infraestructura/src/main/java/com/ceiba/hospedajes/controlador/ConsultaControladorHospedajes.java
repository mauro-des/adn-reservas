package com.ceiba.hospedajes.controlador;

import com.ceiba.hospedaje.consulta.ManejadorListarHospedajes;
import com.ceiba.hospedaje.modelo.dto.DtoHospedaje;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hospedajes")
@Api(tags={"Controlador de consulta de hospedajes"})
public class ConsultaControladorHospedajes {

    private final ManejadorListarHospedajes manejadorListarHospedajes;

    public ConsultaControladorHospedajes(ManejadorListarHospedajes manejadorListarHospedajes) {
        this.manejadorListarHospedajes = manejadorListarHospedajes;
    }

    @GetMapping
    @ApiOperation("Listar Hospedajes")
    public List<DtoHospedaje> listar() {
        return this.manejadorListarHospedajes.ejecutar();
    }

}
