package design.pattern.factoryMethod;

import org.junit.Test;

public class OrderTest {

    @Test
    public void orderProductTest() {
        Factory factory = new FrenchFriesFactory();
        Product fries = factory.getProduct();
        Product myFries = ((FrenchFriesFactory) factory).getProduct("No salt");

        fries.describe();
        myFries.describe();
    }
}
