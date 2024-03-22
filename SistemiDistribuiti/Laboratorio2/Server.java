package Laboratorio2;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.HashMap;
import java.util.Map;

public class Server {
 
    public static final int port = 8082;

    //mappa dei conti del client
    private static Map<SocketAddress, Integer> clientReadCount = new HashMap<>();
    
    public static void main(String args[]){
        try(var socket = new ServerSocket(port)){
            while (true){
                var client = socket.accept();
                var out = new PrintWriter(client.getOutputStream(), true);
                var in = client.getInputStream();
                //thread per gestire le varie connessioni
                new Thread(() -> handleClient(client)).start();
            }
        } catch (Exception e){
            e.printStackTrace(); System.exit(1);
        }
    }

    public static void outManager(String message, PrintWriter out){
        final int chunk = 10;
        int i;
        for (i = 0; i < message.length() - chunk; i += chunk){
            System.out.println(message.substring(i, i+chunk));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            out.write(message.substring(i, i+chunk));
            out.flush();
        }
        out.write(message.substring(i, message.length()));
        out.flush(); return;
    }

    public static void inManager(String message, InputStream in){
        byte[] read = new byte[10];
        try {
            int message2  = in.read(read, 0, 10);
        } catch (IOException e) { e.printStackTrace(); }
    }

    private static void handleClient(Socket clientSocket){
        try {
            InputStream input = clientSocket.getInputStream(); 
            byte[] buffer = new byte[10]; //buffer di 10 byte da leggere
            int count = 0; //quante volte ha letto i 10 byte per adesso
            int read;
            while ((read = input.read(buffer)) != -1){ //legge i byte fino a quando non trova un -1
                count++;
                //processa i dati...
            }
            clientReadCount.put(clientSocket.getRemoteSocketAddress(), count);
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
