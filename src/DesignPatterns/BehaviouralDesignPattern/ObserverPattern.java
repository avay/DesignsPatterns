package DesignPatterns.BehaviouralDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {
    public static void main(String[] args) {
        ObserverObject o1 = new ObserverObject();
        ObserverObject o2 = new ObserverObject();
        ConceretSubject s = new ConceretSubject();
        s.registerObserver(o1);
        s.registerObserver(o2);
        o1.setSubject(s);
        o2.setSubject(s);
        System.out.println("o1 article "+o1.getArticle());
        s.postNewArticle();
        System.out.println("o1 article "+o1.getArticle());
    }
}

interface Subject{
    public void registerObserver(ObserverObject o);
    public void doNotify();
    public void unregisterObserver(ObserverObject o);
    public Object getUpdate();
}

interface ObserverInterface{
    public void update();
    public void setSubject(Subject s);
}

class ObserverObject implements ObserverInterface{

    private String article;
    private Subject sub;

    @Override
    public void update() {
        this.article = (String) sub.getUpdate();
        System.out.println("Observer notified");
    }

    @Override
    public void setSubject(Subject s) {
        this.sub = s;
        this.article = "no new article";
    }

    public String getArticle(){
        return article;
    }
}


class ConceretSubject implements Subject{

    private List<ObserverObject> observerList;
    private boolean statechange;

    public ConceretSubject() {
        this.observerList = new ArrayList<>();
        this.statechange = false;
    }

    @Override
    public void registerObserver(ObserverObject o) {
        this.observerList.add(o);
    }

    @Override
    public void doNotify() {
        if(statechange){
            for(ObserverObject o: observerList){
                o.update();
            }
        }

    }

    @Override
    public void unregisterObserver(ObserverObject o) {
        this.observerList.remove(o);
    }

    @Override
    public Object getUpdate() {
        Object o = null;
        if(statechange){
            o = "the updated object after state changed";
        }
        return o;
    }

    public void postNewArticle(){
        statechange = true;
        doNotify();
    }
}