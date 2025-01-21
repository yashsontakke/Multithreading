package LLD.builderDesignPattern;

class Man{

    String name;
    String money ;
    String romance ;
    String respect ;

    private Man(ManBuilder manBuilder){
        this.name=manBuilder.name;
        this.money=manBuilder.money;
        this.respect=manBuilder.respect;
        this.romance=manBuilder.romance;
    }

    @Override
    public String toString() {
        return "Man{" +
                "name='" + name + '\'' +
                ", money='" + money + '\'' +
                ", romance='" + romance + '\'' +
                ", respect='" + respect + '\'' +
                '}';
    }

    public static class ManBuilder {

        String name;
        String money ;
        String romance ;
        String respect ;

        public ManBuilder setName(String name){
            this.name = name ;
            return this ;
        }

        public ManBuilder setMoney(String money) {
            this.money = money;
            return this;
        }

        public ManBuilder setRespect(String respect) {
            this.respect = respect;
            return this;
        }

        public ManBuilder setRomance(String romance) {
            this.romance = romance;
            return this;
        }

        public Man build(){
           return  new Man(this);
        }
    }

}

public class BuilderDesignPatternDemo {
    public static void main(String[] args) {
        Man man = new Man.ManBuilder().setName("ankit").setRomance("dabake").build();
        System.out.println(man);
    }
}
