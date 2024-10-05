package com.game.src.main;

import java.util.Random;

import com.game.src.hud.HUD;

public class EnemySpawner {
	
	private Controller c;
	private Random r = new Random();
	private Game game;
	
	private int lvl=1;
	private int enemyKilled=0;
	private int scoreKeep=0;
	private double timerForSaucer=0;
	private double endingWave=0;
	private double timerForLastStage=0;
	private boolean prekidac=false;
	private boolean startLevel4=false;
	private double t=0;
	private double t1=0;
	private double t2=0;
	private double t3=0;
	private long t4=0;
	private double spawner=0;
	private int count=0;
	private boolean startLevel=false;
	
	
	
	
	public EnemySpawner(Controller c, Game game) {
		this.c=c;
		this.game=game;
	}
	
	
	
	public void tick() {//napraviti da se prati broj ubijenih na svakom levelu i kad je nula lvl++ i spawnuj nove neprijatelje
		timerForSaucer+=1;
		
		

		
		//System.out.println(timerForSaucer);
		//ili mozda caki ovde napraviti switch sa svim levelima
		if(timerForSaucer>2000 && !c.getEntityB().isEmpty())//proveriti ako je vec prosao jedan da se drugi brze spawnuje
			c.spawnSaucer();
		
		if(c.getEntityB().isEmpty() && HUD.level==1) {
			
			if(c.getEntityB().isEmpty()) {
				HUD.level+=1;
				game.setEnemyKilled(0);
				timerForSaucer=0;
			}
			//c.spawnEnemy(18);
		}else if(c.getEntityB().isEmpty() && HUD.level==2) {
			
			if(game.getEnemyKilled()==0) {
				c.spawnEnemy(18);
				c.spawnMother();
			}else if(game.getEnemyKilled()==18 && game.getEnemyMotherDeaths()==1) {
				HUD.level+=1;
				game.setEnemyKilled(0);
				game.setEnemyMotherDeaths(0);
				timerForSaucer=0;
			}
			
			
		}else if(c.getEntityB().isEmpty() && HUD.level==3) {
			
			t+=1;
			t1+=1;
			t2+=1;
			t3+=1;
		
			
			if(c.getEntityB().isEmpty() && !prekidac) {
				c.spawnEndingWave(5,32);
				System.out.println("prvi deo");
				prekidac=true;
			}
			if(t>25) {
				c.spawnEndingWave(5,100);
				System.out.println("drugi deo");
				t=-1000;
			}
			if(t1>35 && !prekidac) {
				c.spawnEndingWave(5, 350);
				System.out.println("treci deo");
				t1=-1000;
			}
			
			if(t2>50) {
				c.spawnEndingWave(5, 450);
				System.out.println("cetvrti deo"); 
				t2=-1000;
			
			}
			
			if(t3>70) {
				
				System.out.println("peti deo");
				c.spawnEndingWave(5, 550);
				t=0;
				t1=0;
				t2=0;
				t3=0;
				game.setEnemyKilled(0);
				game.setEnemyMotherDeaths(0);
				HUD.level+=1;
				timerForSaucer=0;
				
				
			}
			
			 
		
			
			
		}else if( HUD.level==4 ) {
			spawner+=0.1;
			t4=0;
			
			if(spawner>3 && count<9) {
				c.spawnSecondLevelFirstStage(275,+1,50);
				c.spawnSecondLevelFirstStage2(325,-1,80);
				spawner=0;
				count++;
				
			}
			
			if(c.getEntityB().isEmpty()) {
				game.setEnemyKilled(0);
				HUD.level+=1;
				timerForSaucer=0;
				startLevel=false;
			}
				
			
		}else if(c.getEntityB().isEmpty() && HUD.level==5) {
			System.out.println("LVL 5");
		}
			
			
		
		
		
		
		
			
		
		//napraviti nove levele ovde
		
		if(timerForSaucer>2000)//ovo namestiti ako je veci od nekog broja i i daalje ima zivih neprijatelja
			timerForSaucer=0;
		
	}

	
	
	

}
