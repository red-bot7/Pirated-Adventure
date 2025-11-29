package Main;

import javax.swing.JFrame;

public class GameWindow extends JFrame {
    
    public GameWindow() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		GamePanel gamePanel = new GamePanel();
		this.add(gamePanel);

        this.setTitle("A Pirated Adventure");
		this.pack();
		this.setLayout(null);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		gamePanel.startGameThread();
    }

}
