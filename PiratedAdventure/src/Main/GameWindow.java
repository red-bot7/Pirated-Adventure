package Main;

import javax.swing.JFrame;
import Utilz.Variables;

public class GameWindow extends javax.swing.JFrame {
    
    public GameWindow() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

        this.setTitle("A Pirated Adventure");
		this.pack();
		this.setLayout(null);
		this.setSize(Variables.WINDOW_WIDTH, Variables.WINDOW_HEIGHT);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
    }

}
