package DesignPatterns.CreationDesignPatterns;

public class PrototypePattern {

    public static void main(String[] args) throws CloneNotSupportedException {
        BaseClass b = new BaseClass();
        BaseClass bcloned = b.clone();
        PrototypePattern pt = new PrototypePattern();
        BaseClass hybrid = pt.getHybrid(bcloned);
        System.out.println("value of the hybrid class "+hybrid.toString());
    }

    public BaseClass getHybrid(BaseClass b){
         b.MakeHybridClass();
         return b;
    }

}

// base class which always needs to be created
class BaseClass implements Cloneable{

    String prop1;
    String prop2;
    String prop3;

    public BaseClass() {
    }

    public BaseClass(String prop1, String prop2, String prop3) {
        this.prop1 = prop1;
        this.prop2 = prop2;
        this.prop3 = prop3;
    }


    public BaseClass clone() throws CloneNotSupportedException {
        return new BaseClass();
    }

    public void MakeHybridClass(){
        this.prop1 = "hybridprop1";
        this.prop2 = "hybridprop2";
        this.prop3 = "hybridprop3";
    }

    @Override
    public String toString() {
        return "BaseClass{" +
                "prop1='" + prop1 + '\'' +
                ", prop2='" + prop2 + '\'' +
                ", prop3='" + prop3 + '\'' +
                '}';
    }
}
