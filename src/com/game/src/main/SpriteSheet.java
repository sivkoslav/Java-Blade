package com.game.src.main;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	
	
	private BufferedImage image;
	
	public SpriteSheet(BufferedImage image) {
		this.image=image;
		
	}
	
	
	
//	public BufferedImage getFlyingSaucer(int col,int row,int width, int height) {
//		BufferedImage i = flyingSaucer.getSubimage(col, row, width, height);
//		return i;
//		
//	}
	
	public BufferedImage grabImage(int col,int row, int width, int height){
		
		BufferedImage img= image.getSubimage((col*32)-32, (row*32)-32, width, height);
		return img;
	}
		
	

}
