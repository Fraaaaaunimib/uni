import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Semplice client che riceve una stringa da un server e la scrive su standard output.
 * 
 * Il server deve essere posto in ascolto alla porta 8080 in localhost.
 */
public class Client {
    public static final String host = "10.199.4.109";
    public static final int port = 8080;
    static byte day;

    public static void main(String args[]) {

        try (var socket = new Socket(host, port)) {
            byte[] byteReceived = new byte[1000];
            String messageString = "";
            DataInputStream in2;
            var in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            var out = socket.getOutputStream();
            var userIn = new BufferedReader(new InputStreamReader(System.in));
                
                System.out.println("Inserisci un numero da 1 a 7 per ricevere il giorno della settimana corrispondente: ");
                day = (byte) Integer.parseInt(userIn.readLine());
                
                out.write(day);
                out.flush();

                in2 = new DataInputStream(socket.getInputStream());
                int bytesRead = 0;
                while (true) {
                    bytesRead = in2.read(byteReceived);
                    if (bytesRead == -1) break;
                    messageString += new String(byteReceived, 0, bytesRead);
                }
                System.out.printf("\n \"%s\"\n", messageString);
                
                    
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}