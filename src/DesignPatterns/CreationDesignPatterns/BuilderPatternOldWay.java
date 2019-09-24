package DesignPatterns.CreationDesignPatterns;

public class BuilderPatternOldWay {

    public static void main(String[] args) {

        // a client code creates the director instance and injects the concretebuilder object into it.
        // the client then calls the construct method on director instance
        // finally the client retrieves the product from the concretebuilder object.
        ConcreteProductBuilder concreteProductBuilder = new ConcreteProductBuilder();
        ProductDirector productDirector = new ProductDirector(concreteProductBuilder);
        Product product = null;

        productDirector.constructProduct(Price.PRICE1);
        product = concreteProductBuilder.getProduct();
        System.out.println("product created "+product.toString());
    }

}

// an interface to break the product different complex building blocks
// also defines a method to retrieve product
interface Builder{

    void buildProductDimensions();

    void buildProductPricing(Price price1);

    void buildProductFeature();

    Product getProduct();
}


// director who uses the concretebuilder to create product. constructor argument is the builder
// defines a method where it calls the different building blocks by the use of builder
class ProductDirector {

    private Builder productBuilder;

    public ProductDirector(ConcreteProductBuilder concreteProductBuilder) {
        this.productBuilder = concreteProductBuilder;
    }

    public void constructProduct(Price price1) {
        productBuilder.buildProductDimensions();
        productBuilder.buildProductPricing(price1);
        productBuilder.buildProductFeature();
    }
}

// concreteBuilder makes use of Builder interface and
// implements the logic for each complex building block for the product
class ConcreteProductBuilder implements Builder{

    private static Product product = new Product();

    public ConcreteProductBuilder() {

    }

    @Override
    public void buildProductDimensions() {
            product.breadth = 1;
            product.weight= 2;
            product.height = 3;
    }

    @Override
    public void buildProductPricing(Price price1) {
            product.Price = price1.price;
    }

    @Override
    public void buildProductFeature() {
        product.color= "blue";
        product.material = "plastic";
    }

    @Override
    public Product getProduct() {
        return product;
    }
}

// the actual product which has to be build as per the builder
class Product{
    Integer height =0;
    Integer weight = 0;
    Integer breadth = 0;
    double Price=0.0;
    String color=null;
    String material=null;

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setBreadth(Integer breadth) {
        this.breadth = breadth;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWeight() {
        return weight;
    }

    public Integer getBreadth() {
        return breadth;
    }

    public double getPrice() {
        return Price;
    }

    public String getColor() {
        return color;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return "Product{" +
                "height=" + height +
                ", weight=" + weight +
                ", breadth=" + breadth +
                ", Price=" + Price +
                ", color='" + color + '\'' +
                ", material='" + material + '\'' +
                '}';
    }
}

enum Price {

    PRICE1(1000), PRICE2(2000);

    public double price;

    Price(double i){
        this.price = i;
    }
}


