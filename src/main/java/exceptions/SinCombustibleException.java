package exceptions;

public class SinCombustibleException extends Exception{
    public SinCombustibleException(){
        super("No hay combustible suficiente");
    }
}
