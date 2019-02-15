package rainbowreef.main;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import rainbowreef.helper.ImageLoader;
import rainbowreef.standard.StandardGameObject;
import rainbowreef.standard.StandardHandler;

public class Enemy extends StandardGameObject {

	private boolean move = false;
	private BufferedImage image;

	public Enemy(double x, double y, StandardHandler handler, char c) {
		super(x, y);
		if (c == 'E')
			image = ImageLoader.loadImage("Bigleg");
		else if (c == 'e') {
			image = ImageLoader.loadImage("Bigleg_small");
			move = true;
			setVelX(2);
		}
		handler.updateCount();
	}

	@Override
	public void tick() {
		if (move == true) {
			updateX();
		}
		if (getX() < 0 || getX() >= Game.GAMEWIDTH - image.getWidth())
			setVelX(-getVelX());
	}

	@Override
	public void render(Graphics2D g) {
		g.drawImage(image, (int) getX(), (int) getY(), image.getWidth(), image.getHeight(), null);

	}

	public boolean isMove() {
		return move;
	}

	@Override
	public Rectangle getBound() {
		return new Rectangle((int) getX(), (int) getY(), image.getWidth(), image.getHeight());
	}

}
