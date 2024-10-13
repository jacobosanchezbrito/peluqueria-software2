package co.edu.uniquindio.peluqueria.controllers;

import co.edu.uniquindio.peluqueria.model.documents.Cita;
import co.edu.uniquindio.peluqueria.service.interfaces.CitaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CitaController {

    private CitaServicio citaServicio;

    @PostMapping
    public ResponseEntity<Cita> crearCita(@RequestBody Cita cita) {
        return new ResponseEntity<>(citaServicio.crearCita(cita), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cita> modificarCita(Integer id, @RequestBody Cita cita) {
        return new ResponseEntity<>(citaServicio.modificarCita(id, cita), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCita(Integer id) {
        citaServicio.eliminarCita(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<Cita>> obtenerCitas() {
        return new ResponseEntity<>(citaServicio.obtenerCitas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cita> obtenerCitaPorId(Integer id) {
        return new ResponseEntity<>(citaServicio.obtenerCitaPorId(id), HttpStatus.OK);
    }
}
