package co.edu.uniquindio.peluqueria.service.interfaces;

import co.edu.uniquindio.peluqueria.dto.Empleado.ActualizarEmpleadoDTO;
import co.edu.uniquindio.peluqueria.dto.Empleado.CrearEmpleadoDTO;
import co.edu.uniquindio.peluqueria.dto.Empleado.ObtenerEmpleadoDTO;
import co.edu.uniquindio.peluqueria.exceptions.EmpleadoException;

import java.util.List;

public interface EmpleadoServicio {

    void crearEmpleado(CrearEmpleadoDTO empleadoDTO) throws EmpleadoException;

    void actualizarEmpleado(String id, ActualizarEmpleadoDTO empleadoDTO) throws EmpleadoException;

    void eliminarEmpleado(String id) throws EmpleadoException;

    List<ObtenerEmpleadoDTO> obtenerTodosLosEmpleados() throws EmpleadoException;
    ObtenerEmpleadoDTO obtenerEmpleadoPorId(String id) throws EmpleadoException;

}
