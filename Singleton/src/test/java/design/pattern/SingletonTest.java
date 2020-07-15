package design.pattern;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SingletonTest {

    @Test
    public void alwaysGetSameSingletonObjectForUnsafeLazyMode() {
        SingletonDemo obj1 = SingletonDemo.getInstanceWithThreadUnsafeLazyMode();
        SingletonDemo obj2 = SingletonDemo.getInstanceWithThreadUnsafeLazyMode();

        assertEquals(obj1, obj2);
    }

    @Test
    public void alwaysGetSameSingletonObjectForSafeLazyMode() {
        final SingletonDemo[] singleton = new SingletonDemo[2];

        Thread t1 = new Thread(() -> {
            singleton[0] = SingletonDemo.getInstanceWithThreadSafeLazyMode();
        });

        Thread t2 = new Thread(() -> {
            singleton[1] = SingletonDemo.getInstanceWithThreadSafeLazyMode();
        });


        assertEquals(singleton[0], singleton[1]);
    }

    @Test
    public void alwaysGetSameSingletonObjectForDoubleCheckLock() {
        final SingletonDemo[] singleton = new SingletonDemo[2];

        Thread t1 = new Thread(() -> {
            singleton[0] = SingletonDemo.getInstanceWithDoubleCheckLock();
        });

        Thread t2 = new Thread(() -> {
            singleton[1] = SingletonDemo.getInstanceWithDoubleCheckLock();
        });


        assertEquals(singleton[0], singleton[1]);
    }
}
