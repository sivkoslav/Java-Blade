package com.src.game.enemy;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import com.game.src.main.Controller;
import com.game.src.main.Game;
import com.game.src.main.GameObject;
import com.game.src.main.Textures;
import com.game.src.main.classes.EntityB;
import com.game.src.main.*;
import com.game.src.bullet.*;

public class EnemyMother extends GameObject implements EntityB{

	
	private Textures tex;
	private Game game;
	private Controller c;
	private double t=0;
	private Random r=new Random();
	private boolean isDead=false;
	private int HEALTH=20;
	
	public EnemyMother(double x, double y, Textures tex, Controller c, Game game) {
		super(x, y);
		this.tex=tex;
		this.c=c;
		this.game=game;
		// TODO Auto-generated constructor stub
	}
	
	public void shootBullet() {
		double chance = Math.random();
		if(chance<0.3) {
			c.addEntity(new EnemyMotherBullet(getX(),getY(),tex,game,c));
		}
	}

	@Override
	public void tick() { // takodje ako previse trajhe dodati onaj letewci tanjir stoispaljuje raketu
		t+=0.011;
		x+=1;
		
		if(t>2)
			shootBullet();
		
		if(x>(Game.WIDTH * Game.SCALE)) {
			x=0;
		}
		
		
		if(y> (Game.HEIGHT * Game.SCALE)) {
			y=0;
			x=r.nextInt(Game.WIDTH * Game.SCALE);
		}
		
		if(Physics.Collision(this, game.ea)) {
			c.removeEntity(game.ea.getFirst());
			HEALTH-=2;
			if(HEALTH==0) {
				c.removeEntity(this);
				game.setEnemyMotherDeaths(game.getEnemyMotherDeaths()+1);
			}
			//game.setEnemyKilled(game.getEnemyKilled()+1);
			
		}
		
		if(t>2)
			t=0;
		
	}
	
	

	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(tex.motherImageArray[0], (int)x,(int)y,null);
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x,(int)y,64,64);
	}

	@Override
	public double getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return y;
	}

}
