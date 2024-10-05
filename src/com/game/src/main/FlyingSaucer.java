package com.game.src.main;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.game.src.main.classes.EntityB;
import java.util.*;

public class FlyingSaucer extends GameObject implements EntityB{
	
	
	private Textures tex;
	//private Game game;
	Random r = new Random();
	private Controller c;
	private Game game;
	private double t=0;
	private int HEALTH = 50;
	
	
	
	public FlyingSaucer(double x, double y, Textures tex, Controller c, Game game) {
		super(x,y);
		this.tex=tex;
		this.c=c;
		this.game=game;
		
	}
	
	
	
	public void shootRocket() {
		if(Math.random()<=0.18)
			c.addEntity(new SaucerRocket(getX(),getY(),c,game,tex));
	}

	
	public void tick() {
		
		x-=3;
		
		t+=Math.random();
		
		if(t>10)
			shootRocket();
			
			
		
		
		
		if(x>(Game.WIDTH*Game.SCALE)) {
			c.removeEntity(this);
		}
		
		
		if(Physics.Collision(this, game.ea)) {
			System.out.println("Pogodjen tanjir");
			HEALTH-=2;
			c.removeEntity(game.ea.getFirst());
			if(HEALTH==0) {
				
				c.removeEntity(this);
			}
		}
		
		
		if(t>10)
			t=0;
		
		
	}

	
	public void render(Graphics g) {
		g.drawImage(tex.flyingSaucer,(int) x,(int)y,null);
		
	}

	
	public Rectangle getBounds() {
		
		return new Rectangle((int)x,(int)y,100,100);
	}

	
	public double getX() {
		// TODO Auto-generated method stub
		return x;
	}

	
	public double getY() {
		// TODO Auto-generated method stub
		return y;
	}
	
	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

}
