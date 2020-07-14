package design.pattern;


public class SingletonDemo {
    private static SingletonDemo instance = null;

    private SingletonDemo() {
    }

    public static SingletonDemo getInstanceWithThreadUnsafeLazyMode() {
        if (instance == null) instance = new SingletonDemo();

        return instance;
    }


    // 加入 synchronized 將方法鎖住
    public static synchronized SingletonDemo getInstanceWithThreadSafeLazyMode() {
        if (instance == null) instance = new SingletonDemo();

        return instance;
    }

    // 進行兩次判斷，第二次才鎖住
    public static SingletonDemo getInstanceWithDoubleCheckLock() {
        if (instance == null) {
            synchronized (SingletonDemo.class) {
                if (instance == null) instance = new SingletonDemo();
            }
        }

        return instance;
    }
}
