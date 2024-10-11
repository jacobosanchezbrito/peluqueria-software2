package co.edu.uniquindio.peluqueria.exceptions;

public class ProductoException extends Exception{

    //Metodo que permite enviar mensaje de error mediante una excepcion
    public ProductoException(String message) {
        super(message);
    }

}
