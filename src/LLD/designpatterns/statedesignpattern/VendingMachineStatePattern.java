package LLD.designpatterns.statedesignpattern;

// State Design Pattern Example: Vending Machine

// 1. State Interface - defines behavior methods
interface VendingMachineState {
    void insertCoin(VendingMachine machine);
    void pressButton(VendingMachine machine);
}

// 2. Concrete State: Idle State (waiting for coin)
class IdleState implements VendingMachineState {
    @Override
    public void insertCoin(VendingMachine machine) {
        System.out.println("Coin inserted. You can now press the button.");
        machine.nextState(new HasCoinState());
    }

    @Override
    public void pressButton(VendingMachine machine) {
        System.out.println("Please insert coin first.");
    }
}

// 3. Concrete State: HasCoin State (ready to dispense)
class HasCoinState implements VendingMachineState {
    @Override
    public void insertCoin(VendingMachine machine) {
        System.out.println("Coin already inserted. Press the button.");
    }

    //The state object itself knows when and how to transition to another state.
    @Override
    public void pressButton(VendingMachine machine) {
        System.out.println("Button pressed. Dispensing item...");
        machine.nextState(new IdleState()); // Return to idle after dispensing
    }
}

// 4. Context Class
class VendingMachine {
    private VendingMachineState currentState;

    public VendingMachine() {
        this.currentState = new IdleState(); // Initial state
    }

    public void nextState(VendingMachineState state) {
        this.currentState = state;
    }

    //Instead of hardcoding transitions with if/else, encapsulate each state as a class with
    // allowed transitions and actions
    // Actions delegated to current state
    public void insertCoin() {
        currentState.insertCoin(this);
    }

    public void pressButton() {
        currentState.pressButton(this);
    }
}

// 5. Client Code - Simulates using the machine
public class VendingMachineStatePattern {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();

        System.out.println("=== First Purchase ===");
        machine.insertCoin();    // Insert coin
        machine.pressButton();   // Dispense item

        System.out.println("\n=== Second Purchase ===");
        machine.pressButton();   // Invalid (no coin)
        machine.insertCoin();    // Insert coin
        machine.insertCoin();    // Coin already inserted
        machine.pressButton();   // Dispense item
    }
}
