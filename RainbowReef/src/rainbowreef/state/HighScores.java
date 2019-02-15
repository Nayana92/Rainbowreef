package rainbowreef.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import rainbowreef.main.Game;
import rainbowreef.score.MaintainScore;

public class HighScores {

	private String str[];

	public void render(Graphics g) {

		g.setFont(new Font("arial", Font.BOLD, 50));
		g.setColor(Color.DARK_GRAY);
		g.drawString("Top Scores", Game.GAMEWIDTH / 2 - 130, 100);
		Font font = new Font("arial", Font.PLAIN, 30);
		g.setFont(font);
		g.setColor(Color.LIGHT_GRAY);
		g.draw3DRect(20, 20, 640, 500, true);
		g.setColor(Color.DARK_GRAY);

		str = MaintainScore.displayScore();

		for (int i = 0; i < 5; i++) {
			String[] temp = null;
			if (str[i] != null)
				temp = str[i].split(":");
			else {
				temp = new String[] { "-", "-" };
			}
			g.drawString(temp[0], 200, 150 + i * 50);
			g.drawString(temp[1], 400, 150 + i * 50);
		}
		g.setColor(Color.GREEN);
		g.fillOval(Game.GAMEWIDTH - 90, 25, 50, 50);
		g.setColor(Color.BLACK);
		Font font2 = new Font("arial", Font.PLAIN, 40);
		g.setFont(font2);
		g.drawString("X", Game.GAMEWIDTH - 80, 65);
	}

}
