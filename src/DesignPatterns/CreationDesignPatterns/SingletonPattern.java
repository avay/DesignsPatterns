package DesignPatterns.CreationDesignPatterns;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingletonPattern  {

    public static void main(final String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, CloneNotSupportedException, IOException, ClassNotFoundException {

        //SingleTon s1 = new SingleTon();
        SingleTon s1 = SingleTon.getS();
        SingleTon s2 = SingleTon.getS();

        print("s1",s1);
        print("s2",s2);


        /* hack1 to create another instance of a singleton class

        Constructor<SingleTon> c = SingleTon.class.getDeclaredConstructor();
        c.setAccessible(true);
        SingleTon s3 = c.newInstance();

        print("s3",s3);
        */


        /* hack 2 create instance using the clone copy

        SingleTon s4 = (SingleTon) s1.clone();

        print("s4",s4);
        */

        /*hack 3

        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("/tmp/s1.ser"));
        os.writeObject(s1);

        //reconstruct the object
        ObjectInputStream is = new ObjectInputStream(new FileInputStream("/tmp/s1.ser"));
        SingleTon s5= (SingleTon) is.readObject();

        print("s5",s5);

        */


    }

    static void print(String name, SingleTon obj){
        System.out.println(String.format(" Object : %s, Hashcode; %d", name, obj.hashCode()));
    }


}

class SingleTon implements Cloneable, Serializable{
    private static SingleTon s = new SingleTon();
    private String name;

    private SingleTon() {
        System.out.println("creating singleton instance");

        /*prevention to hack1

        if(s!=null)
            throw new RuntimeException("can't create instance, please use getInstance method()");
        */
    }

    public SingleTon(String name){
        this.name = name;
    }

    public static SingleTon getS() {
        return s;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();

        /*prevention to hack 2
        if(s!=null)
            throw new RuntimeException("class cannot be cloned, please use getInstance method");
        */
    }

    /* prevention to hack 3

     */
    /*public Object readResolve(){
        System.out.println("preparing object from stream");
        return s;
    }*/


}



