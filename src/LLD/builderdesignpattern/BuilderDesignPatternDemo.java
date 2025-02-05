package LLD.builderdesignpattern;

// MAN OBJECT IS IMMUTABLE (THREAD SAFE)
class Man{

    private final String name;
    private final String money ;
    private final String romance ;
    private final String respect ;

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

        private String name;
        private String money ;
        private String romance ;
        private String respect ;

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
