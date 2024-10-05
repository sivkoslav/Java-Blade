package com.game.src.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;

import com.game.src.enums.Drop;
import com.game.src.hud.HUD;
import com.game.src.main.classes.EntityB;
import com.game.src.main.drops.*;

public class Enemy extends GameObject implements EntityB{
	
	
	
	private Textures tex;
	private Game game;
	Random r=new Random();
	private Drop drop;
	private Controller c;
	long seconds=System.currentTimeMillis();
	long time=0;
	long fiveSeconds = 5000;
	Timer timer= new Timer();
	private HUD hud;
	
	private double t=0;
	private double t1=0;
	private double goDown=0;
	private double goLeft=0;
	private double goRight=0;
	
	
	
	private int countKilled=0;
	
	public Enemy(double x, double y, Textures tex, Controller c, Game game, HUD hud) {
		super(x,y);
		this.tex=tex;
		this.c=c;
		this.game=game;
		this.hud=hud;
		
		
		
		
		
		
	}
	
	public void shootBullet() {
		double chance = Math.random();
		if(chance<0.15) {
			c.addEntity(new EnemyBullet(getX(),getY(),tex,game,c));
			
		}
	}
	
	public void dropLetter() {
		double chance=Math.random();
		if(chance<=0.09) {// 9% sanse da ispadne neki drop
			c.addEntity(new Drops(getX(),getY(),tex,game,c,hud));
		}
	}
	
	public double getChance() {
		return Math.random();
	}
	
	
	
	
	
	public void tick() {
		t+=0.011;//odredjuje kad ce oni pucati
		t1+=0.014;
		
		goRight+=0.011;
		//x+=1;
		
		
			
		
		//osmisliti kretanje levo desno
		
		if(goRight<=2) {//ovo staviti da bude nepredvidljivo staviti random vrednosti
			x+=1;
		}else {
			x-=1;
		}
		
		
		
		
		//
		if(t>2.75)
			shootBullet();
		
		
		
		if(x> (Game.WIDTH * Game.SCALE)) {
			x=0;
		}
		
		if(x < 0) {
			x=640;
		}
		
		
		
		if((game.getEnemyCount()-game.getEnemyKilled())<=3) {
			y+=1;
		}
		
		if(y > (Game.HEIGHT * Game.SCALE)) {
			y=0;
			x=r.nextInt(Game.WIDTH * Game.SCALE);
		}
		
		if(Physics.Collision(this, game.ea)) {
			
			c.removeEntity(this);
			c.removeEntity(game.ea.getFirst());//metak ne prolazi dalje nestaje kad naleti na prvog
			dropLetter();//zapravo samo drop baca sve
			
			game.setEnemyKilled(game.getEnemyKilled() + 1);
			
		}
		
		if(t>2.75)
			t=0;
		if(goRight>=4)
			goRight=0;
		
		
		
		
		
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int) y, 32,32);
	}
	
	public void render(Graphics g) {
		g.drawImage(tex.enemy, (int) x, (int)y,null);
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
