package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class FroggerPanel extends JPanel {
	private final int WIDTH = 300, HEIGHT = 200;
	private final int JUMP = 10, DELAY =50; 
	
	private Timer car1Timer;	
	

	private int delay = 50, totalFrames = 3, currentFrame = 0;
	private final int IMAGE_SIZE = 31;

	private ImageIcon up, down, right, left, currentImage,car1,car2;
	private int x, y;

	public FroggerPanel() {
		
		

		addKeyListener(new DirectionListener());
		car1Timer = new Timer(DELAY, new CarListener());


		x = WIDTH / 2;
		y = HEIGHT / 2;

		String prefix = "/images/"
		up = new ImageIcon(prefix + "jump2.png");
		down = new ImageIcon(prefix + "jump3.png");
		left = new ImageIcon(prefix + "left.png");
		right = new ImageIcon(prefix + "walk3.png");
		
		
		car1 =new ImageIcon(prefix + "car1.png");
		car2 =new ImageIcon(prefix + "car2.jpg");
		

		currentImage = right;

		setBackground(Color.black);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
	}

	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		currentImage.paintIcon(this, page, x, y);
	}

	// *****************************************************************
	// Represents the listener for keyboard activity.
	// *****************************************************************
	private class DirectionListener implements KeyListener {
		// --------------------------------------------------------------
		// Responds to the user pressing arrow keys by adjusting the
		// image and image location accordingly.
		// --------------------------------------------------------------
		public void keyPressed(KeyEvent event) {
			switch (event.getKeyCode()) {
			case KeyEvent.VK_UP:
				currentImage = up;
				y -= JUMP;
				break;
			case KeyEvent.VK_DOWN:
				currentImage = down;
				y += JUMP;
				break;
			case KeyEvent.VK_LEFT:
				currentImage = left;
				x -= JUMP;

				// i must implement the left animation here
				break;
			case KeyEvent.VK_RIGHT:
				 currentImage = right;

				
				x += JUMP;
				

				break;
			}

			repaint();
		}
		
		
		// --------------------------------------------------------------
		// Provide empty definitions for unused event methods.
		// --------------------------------------------------------------
		public void keyTyped(KeyEvent event) {
		}

		public void keyReleased(KeyEvent event) {
		}
	}
	
	
	protected class CarListener implements ActionListener {
		public void actionPerformed(ActionEvent event){
			
		
		repaint();
		}
		
}

}
