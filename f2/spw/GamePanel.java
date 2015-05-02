package f2.spw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
	
	private BufferedImage bi;	
	Graphics2D big;
	ArrayList<Sprite> sprites = new ArrayList<Sprite>();

	public GamePanel() {
		bi = new BufferedImage(400, 600, BufferedImage.TYPE_INT_ARGB);
		big = (Graphics2D) bi.getGraphics();
		big.setBackground(Color.BLACK);
	}

	public void updateGameUI(GameReporter reporter){
		big.clearRect(0, 0, 400, 600);
		
		big.setColor(Color.WHITE);		
		big.drawString(String.format("%08d", reporter.getScore()), 300, 20);
		for(Sprite s : sprites){
			s.draw(big);
		}
		
		repaint();
	}
	public void HP(int x,int y){
		big.setColor(Color.RED);
		big.fillRect(5,25,360,25);
		big.setColor(Color.BLACK);
		big.fillRect(7,30,366,20);
		big.setColor(Color.BLUE);
		big.fillRect(x,35,y,5);
	}
	public void RandomColor(){
		int G int(Math.random()*256);
		int R int(Math.random()*256);
		int B int(Math.random()*256);
		int y= int(Math.random()*50);
		
		Color color = new Color(G,R,B);
		Color colors = new Color(0,0,0);
		System.out.println(color + "  " + y);
		if(color == color.RED  || color == color.BLUE){
	      	color = color1;
		}
		
		big.setBackground(color);
		}
	}
	
	public void Start(GameReporter reporter){
		big.clearRect(0,0,500,600);
		big.setColor(Color.Green);
		big.setFont(big.getfont().derivefont(16.0f));
		big.drawString(String.fomat("Press \"Enter \"to Start game",140,280);
		repaint();
	} 

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(bi, null, 0, 0);
	}

}
