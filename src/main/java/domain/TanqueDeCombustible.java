package domain;

public class TanqueDeCombustible {
	private Double capacidadMaxima;
	private Double litrosActuales;

	public static TanqueDeCombustible deCapacidad(Double capacidadMaxima){
		return new TanqueDeCombustible(capacidadMaxima);
	}

	private TanqueDeCombustible(Double capacidadMaxima){
		this.capacidadMaxima = capacidadMaxima;
		this.litrosActuales  = capacidadMaxima;
	}

	public void consumir(Double litros){
		this.litrosActuales -= litros;
	}

	public void recargar(Double litros){
		this.litrosActuales+= litros;
	}

	public Double capacidadMaxima(){
		return this.capacidadMaxima;
	}

	public boolean enReserva(){
		return this.litrosActuales < 0.1 * this.capacidadMaxima;
	}

	public boolean proximoAreserva(){
		return this.litrosActuales < 0.15 * this.capacidadMaxima;
	}

	public Double combustibleActual(){
		return this.litrosActuales;
	}
}
