package DesignPatterns.StructuralDesignPatterns;

public class DecoratorPattern {

    public static void main(String[] args) {
        UsableProduct d =  new DecoratedProduct(new BaseProduct());
        System.out.println(d.makeProduct());

    }
}

// common interface to be used by both the base class and decorator classes,
// so that client make invoke the common method on both the base class and decorated class, to loose couple
interface UsableProduct {

    public String makeProduct();
}


// base class on which at run time extra functionality needs to be added
class BaseProduct implements UsableProduct {

    @Override
    public String makeProduct() {
        return "base product";
    }
}


//decorator class to be extended by concrete classes
class Decorator implements UsableProduct {

    protected BaseProduct baseProduct;

    public Decorator(BaseProduct baseProduct){
        this.baseProduct = baseProduct;
    }

    @Override
    public String makeProduct() {
        return baseProduct.makeProduct();
    }
}


//concrete decorator extending the decorator
class DecoratedProduct extends Decorator{

    public DecoratedProduct(BaseProduct baseProduct) {
        super(baseProduct);
    }

    public String makeProduct(){
        return baseProduct.makeProduct() + addPriceInfo();
    }

    public String addPriceInfo(){
        return " + Price info";
    }
}


