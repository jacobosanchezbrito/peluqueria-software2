package co.edu.uniquindio.peluqueria.dto.Corte;

import co.edu.uniquindio.peluqueria.model.enums.TipoCorte;
import jakarta.validation.constraints.*;

public record InformacionCorteDTO(
        @NotBlank String titulo,
        String imagen,
        @Size(max = 500) String descripcion,
        @NotNull TipoCorte tipoCorte,
        @Min(5) int tiempo,
        @DecimalMin("0.0") double precio
) {}


