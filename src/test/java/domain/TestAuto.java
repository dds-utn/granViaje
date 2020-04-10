package domain;

import exceptions.NoSePuedeAcelerarException;
import exceptions.NoSePuedeEncenderException;
import exceptions.SinCombustibleException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestAuto {
    private Auto auto;

    @Before
    public void init(){
        this.auto = new Auto();
        this.auto.setMotor(new Motor());
        this.auto.setElectro(new ElectroVentilador(15.00));
        this.auto.setTanqueDeCombustible(TanqueDeCombustible.deCapacidad(65.00));
        this.auto.cambiarEstadoA(new Apagado(this.auto));
    }

    @Test(expected = SinCombustibleException.class)
    public void intentarEncenderAutoSinCombustible() throws NoSePuedeEncenderException, SinCombustibleException{
        this.auto.getTanqueDeCombustible().consumir(65.00);
        this.auto.encender();
    }

    @Test
    public void encenderYacelerar(){
        try{
            this.auto.encender();
            this.auto.acelerar(20);
            Assert.assertEquals(EnMovimiento.class,this.auto.getEstado().getClass());
        }
        catch (NoSePuedeEncenderException exception){
            System.out.print(exception.getMessage());
        }
        catch (SinCombustibleException exception){
            System.out.print(exception.getMessage());
        }
        catch (NoSePuedeAcelerarException exception){
            System.out.print(exception.getMessage());
        }
    }

    @Test
    public void acelerarDosVecesConsumeCombustible(){
        try{
            this.auto.encender();
            this.auto.acelerar(20);
            Thread.sleep(5000);
            this.auto.acelerar(40);
            Assert.assertEquals(64.00,this.auto.getTanqueDeCombustible().combustibleActual(), 1.00);
        }
        catch (NoSePuedeEncenderException exception){
            System.out.print(exception.getMessage());
        }
        catch (SinCombustibleException exception){
            System.out.print(exception.getMessage());
        }
        catch (NoSePuedeAcelerarException exception){
            System.out.print(exception.getMessage());
        }
        catch (InterruptedException exception){
            //
        }
    }
}
