package domain;

import exceptions.SinCombustibleException;

public class Apagado extends EstadoAuto {

    public Apagado(Auto auto){
        auto.getMotor().apagar();
    }

    @java.lang.Override
    public void encender(Auto auto) throws SinCombustibleException{
        verificarCombustible(auto);
        auto.cambiarEstadoA(new Encendido(auto));
    }

    private void verificarCombustible(Auto auto) throws SinCombustibleException{
        if ( auto.getTanqueDeCombustible().enReserva())
            throw new SinCombustibleException();
    }
}
