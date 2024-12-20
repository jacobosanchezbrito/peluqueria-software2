package co.edu.uniquindio.peluqueria.dto.Servicio;

import co.edu.uniquindio.peluqueria.model.documents.Corte;

import java.util.List;

public record EditarServicioDTO(
        Corte corte,
        List<String> productos,
        String nombreServicio,
        int tiempoEstimado) {
}