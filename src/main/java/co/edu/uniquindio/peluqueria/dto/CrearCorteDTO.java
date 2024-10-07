package co.edu.uniquindio.peluqueria.dto;

import co.edu.uniquindio.peluqueria.model.enums.TipoCorte;

public record CrearCorteDTO(
        String titulo,
        String imagen,
        String descripcion,
        TipoCorte tipoCorte,
        int tiempo,
        double precio
) {

}
