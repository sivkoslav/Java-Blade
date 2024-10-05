package com.src.game.enemy;

import java.awt.Graphics;

import java.awt.Rectangle;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;

import com.game.src.main.Controller;
import com.game.src.main.Game;
import com.game.src.main.GameObject;
import com.game.src.main.Textures;
import com.game.src.main.classes.EntityB;
import com.game.src.hud.HUD;
import com.game.src.main.*;

import com.game.src.main.drops.*;

public class Enemy2 extends GameObject implements EntityB{
	
	
	
	private Textures tex;
	private Game game;
	Random r=new Random();
	private Controller c;
	long seconds=System.currentTimeMillis();
	long time=0;
	long fiveSeconds = 5000;
	Timer timer= new Timer();
	private HUD hud;
	
	private double t=0;
	private double goDown=0;
	private double goLeft=0;
	private double goRight=0;
	private double t1=0;
	private double t2=0;
	
	private boolean down=true;
	private boolean left=false;
	private boolean up=false;
	private boolean normal=false;
	private boolean leftRight=false;
	private double shootBullet=0;
	
	
	
	private int countKilled=0;
																						//axisX je xGoLeftRight
	public Enemy2(double x, double y, Textures tex, Controller c, Game game, HUD hud, int axisX, int yLevelAxis) {
		super(x,y);
		this.tex=tex;
		this.c=c;
		this.game=game;
		this.hud=hud;
		this.axisX=axisX;
		this.yLevelAxis=yLevelAxis;
		
		
		
		
		
		
	}
	
	public void shootBullet() {
		double chance = Math.random();
		if(chance<0.25) {
			c.addEntity(new EnemyBullet(getX(),getY(),tex,game,c));
			
		}
	}
	
	public double getChance() {
		return Math.random();
	}
	
	public void dropItem() {
		double chance=Math.random();
		if(chance<=0.09) {// 9% sanse da ispadne drop
			c.addEntity(new Drops(getX(),getY(),tex,game,c,hud));
			
		}
	}
	
	public void checkCollision() {
		if(Physics.Collision(this, game.ea)) {
			c.removeEntity(this);
			c.removeEntity(game.ea.getFirst());
			dropItem();
			game.setEnemyKilled(game.getEnemyKilled()+1);
			
		
			
		}
	}
	
	
	
	
	
	public void tick() {
		
		checkCollision();
		
		
		shootBullet+=0.011;
		
		if(shootBullet>2.75) {
			shootBullet();
		}
		
		if(down && y<=350) {
			checkCollision();
			y+=3;
		}
		
		if(y==351 ) {// i mozda && down
			t1+=0.1;
			down=false;
			left=true;
			x-=axisX;
			checkCollision();
		}
		
		if(t1>10 && left) {
			t2+=0.1;
			//left=false;
			up=true;
			leftRight=true;
			y-=2;
			checkCollision();
		}
		
		if(y<yLevelAxis && leftRight && goLeft<8) {
			goLeft+=0.02;
			
			x+=axisX;
			up=false;
			leftRight=true;
			left=false;
			checkCollision();
			
			
			
			
		}else if(y<yLevelAxis && leftRight && goLeft>8) {
			goLeft+=0.02;
			x-=axisX;
			up=false;
			leftRight=true;
			left=false;
			checkCollision();
		}
		
		
		if(x>(Game.WIDTH * Game.SCALE)) {
			x=0;
			
			System.out.println("X: " + getX() + " Y: " + getY());
			
			
			
			
		}
		
		if(x<(0)) {
			x=Game.WIDTH*Game.SCALE;
			
			
			
			
		}

		if(shootBullet>2.75) {
			shootBullet=0;
		}
		
		
		if(goLeft>16) {
			goLeft=0;
		}
		
		
		
		
	
		
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int) y, 32,32);
	}
	
	public void render(Graphics g) {
		g.drawImage(tex.enemy2, (int) x, (int)y,null);
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public int getCountKilled() {
		return countKilled;
	}

	public void setCountKilled(int countKilled) {
		this.countKilled = countKilled;
	}
	
	
	
	
	

}
