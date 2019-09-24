package DesignPatterns.StructuralDesignPatterns;

public class FacadePattern{
    public static void main(String[] args) {

        Facade facade = new Facade();
        Transaction tx = new Transaction();

        System.out.println(" the authentication process is "+facade.Auth(tx));
        System.out.println(" the processing for transaction is "+facade.Processing(tx));
        System.out.println(" the report generation is "+facade.Report(tx));

    }
}

class Transaction{
    Boolean isAuthenticated;
    Boolean isAdjustmentDone;
    Boolean isReportGenerated;

    public Transaction() {
    }

    public void setAuthenticated(Boolean authenticated) {
        isAuthenticated = authenticated;
    }

    public void setAdjustmentDone(Boolean adjustmentDone) {
        isAdjustmentDone = adjustmentDone;
    }

    public void setReportGenerated(Boolean reportGenerated) {
        isReportGenerated = reportGenerated;
    }
}

class TransactionAuthentication {
    public Boolean Authentication(Transaction tx){
        return tx.isAuthenticated = true;
    }
}

class TransactionProcessing {
    public Boolean Processing(Transaction tx){
        return tx.isAdjustmentDone = true;
    }
}

class TransactionReportGenerator {
    public Boolean ReportGeneration(Transaction tx){
        return tx.isReportGenerated = true;
    }
}

class Facade{

    public Boolean Auth(Transaction tx){
        TransactionAuthentication authentication = new TransactionAuthentication();
        return authentication.Authentication(tx);
    }

    public Boolean Processing(Transaction tx){
        TransactionProcessing processing = new TransactionProcessing();
        return processing.Processing(tx);
    }

    public Boolean Report(Transaction tx){
        TransactionReportGenerator trg = new TransactionReportGenerator();
        return trg.ReportGeneration(tx);
    }

}




