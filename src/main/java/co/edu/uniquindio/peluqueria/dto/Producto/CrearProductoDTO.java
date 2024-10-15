package co.edu.uniquindio.peluqueria.dto.Producto;

import co.edu.uniquindio.peluqueria.model.enums.TipoProducto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CrearProductoDTO(
        @NotBlank String titulo,
        @NotBlank String imagen,
        String descripcion,
        @Min(0) int stockDisponible,
        @NotNull TipoProducto tipoProducto,
        @Min(0) double precio
) {
}
