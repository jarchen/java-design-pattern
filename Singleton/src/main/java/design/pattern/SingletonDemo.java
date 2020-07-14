package design.pattern;


public class SingletonDemo {
    private static SingletonDemo instance = null;

    private SingletonDemo() {
    }

    public SingletonDemo getInstance() {
        if (instance == null) instance = new SingletonDemo();

        return instance;
    }

    public static void main(String[] args) {

    }
}
