import java.util.Scanner;
public class Daft {
    public static void main(String[] args) {
        Caratteristiche caratteristiche = new Caratteristiche("Aerodynamic");
        caratteristiche.setPunteggio(10);
        caratteristiche.setPunteggio();
    }
}

class Caratteristiche{
    private String descrizione;
    private int punteggio;

    public Caratteristiche(String descrizione){
        this.descrizione = descrizione;
        this.punteggio = 0;
    }

    public boolean Valid(int punteggio){
        return(punteggio >= 0 && punteggio <= 10);
    }

    public void setPunteggio(int punteggio){
        if (Valid(punteggio)){
            this.punteggio = punteggio;
        } else {
            System.out.println("Questo punteggio non è valido.");
        }
    }

    public void setPunteggio(){
        Scanner sc = new Scanner(System.in);
        boolean valid = false;
        while (valid == false){
            System.out.println("Inserisci il punteggio: ");
            int punteggio = sc.nextInt();
            valid = Valid(punteggio);

            if (valid) this.punteggio = punteggio;
            else System.out.println("Il punetggio non è valido.");

        }
        
    }
}
