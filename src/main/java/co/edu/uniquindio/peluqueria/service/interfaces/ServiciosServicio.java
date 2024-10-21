package co.edu.uniquindio.peluqueria.service.interfaces;

import co.edu.uniquindio.peluqueria.dto.Servicio.CrearServicioDTO;
import co.edu.uniquindio.peluqueria.dto.Servicio.EditarServicioDTO;
import co.edu.uniquindio.peluqueria.dto.Servicio.ObtenerServicioDTO;
import co.edu.uniquindio.peluqueria.exceptions.ServicioException;
import java.util.List;

public interface ServiciosServicio {

    void crearServicio(CrearServicioDTO servicioDTO) throws ServicioException;

    void editarServicio(String id, EditarServicioDTO editarServicioDTO) throws ServicioException;

    void elimiarServicio(String id) throws ServicioException;

    List<ObtenerServicioDTO> obtenerTodosLosServicios() throws ServicioException;
    ObtenerServicioDTO obtenerServicioPorId(String id) throws ServicioException;
}