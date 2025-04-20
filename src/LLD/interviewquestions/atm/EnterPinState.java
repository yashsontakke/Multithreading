package LLD.interviewquestions.atm;

public class EnterPinState implements  State{

    private static final EnterPinState instance  = new EnterPinState();

    public static EnterPinState getInstance(){
        return  instance;
    }

    @Override
    public void cancel(AtmController atmController) {
        atmController.setState(EnterCardState.getInstance());
    }

    @Override
    public void enter(AtmController atmController) {
        atmController.setState(EnterMoneyState.getInstance());
    }
}
