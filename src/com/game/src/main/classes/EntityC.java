package com.game.src.main.classes;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.game.src.enums.Drop;

public interface EntityC {
	
	public void tick();
	public void render(Graphics g);
	public Rectangle getBounds();
	
	public double getX();
	public double getY();
	public BufferedImage getImage();
	public Drop getDrop();
	//public EntityC getEntityC();

}
