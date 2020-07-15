package design.pattern.abstractFactory;

import org.junit.Test;

public class DrawRectangleAbstractFactoryTest {

    @Test
    public void abstractFactoryTest() {
        Rectangle rect = new Rectangle(20, 10);
        PointCornerFactory factory = new PointCornerFactoryImpl();

        rect.paint(factory);
    }
}
