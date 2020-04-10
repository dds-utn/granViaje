package domain;

import exceptions.*;

public abstract class EstadoAuto {
	public void encender(Auto auto) throws NoSePuedeEncenderException, SinCombustibleException {
		throw new NoSePuedeEncenderException("No se puede encender el auto");
	}
	
	public void apagar(Auto auto) throws NoSePuedeApagarException{
		throw new NoSePuedeApagarException();
	}
	
	public void acelerar(Auto auto, int kmH) throws NoSePuedeAcelerarException {
		throw new NoSePuedeAcelerarException("No se puede acelerar el auto");
	}
	
	public void detener(Auto auto) throws NoSePuedeDetenerException {
		throw new NoSePuedeDetenerException();
	}
}
