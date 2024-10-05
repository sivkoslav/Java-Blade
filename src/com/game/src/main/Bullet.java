package com.game.src.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.game.src.main.classes.EntityA;

public class Bullet extends GameObject implements EntityA{
	
	
	
	private Textures tex; // staviti da kad metak pogodi neprijatelja da nestane a ne da produzi dalje
	private Game game;
	Controller c;
	private boolean singleBullet=true;
	private boolean tripleBullet=false;
	
	public Bullet(double x, double y,Textures tex, Game game, Controller c) {
		super(x,y);
		this.tex=tex;
		this.game=game;
		this.c=c;
		
		
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int) y, 32,32);
	}
	
	public void tick() {
		
		y-=10;
		
		
		if(Physics.Collision(this,game.eb)) {
			System.out.println("collision sa enemy");//ovde proveriti da ako je metak sa raketom ne bude nista nego tek kad mene pogodi avion
			//c.removeEntity(this);
		}
		
		//if(y>Game.HEIGHT) c.removeEntity(this);
	}
	
	public void render(Graphics g) {
		if(singleBullet)
			g.drawImage(tex.bufferedImageArray[8],(int) x,(int) y, null);
		
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public boolean isSingleBullet() {
		return singleBullet;
	}

	public void setSingleBullet(boolean singleBullet) {
		this.singleBullet = singleBullet;
	}

	public boolean isTripleBullet() {
		return tripleBullet;
	}

	public void setTripleBullet(boolean tripleBullet) {
		this.tripleBullet = tripleBullet;
	}
	
	
	
	
	
	

}
