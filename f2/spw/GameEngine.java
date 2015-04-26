package f2.spw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Timer;


public class GameEngine implements KeyListener, GameReporter{
	GamePanel gp;
		
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private ArrayList<Enemy2> enemies2 = new ArrayList<Enemy2>();
	private ArrayList<Bullet> bullet = new ArrayList<Bullet>();
	private ArrayList<Item> item = new ArrayList();
	private SpaceShip v;	
	
	private Timer timer;
	
	private long score = 0;
	//int x = 5;
	//int y = 366;
	private int time = 0;
	private double difficulty = 0.3;
	private int b = 350;
	private int e = 0;
	private int hearth = 0;
	
	public GameEngine(GamePanel gp, SpaceShip v) {
		this.gp = gp;
		this.v = v;		
		
		gp.sprites.add(v);
		
		timer = new Timer(30, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				process();
				process2();
				process3();
				process4();
				
			}
		});
		timer.setRepeats(true);
		
	}
	
	public void start(){
		timer.start();
	}
	
	private void generateEnemy(){
		Enemy e = new Enemy((int)(Math.random()*390), 30);
		gp.sprites.add(e);
		enemies.add(e);
	}
	
	private void generateEnemy2(){
		Enemy2 e = new Enemy2((int)(Math.random()*390), 30);
		gp.sprites.add(e);
		enemies2.add(e);
	}
	
	private void process(){
		if(time>0)
			time--;
		if(Math.random() < difficulty){
			generateEnemy();
		}
		
		Iterator<Enemy> e_iter = enemies.iterator();
		while(e_iter.hasNext()){
			Enemy e = e_iter.next();
			e.proceed();
			
			if(!e.isAlive()){
				e_iter.remove();
				gp.sprites.remove(e);
				score += 300;
				if(score>=3000 && score %3000 ==0){
					gp.RandomColor();
				}
			}
		}
		
	private void process2(){
		if(Math.random()<difficulty){
			generateEnemy2();
		}
		
		Iterator<Enemy2> e_iter = enemies2.iterator();
		while(e_iter.hasNext()){
			Enemy2 e = e_iter.next();
			e.proceed();
			
			if(!e.isAlive()){
				e_iter.remove();
				gp.sprites.remove(e);
				score += 300;
			}
	}	
		
		
		
		gp.updateGameUI(this);
		
		Rectangle2D.Double vr = v.getRectangle();
		Rectangle2D.Double er;
		for(Enemy e : enemies){
			er = e.getRectangle();
			if(er.intersects(vr)){
				if(time==0){
					x+=50;
					y+=-50;
					time=25;
				if(x>366){
				die();
				}
				return;
			}
		}
	}
	
	
	
	
	gp.HP(b);
	}
	public void die(){
		gp.HP(x,y);
		timer.stop();
	}
	
	void controlVehicle(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			v.move(-1);
			break;
		case KeyEvent.VK_RIGHT:
			v.move(1);
			break;
		case KeyEvent.VK_D:
			difficulty += 0.1;
			break;
		case keyEven.VK_DOWN:
			v.move_X(1);
			break;
		case keyEven.VK_UP:
			v.move_X(-1);
			break;
		}
	}

	public long getScore(){
		return score;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		controlVehicle(e);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//do nothing
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//do nothing		
	}
}
	private void generateBullet(){
		Bullet b = new Bullet((v.x)+(v.width/2),v.y);
		gp.spirites add(b);
		bullet.add(b);
	}
	private void process3(){
		Interator<Bullet> e_iter = bullet.interator();
		while(e_iter.hasnext){
			Bullet b = e_iter.next();
			b.proceed();
			if(!b.isAlive()){
				e_iter.remove();
				gp.spirites.remove(b);
			}
		}
		private void generateItem(){
			Item e = new Item((int)(Math.random()*390),2);
			gp.spirites.add(e);
			item.add(e);
		}
		private void process4(){
		 	if(Math.random()<difficulty/10){
		 		generateItem();
		 	}
			if(hearth>0){
				hearth--;
				
			Interator<Item>  e_iter = item.interator();
		while(e_iter.hasnext){
			Item e = e_iter.next();
			e.proceed();
			if(!e.isAlive()){
				e_iter.remove();
				gp.spirites.remove(e);	
				
			}
		}
		
	}
	}
