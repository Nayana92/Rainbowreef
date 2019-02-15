package rainbowreef.main;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import rainbowreef.helper.ImageLoader;
import rainbowreef.standard.StandardGameObject;
import rainbowreef.standard.StandardHandler;

public class Paddle extends StandardGameObject implements KeyListener {

	private StandardHandler handler;
	private BufferedImage image;

	public Paddle(double x, double y, StandardHandler handler) {
		super(x, y);
		image = ImageLoader.loadImage("Katch");
		this.handler = handler;
		this.handler.addEntity(this);
	}

	public void tick() {
		updateX();

		if (getX() < 0)
			setX(0);

		if (getX() > Game.GAMEWIDTH - image.getWidth())
			setX(Game.GAMEWIDTH - image.getWidth());

	}

	public void render(Graphics2D g) {
		g.drawImage(image, (int) getX(), (int) getY(), image.getWidth(), image.getHeight(), null);
	}

	@Override
	public void keyTyped(KeyEvent e) {  

	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("Key is pressed");
		int keyPressed = e.getKeyCode();
		if (keyPressed == KeyEvent.VK_LEFT)
			setVelX(-5);
		if (keyPressed == KeyEvent.VK_RIGHT)
			setVelX(5);

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyPressed = e.getKeyCode();
		if (keyPressed == KeyEvent.VK_LEFT)
			setVelX(0);
		if (keyPressed == KeyEvent.VK_RIGHT)
			setVelX(0);

	}

	@Override
	public Rectangle getBound() {
		return new Rectangle((int) getX(), (int) getY(), image.getWidth(), image.getHeight());
	}

}
