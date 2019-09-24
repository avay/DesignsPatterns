package DesignPatterns.CreationDesignPatterns;

import java.util.Random;
import java.util.concurrent.*;

public class SingletonAccesThreadExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        int hashcode1=0;
        int hashcode2=0;
        ExecutorService pool = Executors.newFixedThreadPool(2);
        SingletonThread st1 = new SingletonThread();
        SingletonThread st2 = new SingletonThread();

        Future<Integer> result1 = pool.submit(st1);
        Future<Integer> result2 = pool.submit(st2);

        boolean matched = true;
        while(matched){

            hashcode1 = result1.get(1000, TimeUnit.MILLISECONDS);
            System.out.println("hashcode1 is "+hashcode1);
            hashcode2 = result2.get(1000, TimeUnit.MILLISECONDS);
            System.out.println("hashcode2 is "+hashcode2);


            if(hashcode1!=hashcode2)
                matched = false;

            result1 = pool.submit(st1);
            result2 = pool.submit(st2);

        }
        System.out.println("halted the main program");

        pool.shutdown();
    }
}

class SingletonThread implements Callable {

    @Override
    public Integer call() throws Exception {
        Thread.sleep(new Random().nextInt(1000));
        //return SingletonForThread.getInstances().hashCode();
        return SingletonEnumClass.INSTANCE.hashCode();
    }
}


class SingletonForThread {

    private static volatile SingletonForThread s = null; // lazy intialization

    private SingletonForThread(){
        System.out.println("creating the singleton thread");
    }

    public static  SingletonForThread getInstances(){
        if(s==null)
            synchronized (SingletonForThread.class){
                if(s==null)
                    s = new SingletonForThread();
            }

        return s;
    }

}

// best way to implement th enum class as Singleton as defined by Joshua Bloch
enum SingletonEnumClass{

    INSTANCE;

    SingletonEnumClass(){
        System.out.println("called the constructor only once for the application");
    }

    public static void getInstance(){
        // do something
    }
}
