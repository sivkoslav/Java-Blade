package com.game.src.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import com.game.src.audio.AudioPlayer;
import com.game.src.enums.GameState;
import com.game.src.main.Game;

public class OptionHandler {
	
	private Game game;
	
	private int selectorX=0,selectorY = 0;
	private byte selector=0;
	private int selectorBuffer=16; //razmak izmedju kvadrata i stringa
	private int selectorWidth=16;
	public static boolean soundOn=true;
	
	public OptionHandler(Game game) {
		this.game=game;
	}
	
	
	//render the options menu
	public void render(Graphics g) {
		
		
		
		//text
		g.setColor(Color.white);
		
		String volume="Volume: " + AudioPlayer.getMusic("backgroundmusic").getVolume()*100,soundOn="Sound?" + ((AudioPlayer.soundOn)? "on" : "off"),Exit="Back",title="Java warblade";
		String volume1=String.format("Volume: " + "%.1f", AudioPlayer.getMusic("backgroundmusic").getVolume()*100);
		
		
		FontMetrics fontM=g.getFontMetrics(g.getFont());
		
		
		g.setFont(new Font("Times New Roman",Font.BOLD,24));
		g.drawString(title, Game.WIDTH- (fontM.stringWidth(title)), 55);
		
		
		g.setFont(new Font("Times New Roman",Font.BOLD,24));
		
		
		g.drawString(soundOn, Game.WIDTH - (fontM.stringWidth(soundOn)), 155);
		if(selector==0) selectorX=Game.WIDTH-(fontM.stringWidth(soundOn))-64-selectorBuffer;
		if(selector==0) selectorY=155-selectorWidth;
		
		
		g.drawString(volume1, Game.WIDTH - (fontM.stringWidth(volume1)), 255);
		if(selector==1) selectorX=Game.WIDTH - (fontM.stringWidth(volume1))-64-selectorBuffer;
		if(selector==1) selectorY=255-selectorWidth;
		
		
		g.drawString(Exit, Game.WIDTH - (fontM.stringWidth(Exit)), 355);
		if(selector==2) selectorX=Game.WIDTH-(fontM.stringWidth(Exit))-64-selectorBuffer;
		if(selector==2) selectorY=355-selectorWidth;
		
		
		//selector
		g.setColor(Color.red);
		if(selectorX!=0) g.fillRect(selectorX, selectorY, selectorWidth, selectorWidth);
		
	}

	public void tick() {
		// TODO Auto-generated method stub
		
	}

	//key press
	public void KeyPress(int key) {
		// TODO Auto-generated method stub
		if(key == KeyEvent.VK_DOWN && selector<2) selector+=1;
		if(key == KeyEvent.VK_UP && selector>0) selector-=1;
		
		//sound
		if(key == KeyEvent.VK_ENTER && selector==0) {
			AudioPlayer.soundOn = !AudioPlayer.soundOn;
			if(AudioPlayer.soundOn) AudioPlayer.getMusic("backgroundmusic").loop();
			if(!AudioPlayer.soundOn) AudioPlayer.getMusic("backgroundmusic").pause();
		}
		
		if(key == KeyEvent.VK_LEFT && selector==1) {
			AudioPlayer.getMusic("backgroundmusic").setVolume(AudioPlayer.getMusic("backgroundmusic").getVolume()-0.01f);
		}
		
		if(key==KeyEvent.VK_RIGHT && selector==1) {
			AudioPlayer.getMusic("backgroundmusic").setVolume(AudioPlayer.getMusic("backgroundmusic").getVolume()+0.01f);
		}
		//exit
		if(key == KeyEvent.VK_ENTER && selector==2)
			game.gs=GameState.Menu;
		
		
	}

}
