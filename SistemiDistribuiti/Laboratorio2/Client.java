package Laboratorio2;
import java.io.*; import java.net.*; import java.util.*;

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost", 8082);
        OutputStream output = socket.getOutputStream();
        Random random = new Random();
        int X = random.nextInt(50); //facciamo partire le connessioni al server per un numero random di volte

        for (int i = 0; i < X; i++){
            output.write("Hello world".getBytes()); //ottieni i byte della stringa piuttosto che la stringa stessa, viene letto dal buffer
            Thread.sleep(500);
        }
        socket.close();
    }
}
