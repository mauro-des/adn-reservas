package com.ceiba.hospedaje.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.hospedaje.comando.ComandoHospedaje;
import com.ceiba.hospedaje.testdatabuilder.ComandoHospedajeTestDataBuilder;
import com.ceiba.hospedajes.controlador.ComandoControladorHospedaje;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorHospedaje.class)
@ContextConfiguration(classes= ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ComandoControladorHospedajeTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    @DisplayName("Deberia crear un hospedaje")
    void deberiaCrearUnHospedaje() throws Exception{
        // arrange
        ComandoHospedaje comandoHospedaje = new ComandoHospedajeTestDataBuilder().build();
        // act - assert
        mocMvc.perform(post("/hospedajes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoHospedaje)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 3}"));
    }

    @Test
    @DisplayName("Deberia actualizar un hospedaje")
    void deberiaActualizarUnHospedaje() throws Exception{
        // arrange
        Long id = 1L;
        ComandoHospedaje hospedaje = new ComandoHospedajeTestDataBuilder().build();
        // act - assert
        mocMvc.perform(put("/hospedajes/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(hospedaje)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Deberia eliminar un hospedaje")
    void deberiaEliminarUnHospedaje() throws Exception {
        // arrange
        Long id = 1L;

        // act - assert
        mocMvc.perform(delete("/hospedajes/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mocMvc.perform(get("/hospedajes")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

}
