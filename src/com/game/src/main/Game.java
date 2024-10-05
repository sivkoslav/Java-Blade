package com.game.src.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;

import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

import com.game.src.audio.AudioPlayer;
import com.game.src.enums.GameState;
import com.game.src.hud.HUD;
import com.game.src.main.classes.EntityA;
import com.game.src.main.classes.EntityB;
import com.game.src.main.classes.EntityC;
import com.game.src.ui.MenuHandler;
import com.game.src.ui.OptionHandler;


public class Game extends Canvas implements Runnable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 320;//sirina
	public static final int HEIGHT = WIDTH/12 *9;//visina ekrana
	public static final int SCALE=2;
	public final String TITLE = "Java Warblade";
	
	private boolean running=false;
	private Thread thread;
	
	
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT,BufferedImage.TYPE_INT_RGB);
	private BufferedImage spriteSheet=null;
	private BufferedImage background = null;
	private BufferedImage background2 = null;
	private BufferedImage flyingSaucerSpriteSheet=null;
	private BufferedImage motherSpriteSheet=null;
	
	private boolean isShooting=false;
	
	private Player p;
	private Controller c;
	private Textures tex;
	Enemy e;
	private EnemySpawner spawner;
	private HUD hud;
	
	public LinkedList<EntityA> ea;
	public LinkedList<EntityB> eb;
	public LinkedList<EntityC> ec;
	
	
	private int enemyCount=18;
	private int enemyRemaining=0;
	private int enemyKilled=0;
	private int level=1;
	private double timerForSaucer=0;
	private int enemyMotherDeaths=0;
	
	public GameState gs=GameState.Menu;
	public MenuHandler menu;
	public OptionHandler options;
	
	public void init() {
		requestFocus();
		BufferedImageLoader loader=new BufferedImageLoader();
		try {
			spriteSheet = loader.loadImage("/sprite_SheetA.png");
			flyingSaucerSpriteSheet = loader.loadImage("/Flying SaucerFinal.png");
			background=loader.loadImage("/background.png");
			background2=loader.loadImage("/galaxy.png");
			motherSpriteSheet=loader.loadImage("/MotherSpriteSheet.png");
		}catch(IOException e) {
			
		}
		menu=new MenuHandler(this);
		options=new OptionHandler(this);
		AudioPlayer.loadSounds();
		
		AudioPlayer.getMusic("backgroundmusic").loop();
	
		
		
		tex=new Textures(this);
		
		hud = new HUD(tex);
		c = new Controller(tex,this, hud);
		p = new Player(300,420,tex,this,c, hud);
		spawner=new EnemySpawner(c,this);
		
		ea=c.getEntityA();
		eb=c.getEntityB();
		ec=c.getEntityC();
		
		this.addKeyListener(new KeyInput(this,c,tex));
		
		c.spawnEnemy(enemyCount);// dodavaje neprijatelja
		
		
		
		
	}
	
	private synchronized void start() {
		if(running)
			return;
		
		running=true;
		thread=new Thread(this);
		thread.start();
	}
	
	private synchronized void stop() {
		if(!running)
			return;
		
		running=false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(1);
	}
	

	
	
	
	
	@Override
	public void run() {//ovde je game loop
		init();
		long lastTime = System.nanoTime();
		final double amountOfTicks = 60.0;
		double ns = 1_000_000_000 / amountOfTicks;
		double delta = 0;
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();
		
		
		while(running) {
			long now = System.nanoTime();
			delta+=(now-lastTime) / ns;
			lastTime = now;
			if(delta>=1) {
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer+=1000;
				System.out.println(updates + " Ticks, Fps " + frames);
				updates=0;
				frames=0;
			}
		}
		stop();
		
	}
	
	private void tick() {//sve sto se updejtuje
		
		if(gs==GameState.Game) {
			p.tick();
			c.tick();
			spawner.tick();
			hud.tick();
		}
		
		if(gs==GameState.Menu) menu.tick();
		if(gs==GameState.Options) options.tick();
		
		
		
		
		
		
	}
	
	private void render() {//sve sto se renderuje
		
		BufferStrategy bs = this.getBufferStrategy();
		
		
		if(bs == null) {
			createBufferStrategy(3);//imamo tri bufera
			return;
		}
		
		Graphics g =bs.getDrawGraphics();//pravi kontekst za crtanje grafike
		
		/////////////////////////////////
		//ovde crtamo izmedju g i dispose
		g.drawImage(image, 0, 0, getWidth(), getHeight(),this);
		g.drawImage(background2, 0, 0,null);
		
		
		if(gs==GameState.Game) {
			p.render(g);
			c.render(g);
			hud.render(g);
		}
		
		if(gs==GameState.Menu) menu.render(g);
		
		if(gs==GameState.Options) options.render(g);
		
		
		/////////////////////////////////
		
		g.dispose();
		bs.show();
		
		
	}
	
	public BufferedImage getSpriteSheet() {
		return spriteSheet;
	}
	
	public BufferedImage getSaucerSpriteSheet() {
		return flyingSaucerSpriteSheet;
	}
	
	public BufferedImage getMotherSpriteSheet() {
		return motherSpriteSheet;
	}
	
	
	
	
	
	
	
	public int getEnemyCount() {
		return enemyCount;
	}

	public void setEnemyCount(int enemyCount) {
		this.enemyCount = enemyCount;
	}

	public int getEnemyKilled() {
		return enemyKilled;
	}

	public void setEnemyKilled(int enemyKilled) {
		this.enemyKilled = enemyKilled;
	}
	
	

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getEnemyMotherDeaths() {
		return enemyMotherDeaths;
	}
	
	public void setEnemyMotherDeaths(int enemyMotherDeaths) {
		this.enemyMotherDeaths=enemyMotherDeaths;
	}
	
	
	
	

	public Player getP() {
		return p;
	}

	public static void main(String[] args) {
		Game game = new Game();
		
		game.setPreferredSize(new Dimension(WIDTH * SCALE,HEIGHT*SCALE));//postavljanje dimenzije ekrana
		game.setMaximumSize(new Dimension(WIDTH * SCALE,HEIGHT*SCALE));//maks i min dimenzija
		game.setMinimumSize(new Dimension(WIDTH * SCALE,HEIGHT*SCALE));
		
		JFrame frame = new JFrame(game.TITLE);
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setFocusable(true);
		
		game.start();
	}

}
