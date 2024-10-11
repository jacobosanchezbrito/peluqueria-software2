package co.edu.uniquindio.peluqueria.servicios.interfaces;

import co.edu.uniquindio.peluqueria.dto.CrearServicioDTO;
import co.edu.uniquindio.peluqueria.dto.EditarServicioDTO;
import co.edu.uniquindio.peluqueria.dto.InformacionServicio;
import co.edu.uniquindio.peluqueria.model.documents.Servicios;
import java.util.List;

public interface ServiciosServicio {
    String crearServicio(CrearServicioDTO servicioDTO) throws Exception;
    String editarServicio(EditarServicioDTO servicioDTO) throws Exception;
    String eliminarServicio(String id) throws Exception;
    InformacionServicio obtenerInformacionServicio(String id) throws Exception;
    List<Servicios> listarServicios();
}
