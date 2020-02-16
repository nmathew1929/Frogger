package game;

import javax.swing.JFrame;

public class test {
public static void main(String[] args) {
	JFrame frame = new JFrame ("Frogger");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
	frame.getContentPane().add(new FroggerPanel());
	
	frame.pack();
	frame.setVisible(true);
}
}
