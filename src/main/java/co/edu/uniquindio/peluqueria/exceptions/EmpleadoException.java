package co.edu.uniquindio.peluqueria.exceptions;

public class EmpleadoException extends Exception{

    //Metodo que permite enviar mensaje de error mediante una excepcion
    public EmpleadoException(String message) {
        super(message);
    }

}
