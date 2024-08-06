package es.cic.curso.ejerc04;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.cic.curso.ejerc04.model.Director;
import es.cic.curso.ejerc04.model.Pelicula;
import es.cic.curso.ejerc04.service.DirectorService;

@SpringBootTest
@AutoConfigureMockMvc
public class DirectorControllerIntregrationTest {

    @Autowired
    private DirectorService directorService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    Director director;

    @BeforeEach
    public void setUp() {
        director = new Director();
        director = directorService.agregar(director);

        Pelicula pelicula = new Pelicula();
        pelicula.setNombre("La Vida es Bella");
        pelicula.setDirector(director);
        pelicula.setAnno(1991);

        director.getPeliculas().add(pelicula);
        directorService.agregar(director);
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    void testLeer() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/director/{1}", director.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(director.getId()))
                .andReturn();

        String body = mvcResult.getResponse().getContentAsString();
        Director directoresultado = objectMapper.readValue(body, Director.class);

        assertTrue(directoresultado.getPeliculas().size() >= 1);
    }

    @Test
    void testLeer_no_encontrado() throws Exception {
        mockMvc.perform(get("/api/director/{1}", director.getId() * 5)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}
