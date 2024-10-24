package co.edu.uniquindio.peluqueria.controllers;

import co.edu.uniquindio.peluqueria.dto.Empleado.ActualizarEmpleadoDTO;
import co.edu.uniquindio.peluqueria.dto.Empleado.CrearEmpleadoDTO;
import co.edu.uniquindio.peluqueria.dto.Empleado.ObtenerEmpleadoDTO;
import co.edu.uniquindio.peluqueria.dto.autenticacion.MensajeDTO;
import co.edu.uniquindio.peluqueria.exceptions.EmpleadoException;
import co.edu.uniquindio.peluqueria.service.interfaces.EmpleadoServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleado")
//@SecurityRequirement(name = "bearerAuth")
@RequiredArgsConstructor
public class EmpleadoControllers {

    @Autowired
    private EmpleadoServicio empleadoServicio;

    // Crear empleado
    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO<String>> crearEmpleado(@Valid @RequestBody CrearEmpleadoDTO empleadoDTO) {
        try {
            empleadoServicio.crearEmpleado(empleadoDTO);
            return ResponseEntity.ok(new MensajeDTO<>(false, "Empleado creado exitosamente"));
        } catch (EmpleadoException e) {
            return ResponseEntity.badRequest().body(new MensajeDTO<>(false, e.getMessage()));
        }
    }

    // Actualizar empleado
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<MensajeDTO<String>> actualizarEmpleado(
            @PathVariable String id,
            @Valid @RequestBody ActualizarEmpleadoDTO empleadoDTO) {
        try {
            empleadoServicio.actualizarEmpleado(id, empleadoDTO);
            return ResponseEntity.ok(new MensajeDTO<>(false, "Empleado actualizado exitosamente"));
        } catch (EmpleadoException e) {
            return ResponseEntity.badRequest().body(new MensajeDTO<>(false, e.getMessage()));
        }
    }


    // Eliminar empleado
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<MensajeDTO<String>> eliminarEmpleado(@PathVariable String id) throws EmpleadoException {
        try {
            empleadoServicio.eliminarEmpleado(id);
            return ResponseEntity.ok(new MensajeDTO<>(false, "Empleado eliminado exitosamente"));
        } catch (EmpleadoException e) {
            return ResponseEntity.badRequest().body(new MensajeDTO<>(false, e.getMessage()));
        }
    }

    // Obtener todos los empleados
    @GetMapping("/listar")
    public ResponseEntity<MensajeDTO<List<ObtenerEmpleadoDTO>>> obtenerTodosLosEmpleados() throws EmpleadoException {
        List<ObtenerEmpleadoDTO> empleados = empleadoServicio.obtenerTodosLosEmpleados();
        return ResponseEntity.ok(new MensajeDTO<>(false, empleados));
    }

    // Obtener un empleado por ID
    @GetMapping("/obtener/{id}")
    public ResponseEntity<MensajeDTO<ObtenerEmpleadoDTO>> obtenerEmpleadoPorId(@PathVariable String id) throws EmpleadoException {
        ObtenerEmpleadoDTO empleado = empleadoServicio.obtenerEmpleadoPorId(id);
        return ResponseEntity.ok(new MensajeDTO<>(false, empleado));
    }
}