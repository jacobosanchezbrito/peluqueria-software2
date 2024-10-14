package co.edu.uniquindio.peluqueria.dto.Producto;

import co.edu.uniquindio.peluqueria.model.enums.TipoProducto;

public record InformacionProducto(
        String id,
        String titulo,
        String imagen,
        String descripcion,
        int stockDisponible,
        TipoProducto tipoProducto,
        double precio
) {
}
