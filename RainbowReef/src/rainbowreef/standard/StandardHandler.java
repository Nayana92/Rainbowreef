package rainbowreef.standard;

import java.awt.Graphics2D;
import java.util.ArrayList;

import rainbowreef.audio.AdditionalMusic;
import rainbowreef.main.Ball;
import rainbowreef.main.Brick;
import rainbowreef.main.Enemy;
import rainbowreef.main.Game;
import rainbowreef.main.Paddle;
import rainbowreef.main.PlayerStats;
import rainbowreef.main.SpecialBrick;
import rainbowreef.main.Wall;

public class StandardHandler {

	private ArrayList<StandardGameObject> entities;
	private ArrayList<StandardGameObject> balls;
	private int count = 0;
	PlayerStats stats;
	private AdditionalMusic music;
	

	public StandardHandler(PlayerStats stats) {
		entities = new ArrayList<StandardGameObject>();
		balls = new ArrayList<StandardGameObject>();
		this.stats = stats;
		music = new AdditionalMusic();
	}

	public void tick() {
		for (int i = 0; i < balls.size(); i++) {
			for (int j = 0; j < entities.size(); j++) {
				// ball and player collision
				if (entities.get(j) instanceof Paddle) {
					// collision detection
					if (entities.get(j).getBound().intersects(balls.get(i).getBound())) {
						if (Game.SPEED < 4)
							Game.SPEED = 0.2f + Game.SPEED;
						if (balls.get(i).getX() - entities.get(j).getX() < 27) {
							if (balls.get(i).getVelX() >= 0) {
								balls.get(i).setVelX(-Game.SPEED);
							}
						} else if (balls.get(i).getX() - entities.get(j).getX() > 48) {
							if (balls.get(i).getVelX() <= 0) {
								balls.get(i).setVelX(Game.SPEED);
							}
						} else {
							balls.get(i).setVelX(0);
						}
						music.playmusic("/Sound_click.wav");
						balls.get(i).setVelY(-Game.SPEED);
					} 
				}
				// ball and brick collision
				if (entities.get(j) instanceof Brick) {
					if (entities.get(j).getBound().intersects(balls.get(i).getBound())) {
						if (entities.get(j) instanceof SpecialBrick) {
							SpecialBrick temp = (SpecialBrick) entities.get(j);
							// double block collision
							if (temp.getType() == 'd') {
								stats.updateScore(5);
								entities.add(j + 1, new Brick(entities.get(j).getX(), entities.get(j).getY(), '1'));
							}
							// lives block collision
							else if (temp.getType() == 'h') {
								stats.updateLife("add");
							}
							// split block collision
							else if (temp.getType() == 's') {
								for (int k = 0; k < 2; k++)
									balls.add(new Ball(entities.get(j).getX() + k*5, entities.get(i).getY(), this));
							}

						}
						// block collision
						music.playmusic("/Sound_block.wav");
						stats.updateScore(5);
						entities.remove(j);
						j--;

						balls.get(i).setVelY(-balls.get(i).getVelY());
						break;
					}

				}
				// ball and wall collision
				if (entities.get(j) instanceof Wall) {
					if (entities.get(j).getBound().intersects(balls.get(i).getBound())) {
						music.playmusic("/Sound_wall.wav");
						balls.get(i).setVelY(-balls.get(i).getVelY());
						balls.get(i).setVelX(-balls.get(i).getVelX());
					}
				}
				// ball and enemy collision
				if (entities.get(j) instanceof Enemy) {
					if (entities.get(j).getBound().intersects(balls.get(i).getBound())) {
						music.playmusic("/Sound_bigleg.wav");
						entities.remove(j);
						j--;
						count--;
						balls.get(i).setVelY(-balls.get(i).getVelY());
						balls.get(i).setVelX(-balls.get(i).getVelX());
						break;
					}
				}
				if (j >= 0)
					entities.get(j).tick();
			}
			balls.get(i).tick();
		}
		// enemy wall collision
		for (int i = 0; i < entities.size(); i++) {
			if (entities.get(i) instanceof Enemy) {
				for (int j = 0; j < entities.size(); j++) {
					if (entities.get(j) instanceof Wall) {
						if (entities.get(i).getBound().intersects(entities.get(j).getBound()))
							entities.get(i).setVelX(-entities.get(i).getVelX());
					}
				}
			}
		}
	}

	public void render(Graphics2D g) {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(g);
		}
		for (int i = 0; i < balls.size(); i++) {
			balls.get(i).render(g);
		}
	}

	public void addEntity(StandardGameObject object) {
		entities.add(object);
	}

	public void addBallEntitiy(StandardGameObject object) {
		music.playmusic("/Sound_lost.wav");
		balls.add(object);
	}

	public void removeEntity(StandardGameObject object) {
		for (int i = 0; i < entities.size(); i++)
			if (object == entities.get(i)) {
				entities.remove(i);
				i--;
			}
	}

	public void removeObject(StandardGameObject object) {
		entities.remove(object);
	}

	public void removeBallObject(StandardGameObject object) {
		balls.remove(object);
	}

	public int getCount() {
		return count;
	}

	public void updateCount() {
		count++;
	}

	// initialize the handler for new level
	public void flush() {
		count = 0;
		entities.clear();
		balls.clear();

	}

}
