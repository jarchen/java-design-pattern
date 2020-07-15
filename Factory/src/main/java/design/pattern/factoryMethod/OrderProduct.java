package design.pattern.factoryMethod;

interface Product {
    public void describe();
}

interface Factory {
    public Product getProduct();
}

class FrenchFries implements Product {
    String state = "salt";

    protected FrenchFries() {
    }

    protected FrenchFries(String state) {
        this.state = state;
    }

    @Override
    public void describe() {
        System.out.println("I'm " + state + " FrenchFries");
    }
}

class FrenchFriesFactory implements Factory {
    @Override
    public Product getProduct() {
        return new FrenchFries();
    }

    public Product getProduct(String state) {
        return new FrenchFries(state);
    }
}
