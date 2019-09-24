package DesignPatterns.CreationDesignPatterns;

public class AbstractFactoryPattern {

    public static void main(String[] args) {
        CarFactory cf = new CarFactory();
        HondaFactory hf = (HondaFactory) cf.createFactory("Honda");
        HondaCar hc = hf.createHondaCar("Civic", "Sedan", "black");
        System.out.println(" quotation of honda car "+hc.getQuotation());

        ToyotaFactory tf = (ToyotaFactory) cf.createFactory("Toyota");
        ToyotaCar tc = tf.createToyotaCar("Camry", "Sedan", "blue");
        System.out.println(" quotation of toyota car is "+tc.getQuotation() );
    }
}


// contract for all factory
interface IFactory{
     IFactory createFactory(String type);
}

// contract for car
abstract class Car{
    private String color;
    private String Name;
    private String type;

    public Car(String color, String name, String type) {
        this.color = color;
        Name = name;
        this.type = type;
    }

    abstract long getQuotation();
}

class HondaCar extends Car{

    public HondaCar(String color, String name, String type) {
        super(color, name, type);
    }

    @Override
    long getQuotation() {
        return 10000;
    }
}

class ToyotaCar extends Car{

    public ToyotaCar(String color, String name, String type) {
        super(color, name, type);
    }

    @Override
    long getQuotation() {
        return 20000;
    }
}

class CarFactory implements IFactory{
    @Override
    public  IFactory createFactory(String type) {
        IFactory factory = null;
        if(type=="Honda")
            factory = new HondaFactory();
        else if(type=="Toyota")
            factory = new ToyotaFactory();
        return factory;
    }
}

class HondaFactory extends CarFactory{
        public HondaCar createHondaCar(String name, String type, String color){
            return new HondaCar(name,type,color);
        }
}

class ToyotaFactory extends CarFactory{
        public ToyotaCar createToyotaCar(String name, String type, String color){
            return new ToyotaCar(name,type,color);
        }
}

