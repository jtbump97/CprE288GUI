package servers;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

import java.io.OutputStream;
public class MyCLient {
    Socket socket;
    Scanner scanner;
    OutputStream output;
    PrintWriter out;
    BufferedReader in;
    Reader inRead;
    
    MyCLient(String serverAddress, int serverPort) {
    	try {
			socket = new Socket("192.168.1.1", 288);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			out = new PrintWriter(socket.getOutputStream(), true);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

       
    }
  
}