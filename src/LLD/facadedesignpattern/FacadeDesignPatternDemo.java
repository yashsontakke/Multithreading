package LLD.facadedesignpattern;
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
