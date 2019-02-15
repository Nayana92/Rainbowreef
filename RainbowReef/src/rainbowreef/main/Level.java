package rainbowreef.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import rainbowreef.standard.StandardHandler;

public class Level {

	private BufferedReader Level;
	public int brickCount = 0;
	int width, height;
	String line;

	public Level(StandardHandler handler,int level) {

		Level = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/level"+level+".txt")));
		try {
			line = Level.readLine();
			width = line.length();
			height = 0;
			while (line != null) {
				for (int i = 0; i < width; i++) {
					char c = line.charAt(i);
					if (c > '0' && c < '8')
						handler.addEntity(new Brick(i * 20, height * 20, c));
					else if(c == 'd')
						handler.addEntity(new SpecialBrick(i*20 ,height * 20 ,'d'));
					else if(c == 'h')
						handler.addEntity(new SpecialBrick(i*20 ,height * 20 ,'h'));
					else if(c == 's')
						handler.addEntity(new SpecialBrick(i*20 ,height * 20 ,'s'));
					else if (c == 'w') 
						handler.addEntity(new Wall(i * 20, height * 20));
					else if(c == 'E')
						handler.addEntity(new Enemy(i*20 ,height * 20 ,handler,'E'));
					else if(c == 'e')
						handler.addEntity(new Enemy(i*20 ,height * 20 ,handler,'e'));

				}
				height++;
				line = Level.readLine();
			}
			Level.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//
	// this.brickCount++;
}
