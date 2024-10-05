package com.game.src.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.game.src.bullet.TripleShoot;
import com.game.src.enums.GameState;

public class KeyInput extends KeyAdapter{//namestiti za triple shoot
	
	private Controller c;
	private Textures tex;
	private boolean []keyDown=new boolean[4];
	private boolean isShooting=false;
	Game game;
	public static boolean tripleShoot=false;
	public static boolean singleShoot=true;
	public static String weapon="single";
	private static final int leftBulletX=-1;
	private static final int rightBulletX=1;
	public static double speed=2.5;
	public static final double MAX_SPEED=7.1;
	
	public KeyInput(Game game, Controller c,Textures tex) {
		this.game=game;
		this.c=c;
		this.tex=tex;
		
		
		keyDown[0]=false;
		keyDown[1]=false;
		
	}
	
	public void keyPressed(KeyEvent e) {
		//game.keyPressed(e);
		//
		int key = e.getKeyCode();
		System.out.println(key);
		if(game.gs==GameState.Game) {
		if(key == KeyEvent.VK_LEFT) {game.getP().setVelX(-speed); keyDown[0]=true;}
		if(key == KeyEvent.VK_RIGHT) {game.getP().setVelX(speed); keyDown[1]=true;}
		if(key == 17 && !isShooting) {
			isShooting=true;
			switch(weapon) {
			case ("single"):
				c.addEntity(new Bullet(game.getP().getX(), game.getP().getY(),tex,game,c));
				break;
			case ("triple"):
				c.addEntity(new TripleShoot(game.getP().getX(),game.getP().getY(),tex,game,c,leftBulletX));
				c.addEntity(new TripleShoot(game.getP().getX(),game.getP().getY(),tex,game,c,0));
				c.addEntity(new TripleShoot(game.getP().getX(),game.getP().getY(),tex,game,c,rightBulletX));
				break;
			default:
				break;
				
			}
//			if(singleShoot)//da ne bude sto bolina nego jedan string i switch da nadje po njemu
//				c.addEntity(new Bullet(game.getP().getX(), game.getP().getY(),tex,game,c));
//			if(tripleShoot) {
//				c.addEntity(new TripleShoot(game.getP().getX(),game.getP().getY(),tex,game,c,-4));
//				c.addEntity(new TripleShoot(game.getP().getX(),game.getP().getY(),tex,game,c,0));
//				c.addEntity(new TripleShoot(game.getP().getX(),game.getP().getY(),tex,game,c,+4));
//			}
		}
		}
		//
	}
	
	public void keyReleased(KeyEvent e) {
		int key=e.getKeyCode();
		//game.keyReleased(e);
		//
		if(game.gs==GameState.Game) {
		if(key == KeyEvent.VK_LEFT) keyDown[0]=false;
		if(key == KeyEvent.VK_RIGHT) keyDown[1]=false;
		if(key == 17) isShooting=false;
		
		if(!keyDown[0] && !keyDown[1]) game.getP().setVelX(0);
		}else if(game.gs==GameState.Menu) {
			game.menu.KeyPress(key);
		}else if(game.gs==GameState.Options) {
			game.options.KeyPress(key);
		}
		//
	}
	
	

	public boolean isTripleShoot() {
		return tripleShoot;
	}

	public void setTripleShoot(boolean tripleShoot) {
		this.tripleShoot = tripleShoot;
	}

	public boolean isSingleShoot() {
		return singleShoot;
	}

	public void setSingleShoot(boolean singleShoot) {
		this.singleShoot = singleShoot;
	}
	
	

}
