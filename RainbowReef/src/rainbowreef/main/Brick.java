package rainbowreef.main;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import rainbowreef.helper.ImageLoader;
import rainbowreef.standard.StandardGameObject;

public class Brick extends StandardGameObject {

	BufferedImage image;

	public Brick(double x, double y, char color) {
		super(x, y);
		switch (color) {
		case '1':
			image = ImageLoader.loadImage("Block1");
			break;
		case '2':
			image = ImageLoader.loadImage("Block2");
			break;
		case '3':
			image = ImageLoader.loadImage("Block3");
			break;
		case '4':
			image = ImageLoader.loadImage("Block4");
			break;
		case '5':
			image = ImageLoader.loadImage("Block5");
			break;
		case '6':
			image = ImageLoader.loadImage("Block6");
			break;
		case '7':
			image = ImageLoader.loadImage("Block7");
			break;
		default:
			image = null;
			break;

		}
	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics2D g) {
		g.drawImage(image, (int) getX(), (int) getY(), image.getWidth(), image.getHeight(), null);

	}

	@Override
	public Rectangle getBound() {
		return new Rectangle((int) getX(), (int) getY(), image.getWidth(), image.getHeight());
	}

}
