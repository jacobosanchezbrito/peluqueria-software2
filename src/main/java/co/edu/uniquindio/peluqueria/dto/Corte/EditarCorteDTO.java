package co.edu.uniquindio.peluqueria.dto.Corte;

import co.edu.uniquindio.peluqueria.model.enums.TipoCorte;

public record EditarCorteDTO(
        String titulo,
        String imagen,
        String descripcion,
        TipoCorte tipoCorte,
        int tiempo,
        double precio
) {
}
