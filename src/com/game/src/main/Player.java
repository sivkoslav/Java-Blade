package com.game.src.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.*;

import com.game.src.enums.Drop;
import com.game.src.hud.HUD;
import com.game.src.main.classes.EntityA;
import com.game.src.main.classes.EntityC;
import com.game.src.main.drops.Drops;

public class Player extends GameObject implements EntityA{
	
	
	
	private double velX=0;
	private double velY=0;
	private Game game;
	private Controller c;
	private HUD hud;
	private Set<Drop> setOfLetters=new HashSet<>();
	private Set<Character> setOfChars=new HashSet<>();
	
	
	
	private Textures tex;
	
	

	
	public Player(double x, double y,Textures tex, Game game, Controller c, HUD hud) {
		super(x, y);
		this.tex=tex;
		this.game=game;
		this.c=c;
		this.hud=hud;
		
		
	}
	
	public void tick() {
		
		x+=velX;
		y+=velY;
		
		if(x<=0) 
			x=0;
		if(x >= 640 - 18)
			x=640 - 18;
		if(y<=0)
			y=0;
		if(y>=480 -32)
			y=480-32;
		
		
		if(Physics.Collision(this, game.eb)) {
			System.out.println("Pogodjen sam");
			
			//prepraviti njihov metak u novi interfejs i onda ga tako razlikovati i izbrisati da metaki neprijatelj ne implementiraju isti interfejs
			//hud.setLives(hud.getLives()-1);
			
			
		}
		
	}
		
		
		
		
		
		
	
	
	
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int) y, 32,32);
	}
	
	
	public void render(Graphics g) {
		g.drawImage(tex.player, (int)x, (int)y, null);
		
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setVelX(double velX) {
		this.velX = velX;
	}

	public void setVelY(double velY) {
		this.velY = velY;
	}

	public Set<Drop> getSetOfLetters() {
		return setOfLetters;
	}
	
	
	
	
	
	
}
