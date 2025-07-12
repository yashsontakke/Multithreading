package LLD.designpatterns.facadedesignpattern;


// Subsystems
class DVDPlayer {
    public void turnOn() { System.out.println("DVD Player turned on."); }
    public void play(String movie) { System.out.println("Playing movie: " + movie); }
    public void turnOff() { System.out.println("DVD Player turned off."); }
}

class SoundSystem {
    public void turnOn() { System.out.println("Sound System turned on."); }
    public void setVolume(int level) { System.out.println("Setting volume to " + level); }
    public void turnOff() { System.out.println("Sound System turned off."); }
}

class Projector {
    public void turnOn() { System.out.println("Projector turned on."); }
    public void setMode(String mode) { System.out.println("Projector set to " + mode + " mode."); }
    public void turnOff() { System.out.println("Projector turned off."); }
}

// Facade
class HomeTheaterFacade {
    private DVDPlayer dvd;
    private SoundSystem sound;
    private Projector projector;

    public HomeTheaterFacade(DVDPlayer dvd, SoundSystem sound, Projector projector) {
        this.dvd = dvd;
        this.sound = sound;
        this.projector = projector;
    }

    public void watchMovie(String movie) {
        System.out.println("\n--- Setting up Home Theater ---");
        dvd.turnOn();
        sound.turnOn();
        projector.turnOn();
        projector.setMode("Cinema");
        sound.setVolume(10);
        dvd.play(movie);
    }

    public void endMovie() {
        System.out.println("\n--- Shutting down Home Theater ---");
        dvd.turnOff();
        sound.turnOff();
        projector.turnOff();
    }
}
// Client
public class FacadeDesignPatternDemo {
    public static void main(String[] args) {
        // Creating subsystem components

        DVDPlayer dvd = new DVDPlayer();
        SoundSystem sound = new SoundSystem();
        Projector projector = new Projector();

        // Creating Facade
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvd, sound, projector);

        // Using Facade to interact with the subsystem
        homeTheater.watchMovie("Inception");
        homeTheater.endMovie();
    }
}

// The Facade Design Pattern provides a simplified, unified interface to a complex subsystem.
// It's part of the structural design patterns and is used to hide system complexity by encapsulating
// multiple interfaces into one higher-level interface.


// This pattern is useful when a system is made up of many components that need to work together,
// but exposing all of them directly to the client makes it hard to use, maintain,
// or test. A facade reduces this complexity and helps keep the client code clean and decoupled