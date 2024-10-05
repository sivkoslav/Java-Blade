package com.src.game.enemy;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.game.src.hud.HUD;
import com.game.src.main.Controller;
import com.game.src.main.EnemyBullet;
import com.game.src.main.Game;
import com.game.src.main.GameObject;
import com.game.src.main.Physics;
import com.game.src.main.Textures;
import com.game.src.main.classes.EntityB;
import com.game.src.main.drops.Drops;

public class EnemyLastStage extends GameObject implements EntityB{

	
	private Textures tex;
	private Game game;
	private Controller c;
	private HUD hud;
	private boolean direction=true;
	
	
	private double t=0;
	
	
	public EnemyLastStage(double x, double y, Textures tex, Controller c, Game game, HUD hud) {
		super(x, y);
		this.tex=tex;
		this.c=c;
		this.game=game;
		this.hud=hud;
		// TODO Auto-generated constructor stub
	}
	
	public void shootBullet() {
		double chance=Math.random();
		if(chance<0.15) {
			c.addEntity(new EnemyBullet(getX(),getY(),tex,game,c));
			
		}
	}
	
	public void dropItem() {
		double chance=Math.random();
		if(chance<=0.09) {// 9% sanse da ispadne neki drop
			c.addEntity(new Drops(getX(),getY(),tex,game,c,hud));
		}
	}

	
	
	


	@Override
	public void tick() {
		// TODO Auto-generated method stub
		System.out.println(y);
		t+=0.011;
		
		if(direction)
			y+=4;
		else
			y-=4;
		
		
		if(t>2.8)
			shootBullet();
		
		
		
		if(Physics.Collision(this, game.ea)) {
			c.removeEntity(this);
			c.removeEntity(game.ea.getFirst());
			dropItem();
			game.setEnemyKilled(game.getEnemyKilled()+1);
		}
		
		if(y>550)
			direction=false;
		
		
		if(t>2.8)
			t=0;
		
		
		if(y< -10)
			c.removeEntity(this);
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(tex.enemy,(int)x,(int)y,null);
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x,(int)y,32,32);
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
