/*
 * Sistema server per gestione catalogo online di libri
 * Tenere traccia di:
 * - classe autore --> nome e cognome (stringa unica)
 *                 --> ID unico per autore
 *                 --> classe libro
 *                      --> titolo
 *                      -->* non è possibile due libri con lo stesso titolo
 *                 --> non è possibile due autori con lo stesso nome
 * 
 * - comandi:
 *.                --> getAllAuthors: restituisce i nomi degli autori
                   --> getAuthorId: restituisce Id autore, se in elenco, o -1
                   --> addAuthor: input successivo: nome. Restituisce Id assegnato, -1 se già presente
                   --> addBook: nome autore, titolo libro. restituisce true se inserimento va a buon fine, false altrimenti
                   --> getAllBooks: restituisce elenco di tutti i libri come "autore: titolo"
                   --> getBooksOf: nome autore. Restituisce elenco di tutti i libri dell'autore, -1 in caso di autore non presente
 */

package Esercizio3;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

class Autore {
    String nome;
    List<Libro> libri;

    public String toString() { return nome; }
}

class Libro {
    String titolo;

    public String toString() { return titolo; }

    public Libro getLibro() { return this; }
}

public class Server {

    public static String getAllAuthors(Autore[] autore){
        String result = "";
        for (int i = 0; i < autore.length; i++) {
            result += autore[i].toString() + "\n";
        }
        return result;
    }

    public static String getAuthorId(Autore[] autore, String nome){
        for(int i = 0; i < autore.length; i++){
            if(autore[i].nome.equals(nome) && autore[i] != null){
                return autore[i].nome;
            }
        }
        return "-1";
    }

    public static String addAuthor(Autore[] autore, String nome){
        for(int i = 0; i < autore.length; i++){
            if(autore[i] != null && autore[i].nome != null){
                if(autore[i].nome.equals(nome)){
                    return "-1";
                }
                if(autore[i].nome.isBlank() || autore[i].nome.isEmpty()){
                    autore[i].nome = nome;
                    return autore[i].nome;
                }
            }
        }
        return "-1";
    }

    public static boolean addBook(Autore[] autore, String nome, String titolo){
        for(int i = 0; i < autore.length; i++){
            if(autore[i] != null && autore[i].nome != null && autore[i].nome.equals(nome)){
                for(int j = 0; j < autore[i].libri.size(); j++){
                    Libro libro = autore[i].libri.get(j);
                    if(libro != null && libro.titolo != null){
                        if(libro.titolo.equals(titolo)){
                            return false;
                        } else if (libro.titolo.isBlank() || libro.titolo.isEmpty()){
                            libro.titolo = titolo;
                            return true;
                        }
                    }  
                }
            }
        }
        return false;
    }

    public static String getAllBooks(Autore[] autore){
        String result = "";
        for (int i = 0; i < autore.length; i++) {
            if(autore[i] != null && autore[i].libri != null){
                for (int j = 0; j < autore[i].libri.size(); j++) {
                    Libro libro = autore[i].libri.get(j);
                    if(libro != null){
                        result += autore[i].toString() + ": " + libro.toString() + "\n";
                    }
                }
            }
        }
        return result;
    }

    public static String getBooksOf(Autore[] autore, String nome){
        for(int i = 0; i < autore.length; i++){
            if(autore[i] != null && autore[i].nome.equals(nome)){
                return autore[i].libri.toString();
            }
        }
        return "-1";
    }

    public static Autore[] initialiseCatalogue(){
        Autore[] autore = new Autore[10];
        for (int i = 0; i < autore.length; i++){
            autore[i] = new Autore();
            addAuthor(autore, "test");
            addBook(autore, "test", "test1");
            addBook(autore, "test", "test2");
        }
        return autore;

    }

    public static final int port = 8080;
    public static void main(String args[]){
        try(var socket = new ServerSocket(port)) {
            while (true){
                System.out.println(">> Waiting a new client connection...");
                var client = socket.accept();
                var out = new PrintWriter(client.getOutputStream(), true);
                System.out.printf(">> Client connected, serving on %d port\n", client.getPort());

                var in = new BufferedReader(new InputStreamReader(client.getInputStream()));

                Autore[] autore = initialiseCatalogue();
                toString(autore);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

  public static void toString(Autore[] autore) {
    for (int i = 0; i < autore.length; i++) {
      String authors = getAllAuthors(autore);
      String books = getAllBooks(autore);
        System.out.println(authors);
        System.out.println(books);
    }
  }
}
