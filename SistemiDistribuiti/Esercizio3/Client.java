package Esercizio3;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Client {
    public static final String host = "127.0.0.1";
    public static final int port = 8080;

    public static void main(String args[]){
        try(var socket = new Socket(host, port)) {
            byte[] byteReceived = new byte[1000];
            String messageString = "";
            DataInputStream in2;
            var in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            var out = socket.getOutputStream();
            var userIn = new BufferedReader(new InputStreamReader(System.in));

            out.flush();
            in2 = new DataInputStream(socket.getInputStream());
            int bytesRead = 0;
            while (true) {
                bytesRead = in2.read(byteReceived);
                if (bytesRead == -1) break;
                messageString += new String(byteReceived, 0, bytesRead);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}