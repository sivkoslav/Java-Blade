package com.game.src.main;

import java.awt.Graphics;
import java.util.*;
import java.util.LinkedList;

import com.game.src.hud.HUD;
import com.game.src.main.classes.EntityA;
import com.game.src.main.classes.EntityB;
import com.game.src.main.classes.EntityC;
import com.src.game.enemy.*;
public class Controller {
	
	private LinkedList<EntityA> ea = new LinkedList<>();
	private LinkedList<EntityB> eb = new LinkedList<>();
	private LinkedList<EntityC> ec = new LinkedList<>();
	
	EntityA enta;
	EntityB entb;
	EntityC entc;
	private Textures tex;
	private Game game;
	Random r = new Random();
	Controller c;
	double chance = Math.random();
	private HUD hud;
	
	
	public Controller(Textures tex, Game game, HUD hud) {
		this.tex=tex;
		this.game=game;
		this.hud=hud;
		
		
		//addEntity(new Enemy(r.nextInt(640),-10,tex)); // ili ovde ili napraviti metod za spawn neprtijatelja i onda ga pozvati
		//ali najbolje izdvojiti u drugi metod
		
	}
	
//	public void dropLetter() {
//		addEntity(new DropLetter(x,y,tex,game));
//	}
	
	public void spawnMother() {
		addEntity(new EnemyMother(400,50,tex,this,game));
	}
	
	public void stageDownfall(int count) {
		for(int i=0;i<count;i++) {
			addEntity(new Enemy(32*i,70,tex,this,game,hud));
		}
	}
	
	//link za leteci tanjir
	//https://www.youtube.com/watch?v=omeG8wamu3w&ab_channel=OmenOfCrowbar
	public void spawnEnemy(int count) {//doteradi ove spawnove da budu ko u igri pogledati sajt
		//https://warblade.fandom.com/wiki/Level_Guide
		for(int i=0;i<count/2;i++) {
			addEntity(new Enemy(32*i,70,tex,this,game, hud));//doterati spawn da ne budu jedan preko drugog
			
		}
		for(int i=0;i<count/2;i++) {
			addEntity(new Enemy(32*i,90,tex,this,game,hud));
			
		}
		
	}
	
	//axisX je koordinata na x osi, xGoleftRight je da li ce ici levo ili desno, i yLevelAxis je kad ce da krene da ide levo desno tj na kom nivou
	public void spawnSecondLevelFirstStage(int axisX,int xGoLeftRight, int yLevelAxis) {

		addEntity(new Enemy2(axisX,0,tex,this,game,hud,xGoLeftRight, yLevelAxis));
		
	}
	
	public void spawnSecondLevelFirstStage2(int axisX,int xGoLeftRight, int yLevelAxis) {
		addEntity(new Enemy2(axisX,0,tex,this,game,hud,xGoLeftRight, yLevelAxis));
	}
	
	
	
	public void spawnEndingWave(int count, int axisX) {
		
		
		addEntity(new EnemyLastStage(axisX+15,0,tex,this,game,hud));
		addEntity(new EnemyLastStage(axisX+25,0,tex,this,game,hud));
		addEntity(new EnemyLastStage(axisX+35,0,tex,this,game,hud));
		addEntity(new EnemyLastStage(axisX+45,0,tex,this,game,hud));
		addEntity(new EnemyLastStage(axisX+55,0,tex,this,game,hud));
		
		
	}
	
	//napraviti spawn da idu od gore i ko zna odakle sve
	
	
	

	
	public void spawnSaucer() {
		addEntity(new FlyingSaucer(640,-5,tex,this,game));
	}
	
	
	
	
	public void tick() {
		//A class
		for(int i =0;i<ea.size();i++) {
			enta=ea.get(i);
			
			enta.tick();
		}
		
		//B class
		for(int i =0;i<eb.size();i++) {
			entb=eb.get(i);
			
			entb.tick();
		}
		
		//c class
		for(int i=0;i<ec.size();i++) {
			entc=ec.get(i);
			entc.tick();
		}
	
	}
	
	
	public void render(Graphics g) {
		// a class
		for(int i =0;i<ea.size();i++) {
			enta=ea.get(i);
			
			enta.render(g);
		}
		
		//b class
		for(int i =0;i<eb.size();i++) {
			entb=eb.get(i);
			
			entb.render(g);
		}
		
		//c class
		for(int i=0;i<ec.size();i++) {
			entc=ec.get(i);
			entc.render(g);
		}
		
		
	}
	
	public void addEntity(EntityA block) {
		ea.add(block);
	}
	
	public void removeEntity(EntityA block) {
		ea.remove(block);
	}
	
	public void addEntity(EntityB block) {
		eb.add(block);
	}
	
	public void removeEntity(EntityB block) {
		eb.remove(block);
	}
	
	public LinkedList<EntityA> getEntityA(){
		return ea;
	}
	
	public LinkedList<EntityB> getEntityB(){
		return eb;
	}

	public void addEntity(EntityC block) {
		ec.add(block);
	}
	
	public void removeEntity(EntityC block) {
		ec.remove(block);
	}
	
	public LinkedList<EntityC>getEntityC(){
		return ec;
	}
	
	

	
	
	
	
	
	

}
