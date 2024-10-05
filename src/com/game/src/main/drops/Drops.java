package com.game.src.main.drops;

import java.awt.Graphics;
import java.util.*;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.List;

import com.game.src.audio.AudioPlayer;
import com.game.src.enums.Drop;
import com.game.src.hud.HUD;
import com.game.src.main.Controller;
import com.game.src.main.Game;
import com.game.src.main.GameObject;
import com.game.src.main.KeyInput;
import com.game.src.main.Physics;
import com.game.src.main.Player;
import com.game.src.main.Textures;
import com.game.src.main.classes.EntityA;
import com.game.src.main.classes.EntityB;
import com.game.src.main.classes.EntityC;


public class Drops extends GameObject implements EntityC{
	
	
	private Textures tex;//preurediti klasu za sve dropove i sve dropove natrpatiu listu i random kad se pogod neprijatelj da ispusti random index iz liste 
	private Game game;
	private char slovo;
	double random = Math.random();
	private Controller c;
	private HUD hud;
	
	
	
	
	Random r =new Random();
	private int randomNumber=r.nextInt(13);
	private Drop drop=Drop.fromId(randomNumber);
	
	
	public Drops(double x, double y,Textures tex, Game game, Controller c, HUD hud) {
		super(x, y);
		this.tex=tex;
		this.game=game;
		this.c=c;
		this.hud=hud;
		
		
		
		
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		y+=1.10;
		// TODO Auto-generated method stub
		
		if(Physics.CollisionWithSingleItem(game.getP(), this)) {
			System.out.println(this.getDrop().toString());
			
				
			AudioPlayer.getSound(this.getDrop()).play();
			
			if(this.getDrop()==Drop.SingleShot) {
				KeyInput.weapon="single";
			}
			
			if(this.getDrop()==Drop.TripleShot) {
				KeyInput.weapon="triple";
				
			}
			
			if(this.getDrop()==Drop.ExtraSpeed) {
				KeyInput.speed+=0.2;
			}
			
			if(this.getDrop()==Drop.LetterE || this.getDrop()==Drop.LetterX || this.getDrop()==Drop.LetterT || this.getDrop()==Drop.LetterR ||this.getDrop()==Drop.LetterA) {
				game.getP().getSetOfLetters().add(this.getDrop());
				hud.setLetterE(game.getP().getSetOfLetters().contains(Drop.LetterE));
				hud.setLetterX(game.getP().getSetOfLetters().contains(Drop.LetterX));
				hud.setLetterT(game.getP().getSetOfLetters().contains(Drop.LetterT));//izdvojiti u poseban metod
				hud.setLetterR(game.getP().getSetOfLetters().contains(Drop.LetterR));
				hud.setLetterA(game.getP().getSetOfLetters().contains(Drop.LetterA));
				
				if(game.getP().getSetOfLetters().size()==5 && hud.getLives()<4) {
					System.out.println("Napunjen je sada");
					hud.setLives(hud.getLives()+1);
					game.getP().getSetOfLetters().clear();
				}
			}
			c.removeEntity(this);
		}
		
		if(y>600)
			c.removeEntity(this);
		
		
		
		
	}
	
	

	@Override
	public void render(Graphics g) {
		
		g.drawImage(tex.map.get(Drop.fromId(randomNumber)), (int)x, (int)y, null);
		
//		if(random<=0.2) {
//			g.drawImage(tex.bufferedImageArray[3], (int)x,(int)y, null);
//			setSlovo('E');
//		}else if(random>0.2 && random <= 0.4) {
//			g.drawImage(tex.bufferedImageArray[4], (int)x,(int)y,null);
//			setSlovo('X');
//		}else if(random>0.4 && random <=0.6) {
//			g.drawImage(tex.bufferedImageArray[5], (int)x,(int)y,null);
//			setSlovo('T');
//		}else if(random>0.6 && random<=0.8) {
//			g.drawImage(tex.bufferedImageArray[6], (int)x,(int)y,null);
//			setSlovo('R');
//		}else if(random>0.8) {
//			g.drawImage(tex.bufferedImageArray[7], (int)x,(int)y,null);
//			setSlovo('A');
//		}
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x,(int)y,32,32);//dimenzije malko promeniti mozda?
	}

	@Override
	public double getX() {
		// TODO Auto-generated method stub
		return x;
	}

	

	public char getSlovo() {
		return slovo;
	}

	public void setSlovo(char slovo) {
		this.slovo = slovo;
	}

	public Drop getDrop() {
		return drop;
	}

	public void setDrop(Drop drop) {
		this.drop = Drop.fromId(randomNumber);
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

	public Drops getDrops() {
		return this;
	}
	
	
	
	
	
	

}
