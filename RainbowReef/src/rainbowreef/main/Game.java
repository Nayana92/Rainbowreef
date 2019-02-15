package rainbowreef.main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import rainbowreef.audio.BackgroundMusic;
import rainbowreef.helper.MouseInput;
import rainbowreef.score.MaintainScore;
import rainbowreef.standard.StandardHandler;
import rainbowreef.state.GameOver;
import rainbowreef.state.Help;
import rainbowreef.state.HighScores;
import rainbowreef.state.Menu;

public class Game extends Canvas implements Runnable {

	public static int GAMEWIDTH = 685;
	public static int GAMEHEIGHT = 635;
	public static final int TOTALLEVEL = 3;

	public static float SPEED;

	private Thread thread;
	private boolean isRunning = false;
	public static Window window;
	private Menu menu;
	private Help help;
	private HighScores highscore;
	private GameOver gameOver;

	private PlayerStats stats;
	private StandardHandler handler;
	private Paddle paddle;
	private Ball ball;
	private int level = 1;
	private BackgroundMusic music;
	private MaintainScore scoresheet;

	private boolean replay = false;

	private BufferStrategy bs;
	private static Graphics g;
	private BufferedImage GameWorld;

	public Game(int width, int height) {
		this.window = new Window(width, height, "Rainbow Reef", this);
		stats = new PlayerStats();
		handler = new StandardHandler(stats);
		menu = new Menu();
		gameOver = new GameOver(this);
		help = new Help();
		music = new BackgroundMusic();

		// loadLevel();
		this.start();
		requestFocus();
		try {
			GameWorld = ImageIO.read(this.getClass().getResource("/Background1.bmp"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.addMouseListener(new MouseInput());

	}

	public static enum STATE {
		MENU, GAME,GAMEOVER, LOSE, WIN, HELP, REPLAY,SCORES

	};

	public static STATE state = STATE.MENU;

	private synchronized void start() {
		if (isRunning)
			return;
		else {
			this.isRunning = true;
			thread = new Thread(this);
			thread.start();
		}
	}

	private synchronized void stop() {
		if (!isRunning)
			return;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.isRunning = false;
		System.exit(0);
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while (isRunning) {
			music.playBackground();
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick(now - lastTime);
				updates++;
				delta--;
			}
			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames + " TICKS: " + updates);
				frames = 0;
				updates = 0;
			}
		}
		this.stop();

	}

	private void loadLevel() {
		handler.flush();
		new Level(handler, level++);
		SPEED = 3;
		paddle = new Paddle(318, 580, handler);
		ball = new Ball(368, 480, handler);
		addKeyListener(paddle);
	}

	private void tick(long l) {
		if (state == STATE.REPLAY) {
			level = 1;
			stats.refreshStats();
			state = STATE.GAME;
			replay = true;

		}
		if (state == STATE.GAME) {
			if (handler.getCount() == 0) {
				if (level <= TOTALLEVEL)
					loadLevel();
				else {
					handler.flush();
					state = STATE.WIN;
					stats.setWin(true);
					GameOver();
				}

			}

			if (ball.isAddFlag() && stats.getLives() > 0 && state != STATE.WIN) {
				ball = new Ball(paddle.getX(), paddle.getY()-50, handler);
				stats.updateLife("remove");
			} else if (stats.getLives() == 0) {
				state = STATE.LOSE;
				handler.flush();
				GameOver();
			}
			handler.tick();
		}
	}

	public void GameOver() {
		scoresheet = new MaintainScore();
		String score = null;
		if ((state == STATE.WIN || state == STATE.LOSE) && (replay == false)) {
			String name = JOptionPane.showInputDialog("Your Score : " + getScore() + "\n\n Player name:");
			score = name + ":" + getScore();
		}
		if (replay) {
			score = scoresheet.getHighScore().split(":")[0] + ":" + getScore();
		}

		scoresheet.setScore(score);
		if(highscore == null)
		highscore = new HighScores();
	}

	private void render() {
		bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		Graphics2D graphics = (Graphics2D) g;
		// draw here
		g.clearRect(0, 0, GAMEWIDTH, GAMEHEIGHT);
		g.drawImage(GameWorld, 0, 0, GAMEWIDTH, GAMEHEIGHT, null);
		if (state == STATE.GAME) {
			handler.render(graphics);
			stats.render(graphics);
			// graphics.dispose();
		} else if (state == STATE.MENU) {
			menu.render(graphics);
		} else if (state == STATE.WIN) {
			gameOver.render(graphics);
		} else if (state == STATE.LOSE) {
			gameOver.render(graphics);
		} else if (state == STATE.HELP) {
			help.render(graphics);
		}else if (state == STATE.SCORES) {
			highscore.render(graphics);
		}
		
		graphics.dispose();
		g.dispose();
		bs.show();

	}

	public int getScore() {
		return stats.getScore();
	}

	public STATE isWin() {
		return state;
	}

	public static void main(String[] args) {
		new Game(GAMEWIDTH, GAMEHEIGHT);
	}

}
