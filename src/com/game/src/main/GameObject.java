package com.game.src.main;

import java.awt.Rectangle;

public class GameObject {
	
	public double x,y;
	protected double velX, velY;
	public int axisX;
	public int yLevelAxis;
	
	public GameObject(double x, double y) {
		this.x=x;
		this.y=y;
	}

	
	public Rectangle getBounds(int width, int height) {
		return new Rectangle((int)x, (int) y, 32,32);
	}
}
