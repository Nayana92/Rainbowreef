package rainbowreef.main;

import java.awt.Canvas;

import javax.swing.JFrame;

public class Window extends Canvas {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6531263726516905691L;
	private JFrame frame;

	public Window(int width, int height, String title, Game game) {
		
		frame = new JFrame(title);
		frame.setSize(width,height);
		frame.setDefaultCloseOperation(3);
		frame.setResizable(false);
		frame.add(game);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
	}

}
