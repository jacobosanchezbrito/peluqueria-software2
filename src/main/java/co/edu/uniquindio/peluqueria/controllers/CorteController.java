package co.edu.uniquindio.peluqueria.controllers;

import co.edu.uniquindio.peluqueria.dto.Corte.CrearCorteDTO;
import co.edu.uniquindio.peluqueria.dto.Corte.EditarCorteDTO;
import co.edu.uniquindio.peluqueria.dto.Corte.InformacionCorteDTO;
import co.edu.uniquindio.peluqueria.model.documents.Corte;
import co.edu.uniquindio.peluqueria.service.interfaces.CorteServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cortes")
public class CorteController {

    private final CorteServicio corteServicio;

    public CorteController(CorteServicio corteServicio) {
        this.corteServicio = corteServicio;
    }

    @PostMapping("/crear")
    public ResponseEntity<String> crearCorte(@RequestBody CrearCorteDTO corteDTO) {
        try {
            String id = corteServicio.crearCorte(corteDTO);
            return new ResponseEntity<>("Corte creado con ID: " + id, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/editar")
    public ResponseEntity<String> editarCorte(@RequestBody EditarCorteDTO corteDTO) {
        try {
            String mensaje = corteServicio.editarCuenta(corteDTO);
            return new ResponseEntity<>(mensaje, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarCorte(@PathVariable String id) {
        try {
            String mensaje = corteServicio.eliminarCuenta(id);
            return new ResponseEntity<>(mensaje, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<InformacionCorteDTO> obtenerInformacionCorte(@PathVariable String id) {
        try {
            InformacionCorteDTO informacionCorte = corteServicio.obtenerInformacionCorte(id);
            return new ResponseEntity<>(informacionCorte, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Corte>> listarCortes() {
        List<Corte> cortes = corteServicio.listarCortes();
        return new ResponseEntity<>(cortes, HttpStatus.OK);
    }
}
