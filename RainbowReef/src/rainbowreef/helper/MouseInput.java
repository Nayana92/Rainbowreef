package rainbowreef.helper;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import rainbowreef.main.Game;
import rainbowreef.main.Game.STATE;
import rainbowreef.main.PlayerStats;

public class MouseInput implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// play button

		int mousex = e.getX();
		int mousey = e.getY();

		System.out.println("mouse pressed at x:" + mousex + "y = " + mousey);

		// g2d.fill3DRect(Game.GAMEWIDTH - 200, 500, 150, 60, true);
		// play button
		if (mousex >= Game.GAMEWIDTH / 15 && mousex <= Game.GAMEWIDTH / 15 + 150) {
			if (mousey >= 525 && mousey <= 585) {
				Game.state = STATE.GAME;
			}
		}
		// help button
		else if (mousex >= Game.GAMEWIDTH / 15 + 200 && mousex <= Game.GAMEWIDTH / 15 + 350) {
			if (mousey >= 525 && mousey <= 585) {
				Game.state = STATE.HELP;
			}
			// back button
			else if (mousey >= 425 && mousey <= 485) {
				Game.state = STATE.MENU;
			}
		}
		// exit button
		else if (mousex >= Game.GAMEWIDTH / 15 + 400 && mousex <= Game.GAMEWIDTH / 15 + 550) {
			if (mousey >= 525 && mousey <= 585) {
				System.exit(1);
			}
		}
		// replay
		if (mousex >= Game.WIDTH / 3 + 100 && mousex <= Game.WIDTH / 3 + 260) {
			if (mousey > 350 && mousey < 410) {
				Game.state = STATE.REPLAY;
			}
		}
		// Scores
		else if (mousex >= Game.WIDTH / 3 + 380 && mousex <= Game.WIDTH / 3 + 550) {
			if (mousey > 350 && mousey < 410) {
				Game.state = STATE.SCORES;
			}
		}
		// back from scores
		else if (mousex >= Game.GAMEWIDTH - 90 && mousex <= Game.GAMEWIDTH + 40) {
			if (mousey > 25 && mousey < 75) {
				if (PlayerStats.isWin())
					Game.state = STATE.WIN;
				else
					Game.state = STATE.LOSE;
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

}
