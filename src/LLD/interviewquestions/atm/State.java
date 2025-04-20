package LLD.interviewquestions.atm;

public interface State {
     void cancel(AtmController atmController );
     void enter(AtmController atmController);
}


