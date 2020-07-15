package design.pattern.abstractFactory;

/*
 * Abstract Class
 */
abstract class AbstractFactory {

    public abstract Audi createAudi();

    public abstract BMW createBMW();
}

abstract class Audi {
    private String brand;
    private String type;

    public Audi() {
        this.brand = "Audi";
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "Audi{" +
                "brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

abstract class BMW {
    private String band;
    private String type;

    public BMW() {
        this.band = "BMW";
    }


    public String getBand() {
        return band;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "BMW{" +
                "band='" + band + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

/*
 * Abstract Class Impl
 */
class AudiJeep extends Audi {

    public AudiJeep() {
        super();
        setType("Jeep");
    }
}

class AudiSUV extends Audi {

    public AudiSUV() {
        super();
        setType("SUV");
    }
}

class BMWJeep extends BMW {

    public BMWJeep() {
        super();
        setType("Jeep");
    }
}

class BMWSUV extends BMW {

    public BMWSUV() {
        super();
        setType("SUV");
    }
}

class JeepFactory extends AbstractFactory {
    @Override
    public Audi createAudi() {
        return new AudiJeep();
    }

    @Override
    public BMW createBMW() {
        return new BMWJeep();
    }
}

class SUVFactory extends AbstractFactory {
    @Override
    public Audi createAudi() {
        return new AudiSUV();
    }

    @Override
    public BMW createBMW() {
        return new BMWSUV();
    }
}
