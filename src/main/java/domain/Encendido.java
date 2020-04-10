package domain;

public class Encendido extends EstadoAuto {
    private Double gradosAumentadosAlEncender       = 70.0;
    private Double porcentajeCombustibleConsumido   = 0.001;

    public Encendido(Auto auto){
        aumentarTemperatura(auto);
        consumirCombustible(auto);
    }

    private void aumentarTemperatura(Auto auto) {
        auto.aumentarTemperatura(this.gradosAumentadosAlEncender);
    }

    private void consumirCombustible(Auto auto){
        Double litrosAConsumir = this.porcentajeCombustibleConsumido * auto.capacidadMaximaCombustible();
        auto.getMotor().consumirCombustible(auto, litrosAConsumir);
    }

    @java.lang.Override
    public void apagar(Auto auto) {
        auto.cambiarEstadoA(new Apagado(auto));
    }

    @java.lang.Override
    public void acelerar(Auto auto, int kmH) {
        auto.cambiarEstadoA(new EnMovimiento(auto, kmH));
    }
}
