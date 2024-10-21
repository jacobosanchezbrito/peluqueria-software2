package co.edu.uniquindio.peluqueria.dto.Servicio;

import co.edu.uniquindio.peluqueria.dto.Producto.InformacionProductoDTO;
import co.edu.uniquindio.peluqueria.model.documents.Corte;

import java.util.List;

public record ObtenerServicioDTO(
        String id,
        Corte corte,
        List<InformacionProductoDTO> productos,
        String nombreServicio,
        int tiempoEstimado) {
}