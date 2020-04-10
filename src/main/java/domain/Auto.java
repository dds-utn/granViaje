package domain;

import com.sun.jmx.snmp.Timestamp;
import exceptions.*;

public class Auto {
	private TanqueDeCombustible tanqueDeCombustible;
	private EstadoAuto estado;
	private Motor motor;
	private ElectroVentilador electro;
	private int velocidadActual;
	private Timestamp timeStampVelocidadActual;

	public Motor getMotor(){
		return this.motor;
	}

	public EstadoAuto getEstado() { return this.estado; }

	public void setVelocidadActual(int velocidad){
		this.velocidadActual = velocidad;
		this.timeStampVelocidadActual = new Timestamp(System.currentTimeMillis());
	}

	public void setMotor(Motor unMotor){
		this.motor = unMotor;
	}

	public void setElectro(ElectroVentilador electro){
		this.electro = electro;
	}

	public void setTanqueDeCombustible(TanqueDeCombustible tanque){
		this.tanqueDeCombustible = tanque;
	}

	public int getVelocidadActual(){
		return this.velocidadActual;
	}

	public Timestamp getTimeStampVelocidadActual() { return this.timeStampVelocidadActual;}


    public TanqueDeCombustible getTanqueDeCombustible() { return this.tanqueDeCombustible; }


	public void enfriar(){
		this.electro.enfriar(this);
	}

	public Double capacidadMaximaCombustible(){
		return this.tanqueDeCombustible.capacidadMaxima();
	}

	public void aumentarTemperatura(Double grados){
		this.motor.aumentarTemperatura(this, grados);
	}

	public void cambiarEstadoA(EstadoAuto estado){
		this.estado = estado;
	}

	public void encender() throws NoSePuedeEncenderException, SinCombustibleException{
		this.estado.encender(this);
	}
	
	public void apagar() throws NoSePuedeApagarException {
		this.estado.apagar(this);
	}
	
	public void acelerar(int kmH) throws NoSePuedeAcelerarException {
		this.estado.acelerar(this, kmH);
	}
	
	public void detener() throws NoSePuedeDetenerException {
		this.estado.detener(this);
	}

	public void recargarCombustible(Double cantidad){
		this.tanqueDeCombustible.recargar(cantidad);
	}
}
