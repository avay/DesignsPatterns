package DesignPatterns.BehaviouralDesignPattern;

public class MediatorPattern {

    public static void main(String[] args) {
        ConcreteMediator cm = new ConcreteMediator();
        FlightA fa = new FlightA(cm,"A007");
        FlightB fb = new FlightB(cm,"B007");
        fa.sendSignal();
        fb.sendSignal();
    }
}

interface Mediator{
    public abstract void receiveInput(String fno, String msg);
    public abstract void sendOutput(String fno, String msg);
    public void registerFlightA(Flight A);
    public void registerFlightB(Flight B);
}

class ConcreteMediator implements Mediator{

    private FlightA fa;
    private FlightB fb;

    //recieving inputs from flight
    @Override
    public void receiveInput(String fno, String msg) {
            if(fa.getFlightno().equals(fno)){
                System.out.println("signal recieved by mediator for flight no :"+fno+" and the message is :"+msg);
                sendOutput(fno, msg);
            }
            else if(fb.getFlightno().equals(fno)){
                System.out.println("signal recieved by mediator for flight no :"+fno+" and the message is :"+msg);
                sendOutput(fno, msg);
            }

    }

    // broadcasting to respective flight
    @Override
    public void sendOutput(String fno, String msg) {
        if(fa.getFlightno().equals(fno))
                    fa.recieveSignal(msg);
        else if(fb.getFlightno().equals(fno))
                    fb.recieveSignal(msg);
    }

    @Override
    public void registerFlightA(Flight A) {
        this.fa = (FlightA) A;
    }

    @Override
    public void registerFlightB(Flight B) {
        this.fb = (FlightB) B;
    }


}

abstract class Flight{
    String flightno;
    Mediator mediator;
    public abstract void sendSignal();
    public abstract void recieveSignal(String msg);
}

class FlightA extends Flight{

    private Mediator mediator;
    private String flightno;

    public FlightA(Mediator m,String flightno) {
        this.flightno = flightno;
        this.mediator = m;
        this.mediator.registerFlightA(this);
    }

    @Override
    public void sendSignal() {
       this.mediator.receiveInput("B007", "I am landing");
    }

    @Override
    public void recieveSignal(String msg) {
        System.out.println("signal recieved by "+this.flightno+" from B via mediator is :"+msg);
    }

    public String getFlightno(){
        return this.flightno;
    }
}

class FlightB extends Flight{

    private Mediator mediator;
    private String flightno;

    public FlightB(Mediator m, String flightno) {
        this.flightno = flightno;
        this.mediator = m;
        this.mediator.registerFlightB(this);
    }

    @Override
    public void sendSignal() {
        this.mediator.receiveInput("A007", "I am taking off");
    }

    @Override
    public void recieveSignal(String msg) {
        System.out.println("signal recieved by "+this.flightno+" from A via mediator is :"+msg);
    }

    public String getFlightno(){
        return this.flightno;
    }
}
