package domain;

public class EnMovimiento extends EstadoAuto{
    private Double temperaturaAlAcelerar = 0.2;

    public EnMovimiento(Auto auto, int velocidad){
        auto.setVelocidadActual(velocidad);
    }

    @java.lang.Override
    public void detener(Auto auto) {
        auto.cambiarEstadoA(new Detenido(auto));
    }

    @Override
    public void apagar(Auto auto){
        auto.cambiarEstadoA(new Apagado(auto));
    }

    @java.lang.Override
    public void acelerar(Auto auto, int kmH) {
        aumentarTemperaturaAlAcelerar(auto, kmH);
        consumirCombustible(auto);
        auto.setVelocidadActual(kmH);
    }

    private void consumirCombustible(Auto auto){
        auto.getMotor().desplazar(auto);
    }

    private void aumentarTemperaturaAlAcelerar(Auto auto, int kmH){
        Double gradosAaumentar = this.temperaturaAlAcelerar * kmH;
        auto.aumentarTemperatura(gradosAaumentar);
    }
}
