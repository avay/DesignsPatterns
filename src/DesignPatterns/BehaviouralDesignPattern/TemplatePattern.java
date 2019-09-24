package DesignPatterns.BehaviouralDesignPattern;

public class TemplatePattern {

    public static void main(String[] args) {
        TemplateClass implementor1 = new Implementor1();
        implementor1.doProcessing();

        TemplateClass implementor2 = new Implementor2();
        implementor2.doProcessing();
    }

}

// template class
abstract class TemplateClass{

    // implementation logic to be defined by subclasses
    public abstract void implementation1();

    //implementation in abstract class which will be same across all sub classes
    public final void finalMethod(){
        System.out.println("gift wrap done");
    }

    // implementation logic to be defined by subclasses
    public abstract void implementation2();

    // thi si sthe template method, which defines the steps sequence
    public final void doProcessing(){
        implementation1();
        implementation2();
    }
}

//subclasses defining the implementation individually
class Implementor1 extends TemplateClass{

    @Override
    public void implementation1() {
        System.out.println("Implementor1's implementation1 method" );

    }

    @Override
    public void implementation2() {
        System.out.println("Implementor1's implementation2 method" );
    }
}

//subclasses defining the implementation individually
class Implementor2 extends TemplateClass{

    @Override
    public void implementation1() {
        System.out.println("Implementor2's implementation1 method" );
    }

    @Override
    public void implementation2() {
        System.out.println("Implementor2's implementation2 method" );
    }


}


