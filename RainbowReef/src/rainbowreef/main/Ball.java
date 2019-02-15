package rainbowreef.main;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import rainbowreef.helper.ImageLoader;
import rainbowreef.standard.StandardGameObject;
import rainbowreef.standard.StandardHandler;

public class Ball extends StandardGameObject {

	private StandardHandler handler;
	private boolean addFlag;
	private int angle;
	private int count;
	private BufferedImage image;

	public Ball(double x, double y, StandardHandler handler) {
		super(x, y);
		image = ImageLoader.loadImage("pop");

		setVelY(Game.SPEED);
		setVelX(0);

		this.handler = handler;
		handler.addBallEntitiy(this);
		addFlag = false;
		count = 0;
		angle = 0;
	}

	@Override
	public void tick() {

		count++;
		updateX();
		updateY();
		if (getX() < 0 || getX() >= Game.GAMEWIDTH - image.getWidth())
			setVelX(-getVelX());

		if (getY() < 0)
			setVelY(-getVelY());

		if (getY() > Game.GAMEHEIGHT + image.getHeight()) {
			handler.removeBallObject(this);
			addFlag = true;
		}

	}

	@Override
	public void render(Graphics2D g) {
		if (count % 15 == 0)
			angle = angle + 5;

		AffineTransform transform = AffineTransform.getTranslateInstance(getX(), getY());
		transform.rotate(Math.toRadians(angle), image.getWidth() / 2, image.getHeight() / 2);
		Graphics2D graphic2D = (Graphics2D) g;
		graphic2D.drawImage(image, transform, null);
	}

	public boolean isAddFlag() {
		return addFlag;
	}

	@Override
	public Rectangle getBound() {
		return new Rectangle((int) getX(), (int) getY(), image.getWidth(),image.getHeight());
	}
}
