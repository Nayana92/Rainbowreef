package rainbowreef.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import rainbowreef.main.Game;


public class Menu {
	private BufferedImage menuImage;
	public Menu() {
		try {
			menuImage = ImageIO.read(getClass().getResource("/menu.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void render(Graphics2D g) {
		g.drawImage(menuImage,0,0, Game.GAMEWIDTH+10, Game.GAMEHEIGHT, null);
		Font font = new Font("arial", Font.BOLD, 50);
		g.setFont(font);;
		g.setColor(Color.LIGHT_GRAY); 
		//g2d.draw3DRect(Game.GAMEWIDTH - 200, 500, 150, 60, true);
		g.fill3DRect(Game.GAMEWIDTH / 15, 525, 150, 60, true);
		g.fill3DRect(Game.GAMEWIDTH / 15 + 200, 525, 150, 60, true);
		g.fill3DRect(Game.GAMEWIDTH / 15 + 400, 525, 150, 60, true);
		g.setColor(Color.BLUE);
		g.drawString("Start", Game.GAMEWIDTH / 15 + 20, 575);
		g.drawString("Help", Game.GAMEWIDTH / 15 + 220, 575);
		g.drawString("Quit", Game.GAMEWIDTH / 15 + 425, 575);
	}
}
