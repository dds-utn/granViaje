package domain;

import com.sun.jmx.snmp.Timestamp;

public class Motor {
	private Double temperatura = 0.0;
	private Double limiteTemperaturaMaxima = 95.0;
	private Double consumoPromedio = 133.0;

	public void apagar(){
		this.temperatura = 0.0;
	}

	public void aumentarTemperatura(Auto auto, Double grados) {
		this.temperatura += grados;
		enfriarSiEsNecesario(auto);
	}

	private void enfriarSiEsNecesario(Auto auto){
		if (this.temperatura >= this.limiteTemperaturaMaxima) {
			auto.enfriar();
		}
	}

	public void disminuirTemperatura(Double grados){
		this.temperatura -= grados;
	}

	public void consumirCombustible(Auto auto, Double litros){
		auto.getTanqueDeCombustible().consumir(litros);
	}

	public void desplazar(Auto auto){
		Timestamp ahora = new Timestamp(System.currentTimeMillis());
		Double intervalo = (ahora.getDate().getTime() - auto.getTimeStampVelocidadActual().getDate().getTime()) * 0.001;
		Double kms = intervalo * (velocidadEnSegundos((double)auto.getVelocidadActual()));
		auto.getTanqueDeCombustible().consumir(kms * consumoPromedioEnLitros());
	}

	private Double velocidadEnSegundos(Double velocidad){
		return velocidad / 3600;
	}

	private Double consumoPromedioEnLitros(){
		return this.consumoPromedio / 1000;
	}
}
