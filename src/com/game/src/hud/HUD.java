package com.game.src.hud;

import java.awt.Color;
import java.awt.Graphics;

import com.game.src.main.Textures;

public class HUD {

	public int lives=2;
	public static int MAX_LIVES=4;
	public static int level=1;
	public String Letters="";//za ovo ce morati bufferedImage da bi prikazao slike
	private boolean letterE=false;
	private boolean letterX=false;
	private boolean letterT=false;
	private boolean letterR=false;
	private boolean letterA=false;
	private Textures tex;
	
	public HUD(Textures tex) {
		this.tex=tex;
	}
	
	
	public void tick() {//za crne trake sa strane mogu ih dodati svakako ali cu morati menjati neke dimenzije 
		//i tu ce stajati zivoti i extra i jos nesto
		
	}
	
	public void render(Graphics g) {
		
		g.setColor(Color.red);
		g.drawString("Lives: " + lives, 15, 20);
		g.drawString("Level: " + level, 15, 40);
		
		if(letterE)
			g.drawImage(tex.bufferedImageArray[3],80 , 10, null);
		if(letterX)
			g.drawImage(tex.bufferedImageArray[4],100 , 10, null);
		if(letterT)
			g.drawImage(tex.bufferedImageArray[5],120 , 10, null);
		if(letterR)
			g.drawImage(tex.bufferedImageArray[6],140 , 10, null);
		
		if(letterA)
			g.drawImage(tex.bufferedImageArray[7],160 , 10, null);
		
		if(letterE && letterX && letterT && letterR && letterA) {
			g.setColor(Color.black);
			g.fillRect(80, 10, 160, 20);
		}//ovo ce odlicno raditi kada se prebaci na one crne trake sa strane
		
		
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public boolean isLetterE() {
		return letterE;
	}

	public void setLetterE(boolean letterE) {
		this.letterE = letterE;
	}

	public boolean isLetterX() {
		return letterX;
	}

	public void setLetterX(boolean letterX) {
		this.letterX = letterX;
	}

	public boolean isLetterT() {
		return letterT;
	}

	public void setLetterT(boolean letterT) {
		this.letterT = letterT;
	}

	public boolean isLetterR() {
		return letterR;
	}

	public void setLetterR(boolean letterR) {
		this.letterR = letterR;
	}

	public boolean isLetterA() {
		return letterA;
	}

	public void setLetterA(boolean letterA) {
		this.letterA = letterA;
	}


	public int getLevel() {
		return level;
	}


	public void setLevel(int level) {
		this.level = level;
	}
	
	
	
	
	
	
	
	
}
