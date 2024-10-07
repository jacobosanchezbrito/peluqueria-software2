package co.edu.uniquindio.peluqueria.dto;

import co.edu.uniquindio.peluqueria.model.enums.TipoProducto;

public record EditarProductoDTO(
        String titulo,
        String imagen,
        String descripcion,
        int stockDisponible,
        TipoProducto tipoProducto,
        double precio
) {
}
