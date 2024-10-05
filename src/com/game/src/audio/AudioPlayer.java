package com.game.src.audio;


import java.util.*;


import org.newdawn.slick.*;



import com.game.src.enums.Drop;

public class AudioPlayer {
	
	public static Map<Drop,Sound> soundMap = new HashMap<Drop,Sound>();
	public static Map<String,Music> musicMap = new HashMap<String,Music>();
	
	public static boolean soundOn=true;
	
	public static void loadSounds() {
		
		try {
			//sound effects
			soundMap.put(Drop.ExtraBullet, new Sound( "res/Extra-bullet.ogg"));
			soundMap.put(Drop.ExtraSpeed, new Sound( "res/Extra-speed.ogg"));
			soundMap.put(Drop.TripleShot, new Sound( "res/Triple-shot.ogg"));
			soundMap.put(Drop.LetterE, new Sound( "res/Letter-E.ogg"));
			soundMap.put(Drop.LetterX, new Sound( "res/Letter-X.ogg"));
			soundMap.put(Drop.LetterT, new Sound( "res/Letter-T.ogg"));
			soundMap.put(Drop.LetterR, new Sound( "res/Letter-R.ogg"));
			soundMap.put(Drop.LetterA, new Sound( "res/Letter-A.ogg"));
			soundMap.put(Drop.BlueRankMarker, new Sound("res/Rank-Marker.ogg"));
			soundMap.put(Drop.GreenRankMarker, new Sound("res/Rank-Marker.ogg"));
			soundMap.put(Drop.YellowRankMarker, new Sound("res/Rank-Marker.ogg"));
			soundMap.put(Drop.RedRankMarker, new Sound("res/Rank-Marker.ogg"));
			soundMap.put(Drop.PurpleRankMarker, new Sound("res/Rank-Marker.ogg"));
			soundMap.put(Drop.OrangeRankMarker, new Sound("res/Rank-Marker.ogg"));
			soundMap.put(Drop.SingleShot, new Sound("res/Single-Shot.ogg"));
			soundMap.put(Drop.TenDollarCoin, new Sound("res/Money.ogg"));
			soundMap.put(Drop.FiftyDollarCoin, new Sound("res/Money.ogg"));
			soundMap.put(Drop.HundredDollarCoin, new Sound("res/Money.ogg"));
			soundMap.put(Drop.TwoHundredDollarCoin, new Sound("res/Money.ogg"));
			//music
			musicMap.put("backgroundmusic", new Music("res/backgroundmusic.ogg"));
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static Sound getSound(Drop drop) {
		return soundMap.get(drop);
	}
	
	public static Music getMusic(String string) {
		return musicMap.get(string);
	}
}
