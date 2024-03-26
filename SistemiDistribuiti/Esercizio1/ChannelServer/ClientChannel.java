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
		//String threadName = Thread.currentThread().getName(); esempio
		ByteBuffer buffer = ByteBuffer.allocate(500); //buffer di scrittura
		int random = random_number(3, 3);
		String message = random_string_count(random, "ABCD");
		System.out.println("Sending: " + message + " " + System.currentTimeMillis());

		buffer.put(message.getBytes());
		// sempre mettere questo flip
		buffer.flip(); //flips the buffer from read to write and vice-versa
		server.write(buffer); //write the buffer to the channel
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
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int random_number(int min, int max){
		return (int) (Math.random() * (max-min) + min);
	}

	public String random_string_count(int random, String message){
		String result = "";
		for (int i = 0; i <= random; i++){
			result += message;
		}
		return result;
	}

}