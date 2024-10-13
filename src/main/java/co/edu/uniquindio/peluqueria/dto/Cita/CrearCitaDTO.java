package co.edu.uniquindio.peluqueria.dto.Cita;

import java.time.LocalDate;
import java.time.LocalTime;

public record CrearCitaDTO() {


    private static LocalDate fecha;

    private static LocalTime hora;

    private static Integer idCliente;

    private static Integer idServicio;

    private static Integer idEmpleado;


    public static LocalDate getFecha() {
        return fecha;
    }

    public static void setFecha(LocalDate fecha) {
        CrearCitaDTO.fecha = fecha;
    }

    public static LocalTime getHora() {
        return hora;
    }

    public static void setHora(LocalTime hora) {
        CrearCitaDTO.hora = hora;
    }

    public static Integer getIdCliente() {
        return idCliente;
    }

    public static void setIdCliente(Integer idCliente) {
        CrearCitaDTO.idCliente = idCliente;
    }

    public static Integer getIdServicio() {
        return idServicio;
    }

    public static void setIdServicio(Integer idServicio) {
        CrearCitaDTO.idServicio = idServicio;
    }

    public static Integer getIdEmpleado() {
        return idEmpleado;
    }

    public static void setIdEmpleado(Integer idEmpleado) {
        CrearCitaDTO.idEmpleado = idEmpleado;
    }
}
