package DesignPatterns.BehaviouralDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class MementoPattern {

    public static void main(String[] args) {
        List<Memento> list = new ArrayList<>();
        Life life = new Life();
        life.setTime("1000 BC");
        list.add(life.saveToMemento());
        life.setTime("2000 BC");
        list.add(life.saveToMemento());
        life.setTime("3000 BC");
        list.add(life.saveToMemento());

        System.out.println("restoring to old time" );
        life.restoreFromMomento(list.get(0));
        System.out.println("new time of the life is "+life.getTime() );
    }
}


class Life{
    private String time;

    public Memento saveToMemento(){
        System.out.println("creating a new memento for the time "+time);
        return new Memento(time);
    }

    public void restoreFromMomento(Memento memento){
        System.out.println("restoring from Memento to time "+memento.getTime());
        time = memento.getTime();
    }

    public void setTime(String time) {
        System.out.println("Time restored ");
        this.time = time;
    }

    public String getTime() {
        return time;
    }
}

class Memento{
    private String time;

    public Memento(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }
}