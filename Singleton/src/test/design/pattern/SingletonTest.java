package design.pattern;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SingletonTest {

    @Test
    public void alwaysGetSameSingletonObject() {
        SingletonDemo obj1 = SingletonDemo.getInstance();
        SingletonDemo obj2 = SingletonDemo.getInstance();

        assertEquals(obj1, obj2);
    }
}
