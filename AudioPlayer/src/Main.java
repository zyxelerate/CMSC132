import java.io.*;
import java.lang.management.*;
import java.net.MalformedURLException;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Main extends Application {

	private static final String TEXT = "C:\\Users\\Asus\\eclipse-workspace\\CMSC132Lab1\\src\\text.txt";
        
	public static void main(String[] args) throws Exception {
		long startTime;
		long endTime;
		long duration;
                
               //while (true){
                    System.out.println("1. Read Text File");
                    System.out.println("2. Read Audio File");
                    System.out.println("3. Read Video File");
                    System.out.print("Enter your Choice:");
                    Scanner sc = new Scanner(System.in);
                    int choice = sc.nextInt();
                    if (choice == 1){
                        startTime = System.nanoTime();
                        reader(TEXT);
                        endTime = System.nanoTime();
                        duration = (endTime - startTime);
                        System.out.println("Text Running Time in nanoseconds:" + duration);
                        System.out.println("Text CPU Time in nanoseconds:" + getCpuTime());
                        //break;
                    } else if (choice == 2){
                        startTime = System.nanoTime();
                        String filename = "C:\\Users\\Asus\\Documents\\NetBeansProjects\\AudioPlayer\\media\\audio2.wav";
                        InputStream in = new FileInputStream(new File(filename));
                        AudioStream audioStream = new AudioStream(in);
                        AudioPlayer.player.start(audioStream);
                        endTime = System.nanoTime();
                        duration = (endTime - startTime);
                        System.out.println("Audio Running Time in nanoseconds:" + duration);
                        System.out.println("Audio CPU Time in nanoseconds:" + getCpuTime());
                        //break;
                    } else if (choice == 3){
                        startTime = System.nanoTime();
                        Application.launch(args);
                        endTime = System.nanoTime();
                        duration = (endTime - startTime);
                        System.out.println("Video Running Time in nanoseconds:" + duration);
                        System.out.println("Video CPU Time in nanoseconds:" + getCpuTime());
                        //break;
                    } //else{
//                        System.out.println("Invalid choice");
//                    }
//                }
                
                
	}

	public static void reader(String FileName) {
		try (BufferedReader br = new BufferedReader(new FileReader(FileName))) {

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}
                        br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}    
	}
	
	/** Get CPU time in nanoseconds. */
	public static long getCpuTime() {
	    ThreadMXBean bean = ManagementFactory.getThreadMXBean();
	    return bean.isCurrentThreadCpuTimeSupported() ?
	        bean.getCurrentThreadCpuTime() : 0L;
	}
        
        //Video Player
        @Override
        public void start(Stage primaryStage){
            String workingDir = System.getProperty("user.dir");
            File f = new File(workingDir, "/media/video.mp4");

            Media m = new Media(f.toURI().toString());
            MediaPlayer mp = new MediaPlayer(m);
            MediaView mv = new MediaView(mp);

            StackPane root = new StackPane();
            root.getChildren().add(mv);

            primaryStage.setScene(new Scene(root, 540, 360));
            primaryStage.setTitle("Dog of Wisdom");
            primaryStage.show();

            mp.play();
        }
}