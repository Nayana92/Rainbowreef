package rainbowreef.standard;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class StandardGameObject {

	private double x;
	private double y;

	private double velX;
	private double velY;

	public StandardGameObject(double x, double y) {
		this.x = x;
		this.y = y;

	}

	public abstract void tick();

	public abstract void render(Graphics2D g);

	public abstract Rectangle getBound();

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getVelX() {
		return velX;
	}

	public double getVelY() {
		return velY;
	}

	public void setVelX(double velX) {
		this.velX = velX;
	}

	public void setVelY(double velY) {
		this.velY = velY;
	}

	public void updateX() {
		x += velX;
	}

	public void updateY() {
		y += velY;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

}
