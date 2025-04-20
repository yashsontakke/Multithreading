package LLD.interviewquestions.atm;

public class Card {
    long cardNumber;
    int pin ;
    int userAccountId ;

    public Card(long cardNumber, int pin, int userAccountId) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.userAccountId = userAccountId;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getUserAccountId() {
        return userAccountId;
    }

    public void setUserAccountId(int userAccountId) {
        this.userAccountId = userAccountId;
    }
}
