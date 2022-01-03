package co.com.sofka.biblioteca.Models;

import co.com.sofka.biblioteca.Utils.Genero;
import co.com.sofka.biblioteca.Utils.Tipo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("Recurso")
public class Recurso {

    @Id
    private String id;
    private String nombre;
    private boolean disponibilidad = true;
    private Date fecha;
    private Genero areaTematica;
    private Tipo tipo;

    public Recurso() {
    }

    public Recurso(String id, String nombre, Genero areaTematica, Tipo tipo) {
        this.id = id;
        this.nombre = nombre;
        this.areaTematica = areaTematica;
        this.tipo = tipo;
    }

    public Recurso(String nombre, Genero areaTematica, Tipo tipo) {
        this.nombre = nombre;
        this.areaTematica = areaTematica;
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean disponibilidad() {
        return disponibilidad;
    }

    public void setDisponible(boolean disponible) {
        disponibilidad = disponible;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Genero getAreaTematica() {
        return areaTematica;
    }

    public void setAreaTematica(Genero areaTematica) {
        this.areaTematica = areaTematica;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
