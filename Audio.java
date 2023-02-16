import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Audio {

    public static void Sound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file = new File("C:\\Users\\Luis\\Desktop\\javasounds\\TrackTribe.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);

        clip.start();
    }
}
