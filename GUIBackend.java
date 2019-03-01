package servers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Console;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class GUIBackend extends JPanel implements Runnable, KeyListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private Thread thread;
	private boolean running = false;
	private boolean right = false, left = true, up = false, down = false;
	private Roomba r;
	private int xcoor = 22, ycoor = 15, size = 40;
	private int ticks = 0;
	boolean GoRight = true;
	boolean GoLeft = false;
	boolean GoUp = false;
	boolean GoDown = false;
	MyCLient myclient;
	int angle;
	JTextArea current;
	private ArrayList<Obstacle> Filled;
	private int currentXClick, currentYClick;
	private int add = 0;

	private Obstacle obstacle;
	private ArrayList<Obstacle> obstacles;

	public GUIBackend(MyCLient myclient, JTextArea cur) {
		//this.myclient = myclient;
		current = cur;
		setFocusable(true);
		addKeyListener(this);
		addMouseListener(this);
		start();
		Dimension size = new Dimension(446,676);
        setPreferredSize(size);
        setAlignmentX(CENTER_ALIGNMENT);
        setAlignmentY(CENTER_ALIGNMENT);
        Filled = new ArrayList<Obstacle>();

	}

	public void start() {
		running = true;
		thread = new Thread(this, "GUI");
		thread.start();
	}

	public void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	public void tick() {
		ticks++;
	

		if (ticks > 100000) {
			//System.out.println("test");

			if (right  && GoRight == true) {
				xcoor++;
				GoRight = false;
				angle = 90;
				//myclient.out.printf("r");
				current.setText("Current Direction: Right");
				
				
			}
			if (left && GoLeft == true) {
				xcoor--;
				GoLeft = false;
				angle = 270;
				//myclient.out.printf("l");
				current.setText("Current Direction: Left");
				
			
			}
			if (up &&  GoUp == true) {
				ycoor--;
				GoUp = false;
				angle = 0;
				//myclient.out.printf("s");
				current.setText("Current Direction: Up");
			}
			if (down  && GoDown == true) {
				ycoor++;
				GoDown = false;
				angle = 180;
				//myclient.out.printf("b");
				current.setText("Current Direction: Down");
				
			}
			ticks = 0;
			r = new Roomba(xcoor, ycoor, 13);
			if(add ==1) {
			Filled.add(new Obstacle(currentXClick/13, currentYClick/13, 13));
			add = 0;
			}
			
			
		}

	}

	public int getX() {
		return xcoor;
	}

	public int getY() {
		return ycoor;
	}

	public void paintComponent(Graphics g) {

		for ( int x = 0; x <= 390; x += 13 )
		 for ( int y = 0; y <= 637; y += 13 ) 
		 g.drawRect( x, y, 13, 13 );
		 r.draw(g, angle);
		 for(int x = 0;x<Filled.size();x++) {
			 
			 Filled.get(x).draw(g, angle);
		 }
		 
		 

	}

	@Override
	public void run() {
		while (running == true) {
			tick();
			repaint();
		}

	}
	

	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		//Will eventually be to show an enemy was spotted in front of roomba's current spot
//		if (key == KeyEvent.VK_E) {
//			
//		}

		// right
		if (key == KeyEvent.VK_RIGHT) {
			right = true;
			up = false;
			down = false;
			left = false;
			GoRight = true;
			//send command to go 6 inches
			//myclient.println("right");
		}
		// left
		if (key == KeyEvent.VK_LEFT) {
			left = true;
			up = false;
			down = false;
			right = false;
			GoLeft = true;
			//send command to go 6 inches

		}
		// up
		if (key == KeyEvent.VK_UP) {
			up = true;
			right = false;
			left = false;
			down = false;
			GoUp = true;
			//send command to go 6 inches
		}
		// down
		if (key == KeyEvent.VK_DOWN) {
			down = true;
			right = false;
			left = false;
			up = false;
			GoDown = true;
			//send command to go 6 inches
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		currentXClick = e.getX();
		currentYClick = e.getY();
		add = 1;
		
	}

}