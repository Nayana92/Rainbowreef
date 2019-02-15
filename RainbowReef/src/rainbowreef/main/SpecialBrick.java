package rainbowreef.main;

import rainbowreef.helper.ImageLoader;

public class SpecialBrick extends Brick {
	private char type;

	public SpecialBrick(double x, double y, char color) {
		super(x, y, color);
		type = color;
			switch (type) {
			case 'd':
				image = ImageLoader.loadImage("Block_double");
				break;
			case 'h':
				image = ImageLoader.loadImage("Block_life");
				break;
			case 's':
				image = ImageLoader.loadImage("Block_split");
				break;
			}
	}

	public char getType() {
		return type;
	}

}
