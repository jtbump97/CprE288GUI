package servers;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Main extends JFrame {
	
	private GUIBackend gui;
	private static MyCLient client;
	public Socket socket;
	public OutputStream output;
	public PrintWriter out;
	TextAreaOutputStream taos;

	public Main() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("JACS INC");
		
		//MyCLient client = new MyCLient("192.168.1.1", 288);

		setLayout(new GridLayout(1, 1, 0, 0));
		JTextArea cur = new JTextArea();
		cur.setSize(20, 676);
		cur.setBackground(Color.lightGray);
		cur.setSelectedTextColor(Color.WHITE);
		gui = new GUIBackend(client,cur);
		add(gui);
		

		setLocationRelativeTo(null);
		setVisible(true);
		JTextArea ta = new JTextArea();
		TextAreaOutputStream taos = new TextAreaOutputStream(ta, 100);
		PrintStream ps = new PrintStream(taos);
		System.setOut(ps);
		System.setErr(ps);
	
		
		add(new JScrollPane(ta));
		add(cur);

		setVisible(true);
		pack();
	}
	
	public static void main(String[] args) {
		new Main();
		System.out.println("Connected to Roomba");
		
		
		
	}


}
