package co.edu.uniquindio.peluqueria.dto;

import java.util.List;

public record CrearServicioDTO(
        String idCorte,
        List<String> idProductos,
        String nombreServicio,
        int tiempoEstimado) {
    //

}
