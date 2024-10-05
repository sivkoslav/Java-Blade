package com.game.src.main.drops;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.game.src.enums.Drop;
import com.game.src.hud.HUD;
import com.game.src.main.Controller;
import com.game.src.main.Game;
import com.game.src.main.GameObject;
import com.game.src.main.Textures;
import com.game.src.main.classes.EntityC;

import java.util.*;

public class RankMarkerDrop extends GameObject implements EntityC{

	private Textures tex;
	private Game game;
	private Controller c;
	private HUD hud;
	
	Random r= new Random();
	private int randomNumber=r.nextInt(6);
	private Drop drop=Drop.fromId(randomNumber);//treba napraviti enum drop i onda menjati klase
	
	
	public RankMarkerDrop(double x, double y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public BufferedImage getImage() {
		// TODO Auto-generated method stub
		return tex.map.get(Drop.fromId(randomNumber));
	}

	@Override
	public Drop getDrop() {
		// TODO Auto-generated method stub
		return drop;
	}
	
	public void setDrop(Drop drop) {
		this.drop = Drop.fromId(randomNumber);
	}

}
