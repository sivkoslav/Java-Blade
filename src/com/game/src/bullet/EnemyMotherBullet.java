package com.game.src.bullet;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.game.src.main.Controller;
import com.game.src.main.Game;
import com.game.src.main.GameObject;
import com.game.src.main.Player;
import com.game.src.main.Textures;
import com.game.src.main.classes.EntityB;
import java.util.*;

public class EnemyMotherBullet extends GameObject implements EntityB{

	
	private Textures tex;
	private Game game;
	private Controller c;
	private Player player;
	double diffX=0;
	double diffY=0;
	double distance=0;
	Random r = new Random();
	int randomNumber=r.nextInt(2,5);
	
	
	
	public EnemyMotherBullet(double x, double y, Textures tex, Game game, Controller c) {
		super(x, y);
		this.tex=tex;
		this.game=game;
		this.c=c;
		player=game.getP();
		diffX=x-player.getX()-8;
		diffY=y-player.getY()-8;
		distance=Math.sqrt((x-player.getX())*(x-player.getX()) +(y-player.getY()) * (y-player.getY()));
		velX=((-1/distance)*diffX);
		velY=((-1/distance)*diffY);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		//y+=4;
	
		
		x+=velX*randomNumber;
		y+=velY*randomNumber;
		
		
		
		
		
		
		if(y>600)
			c.removeEntity(this);
		
	}
	
	

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(tex.bufferedImageArray[9], (int)x,(int)y,null);
		
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
