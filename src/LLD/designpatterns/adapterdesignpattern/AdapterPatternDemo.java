package LLD.designpatterns.adapterdesignpattern;
// ✅ Adapter Pattern Example with Comments for Interview Preparation

// 🎯 Target Interface: This is what the client expects to work with
interface MediaPlayer {
    void play(String filename);
}

// ⚠️ Adaptee (Legacy Code):
// This class provides an interface (method playFile) that is INCOMPATIBLE
// with what the client expects. The public method(s) of this class form
// the "incompatible interface" (not just a single method).
class LegacyMediaPlayer {
    void playFile(String filePath) {
        System.out.println("Playing file (legacy): " + filePath);
    }
}

// 🔌 Adapter:
// This class bridges the gap between the client's expected interface (MediaPlayer)
// and the legacy system (LegacyMediaPlayer).
// It implements the Target interface and internally uses an instance of the Adaptee.
class MediaAdapter implements MediaPlayer {

    private LegacyMediaPlayer legacyPlayer = new LegacyMediaPlayer();

    @Override
    public void play(String filename) {
        // 🎯 This is where the adaptation happens:
        // We convert the expected method call into a format understood by the legacy system.
        legacyPlayer.playFile(filename);
    }
}

// 👨‍💻 Client Code:
// Works only with the MediaPlayer interface and is unaware of any legacy system.
public class AdapterPatternDemo {
    public static void main(String[] args) {
        MediaPlayer player = new MediaAdapter();
        player.play("song.mp3");
    }
}

/*
🔍 KEY TAKEAWAYS / NOTES:

1. The "incompatible interface" refers to the public methods of the legacy class,
   which do not match the expected interface of the client — not just a single method.
   interface means methods inside legacy class and adapter class *****  not a keyword in java *****

2. Adapter Pattern helps integrate legacy code into new systems without modifying
   the legacy code itself — maintaining the Open/Closed Principle (from SOLID).

3. It can also include additional logic (e.g., transformation, validation) while adapting.

4. Think of Adapter Pattern as a power socket adapter — converting one plug shape (legacy)
   into another (modern) so that the device (client) can work without knowing the difference.

5. The Adapter implements the interface the client needs (Target),
   and internally delegates calls to the legacy object (Adaptee).

*/
