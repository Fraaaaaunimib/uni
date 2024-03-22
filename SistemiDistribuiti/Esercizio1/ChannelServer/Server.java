package ChannelServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int port = 3000;
	
	private static ServerSocket Server;
	
	public static void main(String argv[]) throws Exception
	{
		Server s=new Server();
				
		s.loopCycle();
	}
	
	public Server()
	{
		//Create the server and run it
		try {
			// mi metto in ascolto su porta nota
			Server = new ServerSocket(port);
			System.out.println("Server listening on port: " + port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Server errore in apertura porta.");
			e.printStackTrace();
		}
		
	}
	
	public void loopCycle()
	{
		while(true)
		{

			PrintStream out = null;
			BufferedReader in = null;
			
			try {
				// accetto una connessione del client
				System.out.println("Waiting for connection.");
				Socket client = Server.accept();
				System.out.println("Connection accepted from: "+ client.getInetAddress() + " porta " + client.getPort());
				
				in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				out = new PrintStream(client.getOutputStream(), true);			
				
				try
				{

					String command=in.readLine();
					
					if(command.equals("1")){
						
						System.out.println("ricevuto comando");
						
						// rispondo
						out.println(1);
						
						// chiudo, ma e' un esempio
						out.println("end");
						
						//Remember to flush
						out.flush();
						
						// serve per lasciare al client il tempo di finire di leggere
						Thread.sleep(1000);
						//Close streams and connection
						
					}
					else{
						out.write(0);
						out.println("end");
					}
					
					out.close();
					in.close();
					client.close();

				}
				catch(Exception e) {System.out.println(e.getMessage());}
			}
			catch(Exception e) {System.out.println(e.getMessage());}
		}
	}
}
