package co.edu.uniquindio.peluqueria.service.interfaces;

import co.edu.uniquindio.peluqueria.dto.Servicio.CrearServicioDTO;
import co.edu.uniquindio.peluqueria.dto.Servicio.EditarServicioDTO;
import co.edu.uniquindio.peluqueria.dto.Servicio.InformacionServicio;
import co.edu.uniquindio.peluqueria.model.documents.Servicios;
import java.util.List;

public interface ServiciosServicio {
    String crearServicio(CrearServicioDTO servicioDTO) throws Exception;
    String editarServicio(EditarServicioDTO servicioDTO) throws Exception;
    String eliminarServicio(String id) throws Exception;
    InformacionServicio obtenerInformacionServicio(String id) throws Exception;
    List<Servicios> listarServicios();
}
