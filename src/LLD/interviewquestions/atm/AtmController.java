package LLD.interviewquestions.atm;
import java.util.Random;

public class AtmController {

    State state;
    Atm atm ;
    Card card ;
    Account account;


    public void setState(State state){
        this.state = state;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public AtmController(Atm atm ){
        this.state = new EnterCardState();
        this.atm = atm ;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void enterCard(Card card ){
           if(atm.getCards().containsKey(card.getCardNumber())){
               setCard(card);
               setState(EnterPinState.getInstance());
           }else{
               System.out.println("please enter valid card ");
           }
    }

    public void enterPin(int pin){
       if(card.getPin()==pin){

           setAccount(atm.getCards().get(card));
           System.out.println("Welcome"+ account.getName());
           System.out.println("Your Balance is " + account.getBalance());
           setState(EnterMoneyState.getInstance());

       }else{
           System.out.println("please enter valid pin");
       }
    }

    public void enterMoney(int amount ){
        if(account.getBalance()>amount){
            account.setBalance(account.getBalance()-amount);
            setState(TakeMoney.getInstance());
            System.out.println("please collect your money");

        }else{
            System.out.println("You don't have sufficient balance ");
        }
    }


    public void cancel(){
        if(state.equals(EnterCardState.getInstance())){

        }else if(state.equals(EnterPinState.getInstance())){
            setState(EnterCardState.getInstance());
        }else if(state.equals(EnterMoneyState.getInstance())){
            setState(EnterCardState.getInstance());
        }else{
            System.out.println("Please collect your money");
        }
    }

    public static void main(String[] args) {
        Atm atm = new Atm();
        for(int i=0;i<10;i++){

            Random random = new Random();
            long cardNumber = 1_000_000_000_000_000L + random.nextLong(9_000_000_000_000_000L);
            int pin = 1000 + random.nextInt(9000);
            int balance = 1000 + random.nextInt(90000);

            Account account = new Account(i,"a"+i,balance);
            Card card = new Card(cardNumber,pin,account.id);

            atm.getCards().put(card,account);
        }
        AtmController atmController = new AtmController(atm);

    }

}
