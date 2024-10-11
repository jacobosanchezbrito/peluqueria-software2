package co.edu.uniquindio.peluqueria.dto.Servicio;

import java.util.List;

public record InformacionServicio(
        String idCorte,
        List<String> idProductos,
        String nombreServicio,
        int tiempoEstimado) {
    //

}