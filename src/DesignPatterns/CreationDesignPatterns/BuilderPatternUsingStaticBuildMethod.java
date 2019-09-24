package DesignPatterns.CreationDesignPatterns;

public class BuilderPatternUsingStaticBuildMethod {

    public static void main(String[] args) {
        ProductNew product = new ProductNew.Builder().height(5).weight(5).breadth(5).build();
        System.out.println(product);
    }

    static class ProductNew{
        private Integer height =0;
        private Integer weight = 0;
        private Integer breadth = 0;
        private double price=0.0;


        private ProductNew(Builder builder){
            this.height = builder.height;
            this.weight = builder.weight;
            this.breadth = builder.breadth;
            this.price = builder.price;
        }

        public static class Builder{

            private Integer height =0;
            private Integer weight = 0;
            private Integer breadth = 0;
            private double price=0.0;


            public Builder(){
            }

            public ProductNew build(){
                return new ProductNew(this);
            }

            public Builder height(Integer height){
                this.height = height;
                return this;
            }

            public Builder weight(Integer weight){
                this.weight = weight;
                return this;
            }

            public Builder breadth(Integer breadth){
                this.breadth = breadth;
                return this;
            }

            public Builder price(double price){
                this.price = price;
                return this;
            }
        }

        @Override
        public String toString() {
            return "ProductNew{" +
                    "height=" + height +
                    ", weight=" + weight +
                    ", breadth=" + breadth +
                    ", price=" + price +
                    '}';
        }
    }
}



