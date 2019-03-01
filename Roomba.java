package servers;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;


public class Roomba {
	
	private int xcoor,ycoor,width,height;
	private ImageIcon roomba;

	
	public Roomba(int xcoor,int ycoor, int size) {
		this.xcoor = xcoor;
		this.ycoor = ycoor;
		this.width = size;
		this.height = size;
		roomba = new ImageIcon(getClass().getResource("up.png"));
		
		
	}
	
	public void draw(Graphics g,int Angle) {
		if(Angle==0) {
			roomba = roomba = new ImageIcon(getClass().getResource("up.png"));
			}
			else if(Angle==90){
				roomba = roomba = new ImageIcon(getClass().getResource("right.png"));	
			}
			else if(Angle==180){
				roomba = roomba = new ImageIcon(getClass().getResource("down.png"));	
			}
			else if(Angle==270){
				roomba = roomba = new ImageIcon(getClass().getResource("left.png"));	
			}
		g.drawImage(roomba.getImage(), xcoor*width, ycoor*height, width, height, null);	
		
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
