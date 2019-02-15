package rainbowreef.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import rainbowreef.helper.ImageLoader;

public class PlayerStats {

	public static int LIVES = 3;
	private int lives;
	private int score;
	private static boolean win;
	private Font font;
	BufferedImage life = null;

	public PlayerStats() {
		refreshStats();
	}

	public void updateScore(int score) {
		this.score += score;
	}

	public void updateLife(String update) {
		if (update.equals("add"))
			lives++;
		else if (update.equals("remove")) {
			lives--;
		}
	}

	public int getScore() {
		return score;
	}

	public int getLives() {
		return lives;
	}

	public static boolean isWin() {
		return win;
	}
	
	public void setWin(boolean win) {
		this.win = win;
	}

	public void render(Graphics g) {
		int x = 5,y = 570;
		g.setFont(font);
		g.setColor(Color.BLUE);
		g.drawString("Score:" + score, x+10, y );
		for(int i = 0 ; i < lives; i++) {
			g.drawImage(life ,i + x, y+20,life.getWidth(),life.getHeight(),null );
			x += life.getWidth();
		}
	}
	
	public void refreshStats() {
		lives = LIVES;
		score = 0;
		win = false;
		life = ImageLoader.loadImage("Katch_small");
		font = new Font("arial", Font.PLAIN, 20);
	}

}
