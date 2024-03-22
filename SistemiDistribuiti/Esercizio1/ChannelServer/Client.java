package ChannelServer;
import java.io.*;
import java.net.*;
import java.util.*;

public class Client
{

	public static void main(String argv[])
	{
		BufferedReader in = null;
		PrintStream out = null;
		Socket socket = null;
		String message="";
		
		// potrebbe servire
		Random r= new Random();
		
		try
		{
			//Open a socket connection
			// ricordatevi di leggere l'input...
			// mi connetto al sesrver
			socket = new Socket("localhost", Server.port);
			System.out.println("Connesso! " + System.currentTimeMillis());
			
			//Open I/O channels
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintStream(socket.getOutputStream(), true);			

			// scrivo
			out.println(1);
			
			while (true) {
				// leggo
				message = in.readLine();
				if (message==null || message.equals("-1"))
					break; // no more bytes
			
				// uso la risposta per fare quello che voglio
				// non e' obbligatorio questo scambio di 1, e' per mettere un esempio di ciclo
				if (message.equals("1")){ // ok
					
					message=in.readLine();
					System.out.println("Received: " + message  + " " + System.currentTimeMillis());
					
					while (! message.equals("end")) {
					
							message=in.readLine();
							System.out.println("Received: " + message  + " " + System.currentTimeMillis());
					}
			
				}
				
		
			}
			
			out.close();
			in.close();
			socket.close();
		}
		catch(Exception e) { 
			e.printStackTrace();
		}
	}
}