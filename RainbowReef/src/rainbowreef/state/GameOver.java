package rainbowreef.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import rainbowreef.main.Game;
import rainbowreef.main.Game.STATE;

public class GameOver {
	private BufferedImage congratsImage, loseImage;
	private Game game;
	public GameOver(Game game) {
		 this.game = game;
		try {
			congratsImage = ImageIO.read(getClass().getResource("/Congratulation.png"));
			loseImage = ImageIO.read(getClass().getResource("/Background1.bmp"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void render(Graphics2D g) {
		g.clearRect(0, 0, Game.GAMEWIDTH+10, Game.GAMEHEIGHT / 2);
		g.drawImage(loseImage,0, 0, Game.GAMEWIDTH+10, Game.GAMEHEIGHT,null);
		if(game.isWin() == STATE.WIN) {
			g.setColor(Color.BLUE);
			g.setFont(new Font("arial", Font.BOLD, 50));
			g.drawString("CONGRATULATIONS!!", Game.WIDTH / 3 + 80, 200);
		}else if(game.isWin() == STATE.LOSE) {
			g.setColor(Color.BLUE);
			g.setFont(new Font("arial", Font.BOLD, 50));
			g.drawString("Good Luck Next Time!", Game.WIDTH / 3 + 80, 200);
		}
		g.setColor(Color.blue); 
		g.setFont(new Font("arial", Font.PLAIN, 50));
		g.drawString("Your Score:" + game.getScore(), Game.WIDTH/3 + 170, 300);
		
		g.setColor(Color.LIGHT_GRAY); 
		g.fill3DRect(Game.WIDTH/3 + 100, 350, 160, 60, true);
		g.fill3DRect(Game.WIDTH/3 + 380, 350, 170, 60, true);
		g.setColor(Color.BLUE);
		g.drawString("Replay", Game.WIDTH/3 + 100, 400);
		g.drawString("Scores", Game.WIDTH/3 + 390, 400);
 
	}
}
