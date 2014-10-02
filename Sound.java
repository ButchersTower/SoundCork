package soundCork;

import java.applet.AudioClip;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	AudioClip[] clips;

	void initSounds() {
		clips = new AudioClip[4];
		clips[0] = java.applet.Applet.newAudioClip(Sound.class
				.getResource("res/PatricEdit.wav"));
		clips[1] = java.applet.Applet.newAudioClip(Sound.class
				.getResource("res/DedotatedWam.wav"));
		clips[2] = java.applet.Applet.newAudioClip(Sound.class
				.getResource("res/HeyYouGuys.wav"));
		clips[3] = java.applet.Applet.newAudioClip(Sound.class
				.getResource("res/FailureToComunicay.wav"));
	}

	ArrayList<AudioClip> wavs = new ArrayList<AudioClip>();

	void playSound(int wavNum) {
		if (wavNum == 0) {
			wavs.add(java.applet.Applet.newAudioClip(this.getClass()
					.getResource("res/PatricEdit.wav")));
			wavs.get(wavs.size() - 1).play();
		} else if (wavNum == 1) {
			wavs.add(java.applet.Applet.newAudioClip(this.getClass()
					.getResource("res/DedotatedWam.wav")));
			wavs.get(wavs.size() - 1).play();
		} else if (wavNum == 2) {
			wavs.add(java.applet.Applet.newAudioClip(this.getClass()
					.getResource("res/HeyYouGuys.wav")));
			wavs.get(wavs.size() - 1).play();
		} else if (wavNum == 3) {
			wavs.add(java.applet.Applet.newAudioClip(this.getClass()
					.getResource("res/FailureToComunicay.wav")));
			wavs.get(wavs.size() - 1).play();
		}

	}

	void dedWam() {
		try {
			java.applet.AudioClip clip = java.applet.Applet.newAudioClip(this
					.getClass().getResource("res/DedotatedWam.wav"));
			clip.play();
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}

	}

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
