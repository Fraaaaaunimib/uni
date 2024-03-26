package ChannelServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * This is a simple NIO based server.
 *
 */
public class ServerChannel {
	private Selector selector;

	private InetSocketAddress listenAddress;
	public final static int PORT = 3000;

	public static void main(String[] args) throws Exception {
		try {
			new ServerChannel("localhost", PORT).startServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ServerChannel(String address, int port) throws IOException {
		listenAddress = new InetSocketAddress(address, port);
	}

	/**
	 * Start the server
	 * 
	 * @throws IOException
	 */
	private void startServer() throws IOException {
		// creo il channel dove mi metto ad attendere connessioni dei client
		this.selector = Selector.open();
		ServerSocketChannel serverChannel = ServerSocketChannel.open();
		serverChannel.configureBlocking(false);

		// questo primo channel e' tipo il vecchio serversocket, e' quello che attende su porta nota
		serverChannel.socket().bind(listenAddress);
		serverChannel.register(this.selector, SelectionKey.OP_ACCEPT);

		System.out.println("Server started on port >> " + PORT);

		while (true) {
			// wait for events
			int readyCount = selector.select();
			if (readyCount == 0) {
				continue;
			}

			// process selected keys...
			Set<SelectionKey> readyKeys = selector.selectedKeys();
			Iterator iterator = readyKeys.iterator();
			while (iterator.hasNext()) {
				SelectionKey key = (SelectionKey) iterator.next();

				// Remove key from set so we don't process it twice
				iterator.remove();

				if (!key.isValid()) {
					continue;
				}

				if (key.isAcceptable()) { // Accept client connections
					this.accept(key);
					
				} else if (key.isReadable()) { // Read from client
					this.read(key);
					
				} else if (key.isWritable()) {
					// write data to client...
				}
			}
		}
	}

	// accept client connection
	// questo metodo sara' in sostanza quasi sempre così
	private void accept(SelectionKey key) throws IOException {
		// prendo il channel, che in questo caso e' quello dove attendo le nuove connessioni
		ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
		
		// accetto la connessione, che mi restituisce un nuovo socket diretto col server (tipo la vecchia accept() del server socket
		SocketChannel channel = serverChannel.accept();
		// lo metto non bloccante
		channel.configureBlocking(false);
		
		Socket socket = channel.socket();
		SocketAddress remoteAddr = socket.getRemoteSocketAddress();
		System.out.println("Connected to: " + remoteAddr);

		/*
		 * Register channel with selector for further IO (record it for read/write
		 * operations, here we have used read operation)
		 */
		// aggiungo questo nuovo channel, che corrisponde ad un socket aperto con il client, nel selettore
		// NB: di solito e' in read perche' attendo il comando dal client, ma non e' detto sia sempre così
		channel.register(this.selector, SelectionKey.OP_READ);
	}

	private HashMap<SocketAddress,Integer> readTimes = new HashMap<>();

	// read from the socket channel
	// questo metodo invece cambiera' nella logica, in base al software che state creando
	private void read(SelectionKey key) throws IOException {
		
		SocketChannel channel = (SocketChannel) key.channel();
		// mi preparo a leggere... sta a voi decidere quanto grande il buffer dovra' essere
		ByteBuffer buffer = ByteBuffer.allocate(10);
		int numRead = -1;
		// leggo, e metto quello che leggo dentro buffer, e mi viene restituito il numero dei byte letti
		numRead = channel.read(buffer);
		

		Socket socket = channel.socket();
		SocketAddress remoteAddr = socket.getRemoteSocketAddress();
		// channel chiuso
		if (numRead == -1) {
			System.out.println("Connection closed by client: " + remoteAddr);
			channel.close();
			key.cancel();
			return;
		}

		// leggo e stampo (esempi di lettura)
		byte[] data = new byte[numRead];
		System.arraycopy(buffer.array(), 0, data, 0, numRead);
		System.out.println("Got: " + new String(data));

		
		// da qui in poi ci va la logica del sistema, la reazione al comando ricevuto
		readTimes.put(remoteAddr, readTimes.getOrDefault(remoteAddr, 0) + 1);
		System.out.println("Client " + remoteAddr + " has sent " + readTimes.get(remoteAddr) + " messages");
	}
}
