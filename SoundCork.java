package soundCork;

//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

public class SoundCork extends JFrame {
	public SoundCork() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new Panel());
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setTitle("SoundCork");
	}

	public static void main(String[] args) {
		new SoundCork();

	}

	// String bip = "bip.mp3";
	// Media hit = new Media(bip);
	// MediaPlayer mediaPlayer = new MediaPlayer(hit);
	// mediaPlayer.play();

	void test1() {
		try {
			System.out.println("here1");
			AudioInputStream audioIn = AudioSystem
					.getAudioInputStream(SoundCork.class
							.getResource("res/PatricEdit.wav"));
			System.out.println("1");
			Clip clip = AudioSystem.getClip();
			System.out.println("2");
			clip.open(audioIn);
			System.out.println("3");
			clip.start();
			System.out.println("here");
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}

	void test2() {
		try {
			java.applet.AudioClip clip = java.applet.Applet.newAudioClip(this
					.getClass().getResource("res/PatricEdit.wav"));
			clip.play();
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		System.out.println("end");
	}

}
