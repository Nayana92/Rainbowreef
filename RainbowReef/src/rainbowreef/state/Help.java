package rainbowreef.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import rainbowreef.main.Game;

public class Help {
	private BufferedImage helpImage;

	public Help() {
		try {
			helpImage = ImageIO.read(this.getClass().getResource("/Background1.bmp"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void render(Graphics g) {
		g.drawImage(helpImage, 0, 0, Game.GAMEWIDTH + 10, Game.GAMEHEIGHT, null);
		Font font = new Font("arial", Font.PLAIN, 20);
		g.setFont(font);
		g.setColor(Color.LIGHT_GRAY);
		g.draw3DRect(20, 20, 650, 500, true);
		g.setColor(Color.DARK_GRAY);
		g.drawString("There will be no direct control over Pop’s movement, and he’ll bounce", 26, 50);
		g.drawString("freely around a playing area enclosed by walls on all sides except", 26, 90);
		g.drawString("the base. The left and right arrow keys will move Katch horizontally", 26, 130);
		g.drawString("along the base in order to bounce Pop from Katch’s shell and stop", 26, 170);
		g.drawString("him from falling out of the level. The collision point along Katch’s", 26, 210);
		g.drawString("shell will determine the direction of Pop’s bounce, and so the player", 26, 250);
		g.drawString("can control his movement. Bounces toward the left will send Pop left", 26, 290);
		g.drawString("and bounces toward the right will send him right. Pop’s movement is", 26, 330);
		g.drawString("also affected by gravity, and each time he collides with Katch, he gets", 26, 370);
		g.drawString("slightly faster.", 26, 410);
		g.setColor(Color.LIGHT_GRAY);
		g.fill3DRect(Game.GAMEWIDTH / 15 + 200, 425, 150, 60, true);
		g.setColor(Color.blue);
		Font font2 = new Font("arial", Font.PLAIN, 50);
		g.setFont(font2);
		g.drawString("Back", Game.GAMEWIDTH / 2 - 80, 475);
	}
}
