package design.pattern.abstractFactory;

import org.junit.Test;

public class CarAbstractFactoryTest {

    @Test
    public void abstractFactoryTest() {
        AbstractFactory factorySUV = new SUVFactory();
        System.out.println("----- SUV Factory ----");

        Audi suvAudi = factorySUV.createAudi();
        System.out.println(suvAudi);

        BMW suvBMW = factorySUV.createBMW();
        System.out.println(suvBMW);


        AbstractFactory factoryJeep = new JeepFactory();
        System.out.println("----- Jeep Factory ----");

        Audi jeepAudi = factoryJeep.createAudi();
        System.out.println(jeepAudi);

        BMW jeepBMW = factoryJeep.createBMW();
        System.out.println(jeepBMW);
    }
}
