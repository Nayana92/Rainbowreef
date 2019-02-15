package rainbowreef.audio;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class BackgroundMusic {
	MediaPlayer player;

	public BackgroundMusic() {
		new javafx.embed.swing.JFXPanel();
		//background sound
		String uriString = new File("res/Music.mp3").toURI().toString();
		player = new MediaPlayer(new Media(uriString));
	}
	
	public void playBackground()
	{
		player.play();
	}

}
