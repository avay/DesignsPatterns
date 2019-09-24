package DesignPatterns.BehaviouralDesignPattern;

public class InterpreterPattern2 {

    public static void main(String[] args) {
        Expression persion1 = new TerminalExpression("jack");
        Expression persion2 = new TerminalExpression("rose");
        Expression isSingle = new OrExpresssion(persion1,persion2);


        Expression persion3 = new TerminalExpression("virat");
        Expression persion4 = new TerminalExpression("anushka");
        Expression isMarried = new AndExpression(persion3, persion4);


        System.out.println(isSingle.interpret("jack"));
        System.out.println(isSingle.interpret("rose"));
        System.out.println(isSingle.interpret("Alfred"));

        System.out.println(isMarried.interpret("anushka, virat"));
        System.out.println(isMarried.interpret("priyanka, virat"));

    }
}

interface Expression{
    boolean interpret(String contex);
}

// leaf terminal expression
class TerminalExpression implements Expression{

    String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String contex) {
        return contex.contains(data);
    }
}

// Non Terminal Expression
class OrExpresssion implements Expression{

    Expression e1;
    Expression e2;

    public OrExpresssion(Expression e1, Expression e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    @Override
    public boolean interpret(String contex) {
        return e1.interpret(contex) || e2.interpret(contex);
    }
}

// Non Terminal expression
class AndExpression implements Expression{

    Expression e1;
    Expression e2;

    public AndExpression(Expression e1, Expression e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    @Override
    public boolean interpret(String contex) {
        return e1.interpret(contex) && e2.interpret(contex);
    }
}