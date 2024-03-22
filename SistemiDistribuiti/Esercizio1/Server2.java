import java.io.PrintWriter;
import java.io.InputStream;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Semplice Server che accetta un client alla volta a invia una stringa.
 * 
 * Il server si pone in ascolto alla porta 8080.
 */

class Sala {
    List<Posto> posti; String film;

    public String toString() { return film; }

    public Sala getSala() { return this; }

    public List<Posto> getPosti() { return posti; } }

class Posto {
    boolean occupato; int fila; int numero;

    public String toString() { return "Fila: " + fila + " Numero: " + numero + " Occupato: " + occupato; }

    public Posto getPosto(){ return this; } }

public class Server2 {
    public static final int port = 8081;

    public static void main(String args[]) {
        try (var socket = new ServerSocket(port)) {
            while (true) {
                System.out.println("Waiting a new client connection...");
                var client = socket.accept(); var out = new PrintWriter(client.getOutputStream(), true);
                System.out.printf("Client connected, serving on %d port\n", client.getPort());

                InputStream in = client.getInputStream(); byte date = (byte)in.read();
                System.out.println("Message received by the client: " + date);
                out_manager(date, out); out.close(); client.close();

            }
        } catch (Exception e) {
            e.printStackTrace(); System.exit(1); } }

    @SuppressWarnings("rawtypes")
    public static HashMap cinema_manager(){
        HashMap<Integer, ArrayList<Sala>> cinema = new HashMap<>();

        //lunedì
        for (int i = 0; i < 8; i++){
        ArrayList<Sala> sala = new ArrayList<>();
        sala.add(new Sala());

        switch (i){
            case 0:
                sala.get(0).film = "Star Wars - The Force Awakens"; break;
            case 1:
                sala.get(0).film = "Top Gun"; break;
            case 2:
                sala.get(0).film = "La La Land"; break;
            case 3:
                sala.get(0).film = "The Godfather"; break;
            case 4:
                sala.get(0).film = "The Shawshank Redemption"; break;
            case 5:
                sala.get(0).film = "The Dark Knight"; break;
            case 6:
                sala.get(0).film = "The Matrix"; break;
            case 7:
                sala.get(0).film = "The Matrix Reloaded"; break;
        }
        sala.get(0).posti = new ArrayList<>();
        for (int x = 0; x < 10; x++){
            sala.get(0).posti.add(new Posto());
            sala.get(0).posti.get(x).occupato = false;
            sala.get(0).posti.get(x).fila = 1;
            sala.get(0).posti.get(x).numero = x;
        }
        cinema.put(i, sala);
        }
        return cinema;
    }

    @SuppressWarnings("rawtypes")
    public static boolean booking_manager(HashMap cinema, int date){
        int date2 = date & 0xFF - '0';
        if (date2 < 1 || date2 > 7){
            return false;
        }
        System.out.println("Date received by the client: " + date2);
        ArrayList<Sala> sala = (ArrayList<Sala>) cinema.get(date2 - 1);
        if(sala != null && !sala.isEmpty()){
            Sala salaDaPrenotare = sala.get(0);
            for (int i = 0; i < salaDaPrenotare.posti.size(); i++){
                if (!salaDaPrenotare.posti.get(i).occupato){
                    salaDaPrenotare.posti.get(i).occupato = true;
                    return true;
                }
            }
        }
        return false;
    }

    public static void out_manager(byte date, PrintWriter out){

        @SuppressWarnings("unchecked")
        HashMap<Integer, ArrayList<Sala>> cinema = cinema_manager();
        
        String message = null; 
        int date2 = date & 0xFF - '0';
        if (date2 < 1 || date2 > 7){
            out.println("0\n");
            return;
        }
        System.out.println("Date received by the client: " + date2);
        ArrayList<Sala> sala = cinema.get(date2 - 1);
        message = "Elenco dei film del giorno\n";
        for (int i = 0; i < sala.size(); i++){
            message += sala.get(i).film + "\n";
        }

        boolean prenotato = booking_manager(cinema, date2);
        if (prenotato){
            message += "Prenotazione effettuata con successo\n";
        } else {
            message += "Prenotazione non effettuata\n";
        }

        final int chunk = 9;
        int i;
        for (i = 0; i < message.length() - chunk; i += chunk){
            System.out.println(message.substring(i, i + chunk));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            out.write(message.substring(i, i+chunk));
            out.flush();
        }
        System.out.println(message.substring(i, message.length()));
        out.write(message.substring(i, message.length()));
        out.flush();
        return;
    }

    }
