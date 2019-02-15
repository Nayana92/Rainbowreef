package rainbowreef.audio;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AdditionalMusic {
	private Clip clip;

	public void playmusic(String soundFileName) {
		URL url = this.getClass().getResource(soundFileName);
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
		} catch (UnsupportedAudioFileException | IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		if (clip.isRunning())
			clip.stop();
		clip.setFramePosition(0);
		clip.start();
	}

}
