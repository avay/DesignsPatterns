package DesignPatterns.StructuralDesignPatterns;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompositePattern {

    public static void main(String[] args) {
        Employee emp1 = new Developer("David",50000);
        Employee emp2 = new Developer("Albert", 60000);
        Employee manager = new Manager("Thomas",100000);
        manager.add(emp1);
        manager.add(emp2);
        Manager generalManager = new Manager("Sandy",5000);
        generalManager.add(manager);
        generalManager.add(new Developer("charlie",40000));
        generalManager.print();
    }
}

interface Employee{
     public void add(Employee e);
     public Employee getChild(int i);
     public String getName();
     public double getSalary();
     public void print(); // this is the operation executed on every object
}

// parent nodes
class Manager implements Employee{

    private String name;
    private double salary;

    public Manager(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    List<Employee> employees = new ArrayList<Employee>();

    @Override
    public void add(Employee e) {
        employees.add(e);
    }

    @Override
    public Employee getChild(int i) {
        return employees.get(i);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public void print() {
        System.out.println("-----------------" );
        System.out.println("name='" + name );
        System.out.println( "salary=" + salary);
        Iterator<Employee> itr = employees.iterator();
        while(itr.hasNext()){
            Employee emp = (Employee) itr.next();
            emp.print();
        }
    }


}

class Developer implements Employee{

    private String name;
    private double salary;

    public Developer(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public void add(Employee e) {

    }

    @Override
    public Employee getChild(int i) {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public void print() {
        System.out.println("-----------------" );
        System.out.println("name='" + name );
        System.out.println( "salary=" + salary);
    }

}
