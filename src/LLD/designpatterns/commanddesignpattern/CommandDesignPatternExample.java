package LLD.designpatterns.commanddesignpattern;

//RECEIVER
class Light{
    void turnOnLight(){
        System.out.println("Light Turned ON");
    }
    void  turnOffLight(){
        System.out.println("Light Turned OFF");
    }
}

interface Command{
    void execute();
}

class TurnOnLightCommand implements  Command{
    Light light ;

    public TurnOnLightCommand (Light light){
        this.light=light;
    }
    @Override
    public void execute() {
        light.turnOnLight();
    }
}

class TurnOffLightCommand implements  Command{
    Light light ;

    public TurnOffLightCommand (Light light){
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOffLight();

    }
}

// INVOKER
class Remote {
    Command command;

    public void setCommand(Command command){
        this.command = command;
    }
    public void pressButton(){
        command.execute();
    }

}

public class CommandDesignPatternExample {

    public static void main(String[] args) {
            Light light = new Light();
            Remote remote = new Remote();
            remote.setCommand(new TurnOffLightCommand(light));
            remote.pressButton();
            remote.setCommand(new TurnOnLightCommand(light));
            remote.pressButton();
    }
}
