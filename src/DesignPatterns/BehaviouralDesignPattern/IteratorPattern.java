package DesignPatterns.BehaviouralDesignPattern;

import java.util.Iterator;

public class IteratorPattern {
    public static void main(String[] args) {
        NewList<String> list = new NewList<>();
        list.add("hi");
        list.add("this");
        list.add("is");
        list.add("Iterator pattern example");

        NewListIterator<String> li = list.iterator();
        while(li.hasNext())
            System.out.println(li.next());
    }

}

//Iterable is the interface, which gives us the interface to create the Iterator
// NewList is the Concrete Aggregate class, which creates the iterator for us
class NewList<T> implements Iterable<T>{

    Node<T> head, tail;

    public void add(T data){
        Node<T> node = new Node<>(data, null);
        if(head==null)
            head = tail = node;
        else{
            tail.setNext(node);
            tail = node;
        }
    }

    public Node<T> getHead(){
        return head;
    }

    public Node<T> getTail(){
        return tail;
    }

    @Override
    public NewListIterator<T> iterator() {
        return new NewListIterator<T>(this);
    }
}

// Iterator is the interface, which defines the interface for traversing objects of the collection
// this class is called the Concrete Iterator class
class NewListIterator<T> implements Iterator<T>{

    Node<T> current;

    public NewListIterator(NewList<T> list) {
        this.current = list.getHead();
    }

    @Override
    public boolean hasNext() {
        return current!=null;
    }

    @Override
    public T next() {
        T data = current.getData();
        current = current.getNext();
        return data;
    }

    public void remove(Node<T> remove){
        throw new UnsupportedOperationException();
    }
}

class Node<T>{
    T data;
    Node<T> next;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public void setData(T data){
        this.data = data;
    }

    public void setNext(Node<T> next){
        this.next = next;
    }

    public T getData(){
        return data;
    }

    public Node<T> getNext(){
        return next;
    }
}