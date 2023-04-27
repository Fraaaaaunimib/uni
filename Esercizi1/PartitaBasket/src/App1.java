import java.util.Scanner;
public class App1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PartitaBasket campio = new PartitaBasket("Daft Punk", "Justice", 0, 0, false);
        boolean primo = true;

        while(campio.getPunteggioPrima() < 5 && campio.getPunteggioSeconda() < 5){
            int punteggio = sc.nextInt();
            if (punteggio == 1 && primo == true){
                campio.Canestro1(1);
            } else if (punteggio == 2 && primo == true){
                campio.Canestro2(1);
            } else if (punteggio == 3 && primo == true){
                campio.Canestro3(1);
            } else if (punteggio == 1 && primo == false){
                campio.Canestro1(2);
            } else if (punteggio == 2 && primo == false){
                campio.Canestro2(2);
            } else if (punteggio == 3 && primo == false){
                campio.Canestro3(3);
            }

            if (primo) primo = false;
            else primo = true;
            System.out.println(campio.getPrima() + ": " + campio.getPunteggioPrima() + " " + campio.getSeconda() + ": " + campio.getPunteggioSeconda() + " , finita: " + campio.getFinita());
        }
        campio.setFinita(true);
        System.out.println(campio.getPrima() + ": " + campio.getPunteggioPrima() + " " + campio.getSeconda() + ": " + campio.getPunteggioSeconda() + " , finita: " + campio.getFinita());
    }
}

class PartitaBasket{
    private String prima;
    private String seconda;
    private int punteggioPrima;
    private int punteggioSeconda;
    private boolean finita;


    public PartitaBasket(String prima, String seconda, int punteggioPrima, int punteggioSeconda, boolean finita) {
        this.prima = prima;
        this.seconda = seconda;
        this.punteggioPrima = punteggioPrima;
        this.punteggioSeconda = punteggioSeconda;
        this.finita = finita;
    }

    public String getPrima() {
        return this.prima;
    }

    public void setPrima(String prima) {
        this.prima = prima;
    }

    public String getSeconda() {
        return this.seconda;
    }

    public void setSeconda(String seconda) {
        this.seconda = seconda;
    }

    public int getPunteggioPrima() {
        return this.punteggioPrima;
    }

    public void setPunteggioPrima(int punteggioPrima) {
        this.punteggioPrima = punteggioPrima;
    }

    public int getPunteggioSeconda() {
        return this.punteggioSeconda;
    }

    public void setPunteggioSeconda(int punteggioSeconda) {
        this.punteggioSeconda = punteggioSeconda;
    }

    public boolean isFinita() {
        return this.finita;
    }

    public boolean getFinita() {
        return this.finita;
    }

    public void setFinita(boolean finita) {
        this.finita = finita;
    }

    public void Canestro1(int squadra){
        if (squadra == 1) this.setPunteggioPrima(getPunteggioPrima()+1);
        else if (squadra == 2) this.setPunteggioSeconda(getPunteggioSeconda()+1);
    }

    public void Canestro2(int squadra){
        if (squadra == 1) this.setPunteggioPrima(getPunteggioPrima()+2);
        else if (squadra == 2) this.setPunteggioSeconda(getPunteggioSeconda()+2);
    }

    public void Canestro3(int squadra){
        if (squadra == 1) this.setPunteggioPrima(getPunteggioPrima()+3);
        else if (squadra == 2) this.setPunteggioSeconda(getPunteggioSeconda()+3);
    }

    
    public String vincita(){
        if (this.finita){
            if (this.getPunteggioPrima()>this.getPunteggioSeconda()) return this.getPrima();
            if (this.getPunteggioSeconda()>this.getPunteggioPrima()) return this.getSeconda();
        } else {
            return "Non è finita";
        }
        return "e";
    }


}
