package co.edu.uniquindio.peluqueria.dto.autenticacion;

public record MensajeDTO<T>(
        boolean error,
        T respuesta
) {
}