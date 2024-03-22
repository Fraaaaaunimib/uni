package ChannelServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * 
 * Test client for NIO server
 *
 */
public class ClientChannel {

	public void startClient() throws IOException, InterruptedException {

		// qui sarebbe bene prende l'indirizzo del server come input... per ora lascio cosi' per semplicita'
		InetSocketAddress hostAddress = new InetSocketAddress("localhost", ServerChannel.PORT);
		
		// tento di collegarmi al server
		SocketChannel server = SocketChannel.open(hostAddress);

		System.out.println("Client... connected");
		// arrivato qui, sono connesso al server
		// da qui in poi dipende dalla vostra applicazione, puo' essere una sola scrittura e chiudo, o un for/while per una cosa piu' complessa
		
		// esempio di scrittura verso il server
		String threadName = Thread.currentThread().getName();
		ByteBuffer buffer = ByteBuffer.allocate(74);
		buffer.put(threadName.getBytes());
		// sempre mettere questo flip
		buffer.flip();
		server.write(buffer);
		buffer.clear();
		///
		
		// ricordatevi, quando avete finito, di chiudere questa connessione
		server.close();
	}

	public static void main(String[] args) {
		
		ClientChannel c= new ClientChannel();
		try {
			c.startClient();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}