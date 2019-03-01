package servers;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;


public class Obstacle {
	
	private int xcoor,ycoor,width,height;
	private ImageIcon obs;

	
	public Obstacle(int xcoor,int ycoor, int size) {
		this.xcoor = xcoor;
		this.ycoor = ycoor;
		this.width = size;
		this.height = size;
		obs = new ImageIcon(getClass().getResource("Obstacle.png"));
		
		
	}
	
	public void draw(Graphics g,int Angle) {
		
		g.drawImage(obs.getImage(), xcoor*width, ycoor*height, width, height, null);	
		
	}


	public int getXcoor() {
		return xcoor;
	}

	public void setXcoor(int xcoor) {
		this.xcoor = xcoor;
	}

	public int getYcoor() {
		return ycoor;
	}

	public void setYcoor(int ycoor) {
		this.ycoor = ycoor;
	}

}