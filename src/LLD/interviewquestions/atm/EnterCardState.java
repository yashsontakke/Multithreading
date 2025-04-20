package LLD.interviewquestions.atm;

public class EnterCardState implements  State{

    private static final  EnterCardState instance = new EnterCardState();

    public static EnterCardState getInstance(){
        return  instance;
    }

    @Override
    public void cancel(AtmController atmController) {
        System.out.println("Please enter your card ");
    }

    @Override
    public void enter(AtmController atmController) {
        atmController.setState(EnterMoneyState.getInstance());
    }

}
