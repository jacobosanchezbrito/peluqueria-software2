package co.edu.uniquindio.peluqueria.controllers;

import co.edu.uniquindio.peluqueria.dto.Cliente.CrearClienteDTO;
import co.edu.uniquindio.peluqueria.exceptions.ClienteException;
import co.edu.uniquindio.peluqueria.model.documents.Cliente;
import co.edu.uniquindio.peluqueria.service.interfaces.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteServicio clienteServicio;

    @PostMapping("/crear")
    public ResponseEntity<String> crearCliente(@RequestBody CrearClienteDTO clienteDTO) {
        try {
            clienteServicio.crearCliente(clienteDTO);
            return ResponseEntity.ok("Cliente creado exitosamente");
        } catch (ClienteException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Obtener todos los clientes
    @GetMapping
    public ResponseEntity<List<Cliente>> obtenerTodosLosClientes() {
        List<Cliente> clientes = clienteServicio.obtenerTodosLosClientes();
        return ResponseEntity.ok(clientes);
    }

    // Obtener cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerClientePorId(@PathVariable String id) {
        try {
            Cliente cliente = clienteServicio.obtenerClientePorId(id);
            return ResponseEntity.ok(cliente);
        } catch (ClienteException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Actualizar cliente
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> actualizarCliente(@PathVariable String id, @RequestBody CrearClienteDTO clienteDTO) {
        try {
            clienteServicio.actualizarCliente(id, clienteDTO);
            return ResponseEntity.ok("Cliente actualizado exitosamente");
        } catch (ClienteException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Eliminar cliente
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarCliente(@PathVariable String id) {
        try {
            clienteServicio.eliminarCliente(id);
            return ResponseEntity.ok("Cliente eliminado exitosamente");
        } catch (ClienteException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
