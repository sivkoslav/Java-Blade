package com.game.src.bullet;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.*;

import com.game.src.main.Controller;
import com.game.src.main.Game;
import com.game.src.main.GameObject;
import com.game.src.main.Textures;
import com.game.src.main.classes.EntityA;

public class TripleShoot extends GameObject implements EntityA{

	private Textures tex;
	private Game game;
	Controller c;
	Random r= new Random();
	double pathX;
	
	
	public TripleShoot(double x, double y, Textures tex, Game game, Controller c, double pathX) {
		super(x, y);
		this.tex=tex;
		this.game=game;
		this.c=c;
		this.pathX=pathX;
		
		// TODO Auto-generated constructor stub
	}

	
	public void tick() {
		// TODO Auto-generated method stub
		x-=pathX;
		y-=6;
		//if(y>=Game.HEIGHT) c.removeEntity(this);
	}

	
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
