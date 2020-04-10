package exceptions;

public class NoSePuedeEncenderException extends Exception {
    public NoSePuedeEncenderException(String mensaje){
        super(mensaje);
    }

    public NoSePuedeEncenderException(){
        super("No es posible encender el auto");
    }
}
