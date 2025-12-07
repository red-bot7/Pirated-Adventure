package Main;

import javax.swing.JPanel;
import Utilz.Variables;

import Entities.Player;

public class GamePanel extends JPanel implements Runnable {
	
	public Player player;
    public Thread gameThread;

    public GamePanel() {
        this.setBackground(java.awt.Color.BLACK);
        this.setPreferredSize(new java.awt.Dimension(Variables.WINDOW_WIDTH, Variables.WINDOW_HEIGHT));
		this.setDoubleBuffered(true);
		this.setFocusable(true);

        player = new Player(100, 100);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
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
        player.update();

    }

    public void paint(java.awt.Graphics g) {
        super.paint(g);
		player.draw(g);
    }
    
 }
