package com.game.src.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.game.src.main.classes.EntityA;
import com.game.src.main.classes.EntityB;

public class EnemyBullet extends GameObject implements EntityB{
	
	
	
	private Textures tex;
	private Game game;
	private Controller c;
	
	public EnemyBullet(double x, double y,Textures tex, Game game, Controller c) {
		super(x,y);
		this.tex=tex;
		this.game=game;
		this.c=c;
		
		
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int) y, 32,32);
	}
	
	public void tick() {
		y+=5;
		
		
//		if(Physics.Collision(this,game.eb )) {
//			System.out.println("COLLISION DETECTED");
//		}
		
		if(y>600)
			c.removeEntity(this);
			
	}
	
	public void render(Graphics g) {
		g.drawImage(tex.missile,(int) x,(int) y, null);
		
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	
	
	

}
