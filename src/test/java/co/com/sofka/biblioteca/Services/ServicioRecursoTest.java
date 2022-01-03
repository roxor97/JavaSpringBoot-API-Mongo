package co.com.sofka.biblioteca.Services;

import co.com.sofka.biblioteca.Mappers.RecursoMapper;
import co.com.sofka.biblioteca.Models.Recurso;
import co.com.sofka.biblioteca.Repositories.RepositorioRecurso;
import co.com.sofka.biblioteca.Utils.Genero;
import co.com.sofka.biblioteca.Utils.Tipo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class ServicioRecursoTest {

    @MockBean
    RepositorioRecurso repositorio;

    @Autowired
    private  ServicioRecurso servicio;

    @Test
    void comprobarDisponibilidad() {
        var recurso = new Recurso(
                "56563946",
                "El señor de los anillos",
                Genero.FANTASIA,
                Tipo.LIBRO
                );

        Mockito.when(repositorio.findById("56563946")).thenReturn(java.util.Optional.of(recurso));

        var resultado = servicio.comprobarDisponibilidad("56563946");

        Assertions.assertEquals(true, resultado.isDisponible());
        Assertions.assertEquals("El recurso esta disponible" , resultado.getMensaje());

        Mockito.verify(repositorio, Mockito.times(1)).findById("56563946");
    }

    @Test
    void prestarUnRecurso() {
        RecursoMapper mapper = new RecursoMapper();

        var recurso = new Recurso(
                "56563946",
                "El señor de los anillos",
                Genero.FANTASIA,
                Tipo.LIBRO
        );
        var recursoRetorno = new Recurso(
                "56563946",
                "El señor de los anillos",
                Genero.FANTASIA,
                Tipo.LIBRO
        );

        Mockito.when(repositorio.findById("56563946")).thenReturn(Optional.of(recursoRetorno));
        Mockito.when(repositorio.save(any())).thenReturn(recursoRetorno);

        var resultado = servicio.prestarUnRecurso("56563946");

        Assertions.assertEquals(true, resultado.isDisponible());
        Assertions.assertEquals("El recurso esta disponible" , resultado.getMensaje());

        Mockito.verify(repositorio, Mockito.times(1)).findById("56563946");
    }

    @Test
    void devolverUnRecurso() {
        RecursoMapper mapper = new RecursoMapper();

        var recurso = new Recurso(
                "56563946",
                "El señor de los anillos",
                Genero.FANTASIA,
                Tipo.LIBRO
        );
        var recursoRetorno = new Recurso(
                "56563946",
                "El señor de los anillos",
                Genero.FANTASIA,
                Tipo.LIBRO
        );

        Mockito.when(repositorio.findById("56563946")).thenReturn(Optional.of(recursoRetorno));
        Mockito.when(repositorio.save(any())).thenReturn(recursoRetorno);

        var resultado = servicio.devolverUnRecurso("56563946");

        Assertions.assertEquals(false, resultado.isDisponible());
        Assertions.assertEquals("El recurso no esta prestado" , resultado.getMensaje());

        Mockito.verify(repositorio, Mockito.times(1)).findById("56563946");
    }

    @Test
    void encontrarPorArea() {
        var recursos = List.of( new Recurso(
                "56563946",
                "El señor de los anillos",
                Genero.FANTASIA,
                Tipo.LIBRO
        ));

        Mockito.when(repositorio.findByAreaTematica("FANTASIA")).thenReturn((List<Recurso>) recursos);

        var resultado = servicio.encontrarPorAreaTematica("FANTASIA");

        Assertions.assertEquals(1, resultado.size());
        Assertions.assertEquals("El señor de los anillos" , resultado.get(0).getNombre());
        Assertions.assertEquals(Tipo.LIBRO , resultado.get(0).getTipo());
        Assertions.assertEquals(Genero.FANTASIA, resultado.get(0).getAreaTematica());

        Mockito.verify(repositorio, Mockito.times(1)).findByAreaTematica("FANTASIA");
    }

    @Test
    void encontrarPorTipo() {
        var recursos = List.of( new Recurso(
                "56563946",
                "El señor de los anillos",
                Genero.FANTASIA,
                Tipo.LIBRO
        ));

        Mockito.when(repositorio.findByTipo("LIBRO")).thenReturn((List<Recurso>) recursos);

        var resultado = servicio.encontrarPorTipo("LIBRO");

        Assertions.assertEquals(1, resultado.size());
        Assertions.assertEquals("El señor de los anillos" , resultado.get(0).getNombre());
        Assertions.assertEquals(Tipo.LIBRO , resultado.get(0).getTipo());
        Assertions.assertEquals(Genero.FANTASIA, resultado.get(0).getAreaTematica());

        Mockito.verify(repositorio, Mockito.times(1)).findByTipo("LIBRO");
    }

    @Test
    void encontrarPorAreaTematicaYTipo() {
        var recursos = List.of( new Recurso(
                "56563946",
                "El señor de los anillos",
                Genero.FANTASIA,
                Tipo.LIBRO
        ));

        Mockito.when(repositorio.findByAreaTematicaAndTipo("FANTASIA", "LIBRO"))
                .thenReturn((List<Recurso>) recursos);

        var resultado = servicio.encontrarPorAreaTematicaYTipo("FANTASIA", "LIBRO");

        Assertions.assertEquals(1, resultado.size());
        Assertions.assertEquals("El señor de los anillos" , resultado.get(0).getNombre());
        Assertions.assertEquals(Tipo.LIBRO , resultado.get(0).getTipo());
        Assertions.assertEquals(Genero.FANTASIA, resultado.get(0).getAreaTematica());

        Mockito.verify(repositorio, Mockito.times(1)).findByAreaTematicaAndTipo("FANTASIA", "LIBRO");
    }
}