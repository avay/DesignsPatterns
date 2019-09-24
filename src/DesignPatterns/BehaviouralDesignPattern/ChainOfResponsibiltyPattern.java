package DesignPatterns.BehaviouralDesignPattern;

public class ChainOfResponsibiltyPattern {

    public static void main(String[] args) {
        RequestObject r = new RequestObject();
        r.setNum(0);

        ChainObjectThree three = new ChainObjectThree();
        ChainObjectTwo two = new ChainObjectTwo();
        ChainObjectOne one = new ChainObjectOne();
        one.setNextChain(two);
        two.setNextChain(three);

        one.evaluate(r);
    }
}

interface ChainObject{
    public void setNextChain(ChainObject c);
    public void evaluate(RequestObject r);
}

class RequestObject{

    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

class ChainObjectOne implements ChainObject{

    private ChainObject nextChainObject;

    @Override
    public void setNextChain(ChainObject c) {
        this.nextChainObject = c;
    }

    @Override
    public void evaluate(RequestObject r) {
        if(r.getNum()>10){
            System.out.println("the number is greater than 10, and it will be processed ");
        }
        else{
            System.out.println("checked in Chain Object One, sending to Second Chain Object");
            nextChainObject.evaluate(r);
        }

    }
}

class ChainObjectTwo implements ChainObject{

    private ChainObject nextChainObject;

    @Override
    public void setNextChain(ChainObject c) {
        this.nextChainObject = c;
    }

    @Override
    public void evaluate(RequestObject r) {
        if(r.getNum()<10 && r.getNum()>0){
            System.out.println("the number is greater than 0 and less than 10 , and it will be processed");
        }
        else{
            System.out.println("checked in Chain Object Two, sending to Third Chain Object");
            nextChainObject.evaluate(r);
        }

    }
}

class ChainObjectThree implements ChainObject{

    private ChainObject nextChainObject;

    @Override
    public void setNextChain(ChainObject c) {
        this.nextChainObject = c;
    }

    @Override
    public void evaluate(RequestObject r) {
        if(r.getNum()<0){
            System.out.println("the number is negative , and it will be processed for negative values only");
        }
        else{
            if(nextChainObject==null){
                System.out.println("checked in Chain Object Three, no other operation left ");
            }
            else{
                System.out.println("checked in Chain Object Three, sending to fourth Chain Object");
                nextChainObject.evaluate(r);
            }

        }

    }
}