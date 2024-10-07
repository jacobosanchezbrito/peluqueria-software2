package co.edu.uniquindio.peluqueria.dto;

import java.util.List;

public record EditarServicioDTO(
        String idCorte,
        List<String> idProductos,
        String nombreServicio,
        int tiempoEstimado) {
    //

}