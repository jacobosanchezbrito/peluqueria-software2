package co.edu.uniquindio.peluqueria.dto.Servicio;

import co.edu.uniquindio.peluqueria.model.documents.Corte;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CrearServicioDTO(
        @NotNull(message = "Se requiere el ID del corte a realizar del catalogo")
        Corte corte,

        List<String> productos,

        @NotBlank (message = "Se requiere un nombre para el servicio")
        String nombreServicio,

        int tiempoEstimado) {
}