package rainbowreef.helper;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
	public static BufferedImage loadImage(String item) {
		switch (item) {
		case "pop":
			try {
				return ImageIO.read(ImageLoader.class.getResource("/Pop.gif"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		case "Block1":
			try {
				return ImageIO.read(ImageLoader.class.getResource("/Block1.gif"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		case "Block2":
			try {
				return ImageIO.read(ImageLoader.class.getResource("/Block2.gif"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		case "Block3":
			try {
				return ImageIO.read(ImageLoader.class.getResource("/Block3.gif"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		case "Block4":
			try {
				return ImageIO.read(ImageLoader.class.getResource("/Block4.gif"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		case "Block5":
			try {
				return ImageIO.read(ImageLoader.class.getResource("/Block5.gif"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		case "Block6":
			try {
				return ImageIO.read(ImageLoader.class.getResource("/Block6.gif"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		case "Block7":
			try {
				return ImageIO.read(ImageLoader.class.getResource("/Block7.gif"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		case "Block_double":
			try {
				return ImageIO.read(ImageLoader.class.getResource("/Block_double.gif"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		case "Block_life":
			try {
				return ImageIO.read(ImageLoader.class.getResource("/Block_life.gif"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		case "Block_split":
			try {
				return ImageIO.read(ImageLoader.class.getResource("/Block_split.gif"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		case "Bigleg":
			try {
				return ImageIO.read(ImageLoader.class.getResource("/Bigleg.gif"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		case "Bigleg_small":
			try {
				return ImageIO.read(ImageLoader.class.getResource("/Bigleg_small.gif"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		case "Katch":
			try {
				return ImageIO.read(ImageLoader.class.getResource("/Katch.gif"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		case "Katch_small":
			try {
				return ImageIO.read(ImageLoader.class.getResource("/Katch_small.gif"));
			} catch (IOException e) {
				e.printStackTrace();
			}

		default:
			return null;

		}
	}
}
