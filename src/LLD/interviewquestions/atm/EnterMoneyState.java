package LLD.interviewquestions.atm;

public class EnterMoneyState implements State{

    private static EnterMoneyState instance = new EnterMoneyState();

    public static EnterMoneyState getInstance(){
        return instance;
    }

    @Override
    public void cancel(AtmController atmController) {

    }

    @Override
    public void enter(AtmController atmController) {

    }
}
