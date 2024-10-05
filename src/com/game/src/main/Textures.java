package com.game.src.main;

import java.awt.image.BufferedImage;
import java.util.*;

import com.game.src.enums.Drop;

public class Textures {
	
	public BufferedImage player, missile, enemy, enemyBoss, flyingSaucer,enemy2,saucerRocket;//enemy boss ce morati posebno da se izdvoj u spritesheet
	public Map<Drop,BufferedImage> map;
	public Map<Drop,BufferedImage> rankDrop;
	
	public BufferedImage []bufferedImageArray= new BufferedImage[64];
	//potrpati promenljive iznad u niz 
	public BufferedImage []motherImageArray=new BufferedImage[16];
	
	private SpriteSheet ss=null;
	private SaucerSpriteSheet saucerSpriteSheet=null;
	private MotherSpriteSheet motherSpriteSheet=null;
	
	
	public Textures(Game game) {
		 ss=new SpriteSheet(game.getSpriteSheet());
		 saucerSpriteSheet = new SaucerSpriteSheet(game.getSaucerSpriteSheet());
		 motherSpriteSheet=new MotherSpriteSheet(game.getMotherSpriteSheet());
		 getTextures();
		 getSaucerTextures();
		 motherTextures();
		
		
	}
	
	private void getSaucerTextures() {
		flyingSaucer=saucerSpriteSheet.grabImage(1, 1, 128, 128);
		
	}
	
	public void motherTextures() {
		motherImageArray[0]=motherSpriteSheet.grabImage(1, 1, 64, 64);
		
	}
	
	private void getTextures() {
		player=ss.grabImage(1, 1, 32, 32);
		missile=ss.grabImage(2, 1, 32, 32);
		enemy=ss.grabImage(3, 1, 32, 32);
		enemy2=ss.grabImage(4, 1, 32, 32);
		saucerRocket=ss.grabImage(5, 1, 32, 32);
		//extraE=ss.grabImage(6, 1, 32, 32);
		//extraX=ss.grabImage(7, 1, 32, 32);
		//extraT=ss.grabImage(8, 1, 32, 32);
		//extraR=ss.grabImage(1, 2, 32, 32);
		//extraA=ss.grabImage(2, 2, 32, 32);
		
		bufferedImageArray[0]=ss.grabImage(3, 2, 32, 32);//extra bullet
		bufferedImageArray[1]=ss.grabImage(4, 2, 32, 32);//extra speed
		bufferedImageArray[2]=ss.grabImage(5, 2, 32, 32);//triple shot icon
		bufferedImageArray[3]=ss.grabImage(6, 1, 32, 32);//letter E
		bufferedImageArray[4]=ss.grabImage(7, 1, 32, 32);//letter X
		bufferedImageArray[5]=ss.grabImage(8, 1, 32, 32);//letter T
		bufferedImageArray[6]=ss.grabImage(1, 2, 32, 32);//letter R
		bufferedImageArray[7]=ss.grabImage(2, 2, 32, 32);//letter A
		bufferedImageArray[8]=ss.grabImage(2, 1, 32, 32);//player bullet
		bufferedImageArray[9]=ss.grabImage(6, 2, 32, 32);//triple shot bullet
		bufferedImageArray[10]=ss.grabImage(7, 2, 32, 32);//single shot bullet
		bufferedImageArray[11]=ss.grabImage(8, 2, 32, 32);//purple rank marker
		bufferedImageArray[12]=ss.grabImage(1, 3, 32, 32);//red rank marker
		bufferedImageArray[13]=ss.grabImage(2, 3, 32, 32);//blue rank marker
		bufferedImageArray[14]=ss.grabImage(3, 3, 32, 32);//green rank marker
		bufferedImageArray[15]=ss.grabImage(4, 3, 32, 32);//yellow rank marker
		bufferedImageArray[16]=ss.grabImage(5, 3, 32, 32);//orange rank marker
		bufferedImageArray[17]=ss.grabImage(6, 3, 32, 32);//10$ coin
		bufferedImageArray[18]=ss.grabImage(7, 3, 32, 32);//50$ coin
		bufferedImageArray[19]=ss.grabImage(8, 3, 32, 32);//100$ coin
		bufferedImageArray[20]=ss.grabImage(1, 4, 32, 32);//200$ coin
		
		map=new HashMap<>();
		rankDrop=new HashMap<>();
		map.put(Drop.ExtraBullet,bufferedImageArray[0]);
		map.put(Drop.ExtraSpeed,bufferedImageArray[1] );
		map.put(Drop.TripleShot,bufferedImageArray[2] );
		map.put(Drop.LetterE,bufferedImageArray[3] );
		map.put(Drop.LetterX,bufferedImageArray[4] );
		map.put(Drop.LetterT,bufferedImageArray[5]);
		map.put(Drop.LetterR,bufferedImageArray[6] );
		map.put(Drop.LetterA,bufferedImageArray[7] );
		map.put(Drop.SingleShot, bufferedImageArray[10]);
		//map.put(Drop.PurpleRankMarker,  bufferedImageArray[11]);
		//map.put(Drop.RedRankMarker,  bufferedImageArray[12]);
		//map.put(Drop.BlueRankMarker,  bufferedImageArray[13]);
		//map.put(Drop.GreenRankMarker,  bufferedImageArray[14]);
		//map.put(Drop.YellowRankMarker,  bufferedImageArray[15]);
		//map.put(Drop.OrangeRankMarker,  bufferedImageArray[16]);
		map.put(Drop.TenDollarCoin,  bufferedImageArray[17]);
		map.put(Drop.FiftyDollarCoin,  bufferedImageArray[18]);
		map.put(Drop.HundredDollarCoin,  bufferedImageArray[19]);
		map.put(Drop.TwoHundredDollarCoin,  bufferedImageArray[20]);
		//rank drops
		rankDrop.put(Drop.PurpleRankMarker, bufferedImageArray[11]);
		rankDrop.put(Drop.RedRankMarker, bufferedImageArray[12]);
		rankDrop.put(Drop.BlueRankMarker, bufferedImageArray[13]);
		rankDrop.put(Drop.GreenRankMarker, bufferedImageArray[14]);
		rankDrop.put(Drop.YellowRankMarker, bufferedImageArray[15]);
		rankDrop.put(Drop.OrangeRankMarker, bufferedImageArray[16]);
		//napraviti enemy1, enemy2 ...
		//enemyBoss=ss.grabImage(4, 1, 32, 32);
		
	}
	
	
	
	

}
