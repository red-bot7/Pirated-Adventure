package Main;

import javax.swing.JPanel;
import Utilz.Variables;

public class GamePanel extends JPanel implements Runnable {
    
    public Thread gameThread;

    public GamePanel() {
        this.setBackground(java.awt.Color.BLACK);
        this.setPreferredSize(new java.awt.Dimension(Variables.WINDOW_WIDTH, Variables.WINDOW_HEIGHT));
    }

    public void startGameThread() {
        gameThread = new Thread();
        gameThread.start();
    }

    @Override
    public void run() {
		double drawInterval = 1000000000/Variables.FPS;
		long prevTime = System.nanoTime();
		long currentTime;
		double delta = 0;
		int timer = 0;
		int drawCount = 0;
		
		while(gameThread != null) {
			currentTime = System.nanoTime();
			
			delta += (currentTime - prevTime) / drawInterval;
			
			timer += (currentTime - prevTime);
			
			prevTime = currentTime;
			
			if(delta >= 1) {
				update();
				repaint();
				drawCount++;
				delta--;
			}
			
			if(timer >= 1000000000) {
				System.out.println("FPS: " + drawCount);
				drawCount = 0;
				timer = 0;
			}
		}
	}

     public void update() {
        
    }

    public void paint(java.awt.Graphics g) {
        super.paint(g);
    }
    
 }
