package DesignPatterns.CreationDesignPatterns;

public class FactoryPattern {


    public static void main(String[] args) {
        Person p = FactoryClass.getPerson("Ravi","M");
        System.out.println("name and salutation  is "+p.getNameAndSalutation());

        Person p1 = FactoryClass.getPerson("Rajni","F");
        System.out.println("name and saluation "+p1.getNameAndSalutation());
    }

    //static Factory class and the its method to delegate create of Person
    public static class FactoryClass{
        public static Person getPerson(String name, String Gender){
                if(Gender.equals("M"))
                    return new Male(name);
                else if(Gender.equals("F"))
                    return new Female(name);
                return null;
        }
    }

    // creating the contract class
    static abstract class Person{
        public Person(String name) {
            this.name = name;
        }
        private String name;
        abstract String getSalutation();
        String getNameAndSalutation(){
            return getSalutation()+" "+name;
        }
    }

    // classes implementing the contract or extending the contract
    static class Male extends Person{

        public Male(String name) {
            super(name);
        }

        @Override
        String getSalutation() {
            return "Mr";
        }
    }

    // classes implementing the contract or extending the contract
    static class Female extends Person{

        public Female(String name) {
            super(name);
        }

        @Override
        String getSalutation() {
            return "Miss/Ms";
        }
    }
}


