package co.edu.uniquindio.peluqueria.service.implement;

import co.edu.uniquindio.peluqueria.dto.Producto.InformacionProducto;
import co.edu.uniquindio.peluqueria.dto.Servicio.CrearServicioDTO;
import co.edu.uniquindio.peluqueria.dto.Servicio.EditarServicioDTO;
import co.edu.uniquindio.peluqueria.dto.Servicio.ObtenerServicioDTO;
import co.edu.uniquindio.peluqueria.exceptions.ServicioException;
import co.edu.uniquindio.peluqueria.model.documents.Corte;
import co.edu.uniquindio.peluqueria.model.documents.Producto;
import co.edu.uniquindio.peluqueria.model.documents.Servicios;
import co.edu.uniquindio.peluqueria.repository.CorteRepo;
import co.edu.uniquindio.peluqueria.repository.ProductoRepo;
import co.edu.uniquindio.peluqueria.repository.ServiciosRepo;
import co.edu.uniquindio.peluqueria.service.interfaces.ServiciosServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
@RequiredArgsConstructor
public class ServiciosServicioImp implements ServiciosServicio {

    @Autowired
    private ServiciosRepo serviciosRepo;

    @Autowired
    private ProductoRepo productoRepo;

    @Autowired
    private CorteRepo corteRepo;

    @Override
    public void crearServicio(CrearServicioDTO servicioDTO) throws ServicioException {
        Servicios servicio = new Servicios();

        //Busca la existencia del corte
        Corte corte = corteRepo.findById(servicioDTO.corte().getIdCorte())
                .orElseThrow(() -> new ServicioException("El corte con ID [" + servicioDTO.corte().getIdCorte() + "] no existe."));
        servicio.setCorte(corte);

        servicio.setNombreServicio(servicioDTO.nombreServicio());
        servicio.setTiempoEstimado(servicioDTO.tiempoEstimado());

        //Verifica si existen productos y no esta vacia esa lista
        if(servicioDTO.productos()!=null && !servicioDTO.productos().isEmpty()){
            List<Producto> productos = productoRepo.findAllById(servicioDTO.productos());

            // Valida si no se encontraron todos productos
            if (productos.size() != servicioDTO.productos().size()) {
                throw new ServicioException("Algunos productos no fueron encontrados por su ID");
            }
            servicio.setProductos(productos);
        } else{
            //Se inicializa lista vacia en caso de no tener productos.
            servicio.setProductos(new ArrayList<>());
        }
        serviciosRepo.save(servicio);
    }

    @Override
    public void editarServicio(String id, EditarServicioDTO editarServicioDTO) throws ServicioException {
        //Busqueda del servicio indicado
        Servicios servicioExistente = serviciosRepo.findById(id).orElseThrow(() -> new ServicioException("El servicio con el ID [" + id + "] no existe."));

        // Verificación de que el corte existe
        Corte corte = corteRepo.findById(editarServicioDTO.corte().getIdCorte())
                .orElseThrow(() -> new ServicioException("El corte con ID [" + editarServicioDTO.corte().getIdCorte() + "] no existe."));

        // Verifica que todos los productos existen
        if (editarServicioDTO.productos() != null && !editarServicioDTO.productos().isEmpty()) {
            List<Producto> productos = productoRepo.findAllById(editarServicioDTO.productos());

            if (productos.size() != editarServicioDTO.productos().size()) {
                throw new ServicioException("Algunos productos no fueron encontrados por su ID");
            }

            servicioExistente.setProductos(productos);
        } else {
            servicioExistente.setProductos(new ArrayList<>());
        }

        // Actualizacion del servicio
        servicioExistente.setNombreServicio(editarServicioDTO.nombreServicio());
        servicioExistente.setTiempoEstimado(editarServicioDTO.tiempoEstimado());
        servicioExistente.setCorte(corte);

        serviciosRepo.save(servicioExistente);
    }

    @Override
    public void elimiarServicio(String id) throws ServicioException {
        //Busqueda del servicio indicado
        if(!serviciosRepo.existsById(id)){
            throw new ServicioException("El servicio con el ID [" + id + "] no existe.");
        }

        serviciosRepo.deleteById(id);
    }

    @Override
    public List<ObtenerServicioDTO> obtenerTodosLosServicios() throws ServicioException{
        List<Servicios> listaServicios = serviciosRepo.findAll();

        if(listaServicios.isEmpty()){
            throw new ServicioException("No se encontraron servicios");
        }

        return listaServicios.stream().map(this::convertirServicioAObtenerServicioDTO).collect(Collectors.toList());
    }

    @Override
    public ObtenerServicioDTO obtenerServicioPorId(String id) throws ServicioException {
        Servicios servicios = serviciosRepo.findById(id).orElseThrow(() -> new ServicioException("El servicio con el ID [" + id + "] no existe."));
        return convertirServicioAObtenerServicioDTO(servicios);
    }

    private ObtenerServicioDTO convertirServicioAObtenerServicioDTO(Servicios servicios){
        return new ObtenerServicioDTO(
                servicios.getId(),
                servicios.getCorte(),
                servicios.getProductos().stream()
                        .map(this::convertirProductoAObtenerProductoDTO)
                        .collect(Collectors.toList()),
                servicios.getNombreServicio(),
                servicios.getTiempoEstimado()
        );
    }

    private InformacionProducto convertirProductoAObtenerProductoDTO(Producto producto){
        return new InformacionProducto(
                producto.getIdProducto(),
                producto.getTitulo(),
                producto.getImagen(),
                producto.getDescripcion(),
                producto.getStockDisponible(),
                producto.getTipoProducto(),
                producto.getPrecio()
        );
    }
}