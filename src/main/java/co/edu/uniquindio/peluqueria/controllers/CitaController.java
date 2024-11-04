package co.edu.uniquindio.peluqueria.controllers;

import co.edu.uniquindio.peluqueria.dto.Cita.CrearCitaDTO;
import co.edu.uniquindio.peluqueria.dto.Cita.EditarCitaDTO;
import co.edu.uniquindio.peluqueria.dto.Cita.InformacionCitaDTO;
import co.edu.uniquindio.peluqueria.dto.autenticacion.MensajeDTO;
import co.edu.uniquindio.peluqueria.exceptions.CitaException;
import co.edu.uniquindio.peluqueria.service.interfaces.CitaServicio;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")  // Ruta base para las citas
public class CitaController {

    @Autowired
    private CitaServicio citaServicio;

    // Crear cita
    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO<String>> crearCita(@Valid @RequestBody CrearCitaDTO citaDTO) {
        try {
            citaServicio.crearCita(citaDTO);
            return ResponseEntity.ok(new MensajeDTO<>(false, "Cita creada exitosamente"));
        } catch (CitaException e) {
            return ResponseEntity.badRequest().body(new MensajeDTO<>(false, e.getMessage()));
        }
    }

    // Editar cita
    @PutMapping("/editar/{id}")
    public ResponseEntity<MensajeDTO<String>> editarCita(@PathVariable String id, @Valid @RequestBody EditarCitaDTO citaDTO) {
        try {
            citaServicio.editarCita(id, citaDTO);
            return ResponseEntity.ok(new MensajeDTO<>(false, "Cita editada exitosamente"));
        } catch (CitaException e) {
            return ResponseEntity.badRequest().body(new MensajeDTO<>(false, e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new MensajeDTO<>(true, "Error interno del servidor"));
        }
    }

    // Eliminar cita
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<MensajeDTO<String>> eliminarCita(@PathVariable String id) {
        try {
            citaServicio.eliminarCita(id);
            return ResponseEntity.ok(new MensajeDTO<>(false, "Cita eliminada exitosamente"));
        } catch (CitaException e) {
            return ResponseEntity.badRequest().body(new MensajeDTO<>(false, e.getMessage()));
        }
    }

    // Obtener todas las citas
    @GetMapping("/listar")
    public ResponseEntity<MensajeDTO<List<InformacionCitaDTO>>> obtenerTodasLasCitas() throws CitaException {
        List<InformacionCitaDTO> citas = citaServicio.obtenerTodasLasCitas();
        return ResponseEntity.ok(new MensajeDTO<>(false, citas));
    }

    // Obtener una cita por ID
    @GetMapping("/obtener/{id}")
    public ResponseEntity<MensajeDTO<InformacionCitaDTO>> obtenerCitaPorId(@PathVariable String id) throws CitaException {
        InformacionCitaDTO cita = citaServicio.obtenerCitaPorId(id);
        return ResponseEntity.ok(new MensajeDTO<>(false, cita));
    }
}
