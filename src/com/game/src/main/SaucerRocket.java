package com.game.src.main;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.game.src.main.classes.EntityB;

public class SaucerRocket extends GameObject implements EntityB{

	private Controller c;
	private Player player;
	private Game game;
	private Textures tex;
	
	public SaucerRocket(double x, double y, Controller c, Game game, Textures tex) {
		super(x, y);
		this.c=c;
		this.game=game;
		this.tex=tex;
		player=game.getP();
		
	}

	public void tick() {
		// TODO Auto-generated method stub
		x+=velX ;
		y+=velY + 0.8;// ovde me prati sve ali y da bude dosta slabije sa mogucnosti da ode ispod
		
		
		
		double diffX= x - player.getX()-8;
		double diffY= y - player.getY()-8;
		double distance=Math.sqrt((x-player.getX())*(x-player.getX()) +(y-player.getY()) * (y-player.getY()));//rastojanje u koordinatnom prostoru
		
		
		velX=((-1/distance)*diffX);
		velY=((-1/distance)*diffY);
		
//		if(y<=0 || y>Game.HEIGHT-32) velY*=-1;
//		
//		
//		if(x<=0 || x>=Game.WIDTH-16) velX*=-1;
//		
		if(x>=Game.WIDTH*Game.SCALE || x<=0){
			c.removeEntity(this);
		}
		
//		if(y>=Game.WIDTH*Game.SCALE || y<=Game.WIDTH*Game.SCALE)
//			c.removeEntity(this);
		
		if(y>600)
			c.removeEntity(this);
		
	}

	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(tex.saucerRocket, (int)x,(int)y,null);
	}

	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x,(int)y,32,32);
	}

	public double getX() {
		// TODO Auto-generated method stub
		return x;
	}

	public double getY() {
		// TODO Auto-generated method stub
		return y;
	}

}
