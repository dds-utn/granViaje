package domain;

public class ElectroVentilador {
	private Double gradosQueDisminuye;

	public ElectroVentilador(Double gradosQueDisminuye){
		this.gradosQueDisminuye = gradosQueDisminuye;
	}

	public void enfriar(Auto auto){
		auto.getMotor().disminuirTemperatura(this.gradosQueDisminuye);
	}
}
