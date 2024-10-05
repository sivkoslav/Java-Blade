package com.game.src.main;

import java.util.LinkedList;

import com.game.src.enums.Drop;
import com.game.src.main.classes.EntityA;
import com.game.src.main.classes.EntityB;
import com.game.src.main.classes.EntityC;
import com.game.src.main.drops.Drops;


public class Physics {
	
	public static boolean Collision(EntityA enta, LinkedList<EntityB> entb) {
		
		
		for(int i=0;i<entb.size(); i++) {
			if(enta.getBounds().intersects(entb.get(i).getBounds())) {
				return true;
			}
		}
		
		
		return false;
	}
	

	
	
	public static boolean Collision(EntityB entb, LinkedList<EntityA> enta) {
		
		
		for(int i=0;i<enta.size(); i++) {
			if(entb.getBounds().intersects(enta.get(i).getBounds())) {
				return true;
			}
		}
		
		
		return false;
	}

	
	public static boolean CollisionWithSingleItem(Player p, Drops d) {
		
		if(p.getBounds().intersects(d.getBounds()))
			return true;//ovako neke varijacije probati 
		//ovo probati u ticku playera
		
		//ili cak napraviti u tick metodu dropa i onda ce se znati tacno koji je drop a bice sa presekom jednog jedinog igraca Playera p
		
		return false;
	}
	
	public static boolean CollisionItemWithPlayer(Drops d, Player p) {
		
		if(d.getBounds().intersects(p.getBounds()))
			return true;
		
		
		return false;
		
	}
	
	
	
	public static boolean CollisionWithItem(Player p, LinkedList<EntityC> entc) {//promeniti na listu ovde entiteta b
		
		
		
		for(int i=0;i<entc.size();i++) {
			if(p.getBounds().intersects(entc.get(i).getBounds())) {
				
				return true;
			}
		}
		
		
		return false;
		
	}

	 





}
