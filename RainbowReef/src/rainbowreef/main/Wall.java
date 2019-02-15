package rainbowreef.main;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import rainbowreef.standard.StandardGameObject;

public class Wall extends StandardGameObject {
	BufferedImage image;

	public Wall(double x, double y) {
		super(x, y);
		try {
			image = ImageIO.read(this.getClass().getResource("/Wall.gif"));
		} catch (IOException e) {
			e.printStackTrace();
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
