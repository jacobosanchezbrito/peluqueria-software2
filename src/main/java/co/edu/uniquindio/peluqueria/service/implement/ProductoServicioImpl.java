package co.edu.uniquindio.peluqueria.service.implement;

import co.edu.uniquindio.peluqueria.dto.Producto.CrearProductoDTO;
import co.edu.uniquindio.peluqueria.dto.Producto.EditarProductoDTO;
import co.edu.uniquindio.peluqueria.dto.Producto.InformacionProductoDTO;
import co.edu.uniquindio.peluqueria.exceptions.ProductoException;
import co.edu.uniquindio.peluqueria.model.documents.Producto;
import co.edu.uniquindio.peluqueria.repository.ProductoRepo;
import co.edu.uniquindio.peluqueria.service.interfaces.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return "Producto creado con éxito: " + producto.getId();
    }


    @Override
    public String editarProducto(String id, EditarProductoDTO productoDTO) throws ProductoException {
        // Busca el producto usando el ID proporcionado
        Optional<Producto> productoOpt = productoRepo.findById(id);
        if (productoOpt.isEmpty()) {
            throw new ProductoException("El producto no existe");
        }

        Producto producto = productoOpt.get();
        // Actualiza los campos del producto con los valores del DTO
        producto.setTitulo(productoDTO.titulo());
        producto.setImagen(productoDTO.imagen());
        producto.setDescripcion(productoDTO.descripcion());
        producto.setStockDisponible(productoDTO.stockDisponible());
        producto.setTipoProducto(productoDTO.tipoProducto());
        producto.setPrecio(productoDTO.precio());

        // Guarda los cambios en el repositorio
        productoRepo.save(producto);

        return "Producto actualizado con éxito";
    }


    @Override
    public String eliminarProducto(String id) throws ProductoException {
        if (!productoRepo.existsById(id)) {
            throw new ProductoException("El producto no existe");
        }
        productoRepo.deleteById(id);
        return "Producto eliminado con éxito";
    }

    @Override
    public InformacionProductoDTO obtenerInformacionProducto(String id) throws ProductoException {
        Producto producto = productoRepo.findById(id)
                .orElseThrow(() -> new ProductoException("El producto no existe"));
        return new InformacionProductoDTO(
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

