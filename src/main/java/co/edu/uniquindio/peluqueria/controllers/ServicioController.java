package co.edu.uniquindio.peluqueria.controllers;

import co.edu.uniquindio.peluqueria.dto.Servicio.CrearServicioDTO;
import co.edu.uniquindio.peluqueria.dto.Servicio.EditarServicioDTO;
import co.edu.uniquindio.peluqueria.dto.Servicio.ObtenerServicioDTO;
import co.edu.uniquindio.peluqueria.dto.autenticacion.MensajeDTO;
import co.edu.uniquindio.peluqueria.exceptions.ServicioException;
import co.edu.uniquindio.peluqueria.service.interfaces.ServiciosServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicio")
@RequiredArgsConstructor
public class ServicioController {

    @Autowired
    private ServiciosServicio serviciosServicio;

    @PostMapping("/crear")
    public ResponseEntity<MensajeDTO<String>> crearServicio(@Valid @RequestBody CrearServicioDTO servicioDTO){
        try {
            serviciosServicio.crearServicio(servicioDTO);
            return ResponseEntity.ok(new MensajeDTO<>(false, "Servicio creado correctamente"));
        }catch (ServicioException e){
            return ResponseEntity.badRequest().body(new MensajeDTO<>(false, e.getMessage()));
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<MensajeDTO<String>> editarServicio(
            @PathVariable String id,
            @Valid @RequestBody EditarServicioDTO servicioDTO) {
        try {
            serviciosServicio.editarServicio(id, servicioDTO);
            return ResponseEntity.ok(new MensajeDTO<>(false, "Servicio editado correctamente"));
        } catch (ServicioException e) {
            return ResponseEntity.badRequest().body(new MensajeDTO<>(false, e.getMessage()));
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<MensajeDTO<String>> eliminarServicio(@PathVariable String id){
        try {
            serviciosServicio.elimiarServicio(id);
            return ResponseEntity.ok(new MensajeDTO<>(false, "Servicio eliminado correctamente"));
        }catch (ServicioException e){
            return ResponseEntity.badRequest().body(new MensajeDTO<>(false, e.getMessage()));
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<MensajeDTO<List<ObtenerServicioDTO>>> obtenerTodosLosServicios() throws ServicioException{
        List<ObtenerServicioDTO> servicios = serviciosServicio.obtenerTodosLosServicios();
        return ResponseEntity.ok(new MensajeDTO<>(false, servicios));
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity<MensajeDTO<ObtenerServicioDTO>> obtenerServiciosPorId(@PathVariable String id) throws ServicioException{
        ObtenerServicioDTO servicios =  serviciosServicio.obtenerServicioPorId(id);
        return ResponseEntity.ok(new MensajeDTO<>(false, servicios));
    }
}