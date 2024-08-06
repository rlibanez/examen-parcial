package es.cic.curso.ejerc04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.cic.curso.ejerc04.model.Pelicula;
import es.cic.curso.ejerc04.service.PeliculaService;

@RestController
@RequestMapping("/api/pelicula")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping("/{id}")
    public Pelicula leer(@PathVariable("id") long id) {
        Pelicula resultado = peliculaService.leer(id);
        return resultado;
    }

}
