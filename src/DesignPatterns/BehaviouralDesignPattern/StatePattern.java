package DesignPatterns.BehaviouralDesignPattern;

public class StatePattern {
    public static void main(String[] args) {
        TransactionContext tc = new TransactionContext(new transactionAuthenticated());
        tc.getState();
        tc.getState();
        tc.setTransactionState(new transactionFailure());
        tc.getState();
        tc.setTransactionState(new transactionComplete());
        tc.getState();
    }
}

interface transactionState{
    public void getState();
}

class transactionFailure implements transactionState{

    @Override
    public void getState() {
        System.out.println("transaction failed");
    }
}

class transactionAuthenticated implements transactionState{

    @Override
    public void getState() {
        System.out.println("transaction authenticated");
    }
}

class transactionComplete implements transactionState{

    @Override
    public void getState() {
        System.out.println("transaction complete");
    }
}

class TransactionContext implements transactionState{

    private transactionState ts;

    public TransactionContext(transactionState ts){
        this.ts = ts;
    }

    public void setTransactionState(transactionState ts){
        this.ts=ts;
    }

    @Override
    public void getState() {
         ts.getState();
    }
}