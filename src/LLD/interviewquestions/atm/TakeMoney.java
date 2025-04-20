package LLD.interviewquestions.atm;

public class TakeMoney implements  State{


    private static final TakeMoney instance = new TakeMoney();

    public static TakeMoney getInstance(){
        return instance;
    }

    @Override
    public void cancel(AtmController atmController) {

    }

    @Override
    public void enter(AtmController atmController) {

    }
}
