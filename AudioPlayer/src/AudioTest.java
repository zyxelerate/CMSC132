import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
 
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class AudioTest {
    public static void main(String[] args) throws Exception
    {
        String filename = "C:\\Users\\Asus\\Documents\\NetBeansProjects\\AudioPlayer\\media\\audio.wav";
 
        InputStream in = new FileInputStream(new File(filename));
        AudioStream audioStream = new AudioStream(in);
        AudioPlayer.player.start(audioStream);
    }
}
