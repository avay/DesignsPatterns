package DesignPatterns.BehaviouralDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class VisitorPattern {
    public static void main(String[] args) {
        ConcreteVisitorObject cvo = new ConcreteVisitorObject();
        List<CartObjects> co = new ArrayList<>();
        double cartTotalAmount = 0.00;
        co.add(new StationeryItems("pen",10.00));

        co.add(new GroceryItems("grains",20.00));
        for(CartObjects c: co){
            cartTotalAmount+=c.doCalculation(cvo);
        }
        System.out.println("Total amount billed is "+cartTotalAmount );
    }
}

interface CartObjects{
    public double doCalculation(VisitorObject v);
}

class StationeryItems implements CartObjects{

    private VisitorObject v;
    private String name;
    private double price;

    public StationeryItems(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double doCalculation(VisitorObject v) {
        return v.stationeryItemsVisit(this);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class GroceryItems implements CartObjects{

    private VisitorObject v;
    private String name;
    private double price;

    public GroceryItems(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double doCalculation(VisitorObject v) {
        return v.groceryItemsVisit(this);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

interface VisitorObject{
    double stationeryItemsVisit(StationeryItems s);
    double groceryItemsVisit(GroceryItems g);
}

class ConcreteVisitorObject implements VisitorObject{

    @Override
    public double stationeryItemsVisit(StationeryItems s) {
        // you can add the discount logic for items and then return the actual price
        return s.getPrice()*1.5;
    }

    @Override
    public double groceryItemsVisit(GroceryItems g) {
        // you can add the discount logic for items and then return the actual price
        return g.getPrice()*2.5;
    }
}
