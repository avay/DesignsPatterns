package DesignPatterns.StructuralDesignPatterns;

public class ObjectAdapterPattern {
    public static void main(String[] args) {

        TargetObject to = new TargetObject();
        NonTargetClass ntc = new NonTargetClass();

        target adapter = new AdapterClass(ntc);
        System.out.println(adapter.targetMethod());

    }
}

// client understands only the object which are of type of Target, and calls their method targetMethod
interface target{
    public Integer targetMethod();
}

// target class which implements the interface
class TargetObject implements target{

    public Integer targetMethod() {
        return 1;
    }
}

// non compatible class which is the adaptee class, we have to call its nonTargetMethod method from the adapter
// and it should seem as if Target object's targetMethod is called.
class NonTargetClass{

    public Integer nonTargetMethod(){
        return 2;
    }
}


// adapter class implementing the target interface. Object composition using constructor
class AdapterClass extends TargetObject{

    private NonTargetClass ntc;

    public AdapterClass(NonTargetClass ntc) {
        this.ntc = ntc;
    }

    public Integer targetMethod() {
        return ntc.nonTargetMethod();
    }
}
