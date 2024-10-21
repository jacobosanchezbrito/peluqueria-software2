package co.edu.uniquindio.peluqueria.service.implement;

import co.edu.uniquindio.peluqueria.dto.Producto.CrearProductoDTO;
import co.edu.uniquindio.peluqueria.dto.Producto.EditarProductoDTO;
import co.edu.uniquindio.peluqueria.dto.Producto.InformacionProducto;
import co.edu.uniquindio.peluqueria.exceptions.ProductoException;
import co.edu.uniquindio.peluqueria.exceptions.ProductoNoEncontradoException;
import co.edu.uniquindio.peluqueria.model.documents.Producto;
import co.edu.uniquindio.peluqueria.repository.ProductoRepo;
import co.edu.uniquindio.peluqueria.service.interfaces.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoServicioImpl implements ProductoServicio {

    @Autowired
    private ProductoRepo productoRepo;

    @Override
    public String crearProducto(CrearProductoDTO productoDTO) throws ProductoException {
        Producto producto = new Producto(
                null,
                productoDTO.titulo(),
                productoDTO.imagen(),
                productoDTO.descripcion(),
                productoDTO.stockDisponible(),
                productoDTO.tipoProducto(),
                productoDTO.precio()
        );
        productoRepo.save(producto);
        return "Producto creado con éxito: " + producto.getIdProducto();
    }

    @Override
    public String editarProducto(EditarProductoDTO productoDTO) throws ProductoException {
        Optional<Producto> productoOpt = productoRepo.findById(productoDTO.titulo());
        if (productoOpt.isEmpty()) {
            throw new ProductoException("El producto no existe");
        }
        Producto producto = productoOpt.get();
        producto.setTitulo(productoDTO.titulo());
        producto.setImagen(productoDTO.imagen());
        producto.setDescripcion(productoDTO.descripcion());
        producto.setStockDisponible(productoDTO.stockDisponible());
        producto.setTipoProducto(productoDTO.tipoProducto());
        producto.setPrecio(productoDTO.precio());
        productoRepo.save(producto);
        return "Producto actualizado con éxito";
    }

    @Override
    public String eliminarProducto(String id) throws Exception {
        if (!productoRepo.existsById(id)) {
            throw new Exception("El producto no existe");
        }
        productoRepo.deleteById(id);
        return "Producto eliminado con éxito";
    }

    @Override
    public InformacionProducto obtenerInformacionProducto(String id) throws ProductoNoEncontradoException {
        Producto producto = productoRepo.findById(id)
                .orElseThrow(() -> new ProductoNoEncontradoException("El producto no existe"));
        return new InformacionProducto(
                producto.getTitulo(),
                producto.getImagen(),
                producto.getDescripcion(),
                producto.getStockDisponible(),
                producto.getTipoProducto(),
                producto.getPrecio()
        );
    }

    @Override
    public List<Producto> listarProductos() {
        return productoRepo.findAll();
    }
}
