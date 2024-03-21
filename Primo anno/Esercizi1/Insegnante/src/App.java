public class App {
    public static void main(String[] args) throws Exception {
       Esercizi esercizio = new Esercizi(0, 10); 
       Esercizi esercizio2 = new Esercizi(0,10);
       Esame esame = new Esame(0, 100, 25, esercizio, esercizio2, 3, 2);

       Esercizi esercizio3 = new Esercizi(0,10);
       Esercizi esercizio4 = new Esercizi(0,10);
       Esame esame2 = new Esame(0, 100, 25, esercizio3, esercizio4, 4, 2);

       Esercizi esercizio5 = new Esercizi(0,10);
       Esercizi esercizio6 = new Esercizi(0,10);
       Esame esame3 = new Esame(0, 100, 50, esercizio5, esercizio6, 4, 5);

       System.out.println();
       int tot = esame.valutaPonderato() + esame2.valutaPonderato() + esame3.valutaPonderato();
        System.out.println(esame.valutaChar(tot));
    }
}

class Esercizi{
     public int punteggio;
     public int maxPunteggio;
    

    public int getPunteggio() {
        return this.punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }

    public void setMaxPunteggio(int punteggio){
        this.maxPunteggio = punteggio;
    }
    public Esercizi(int punteggio, int punteggioMax) {
        this.punteggio = punteggio;
        this.maxPunteggio = punteggioMax;
    }


    @Override
    public String toString() {
        return "{" +
            " punteggio='" + getPunteggio() + "'" +
            "}";
    }


}

class Esame{
    private Esercizi esercizio1;
    private Esercizi esercizio2;
    private int punteggio;
    private int punteggioMax;
    private int vale;

    public void setEsercizio1(Esercizi esercizio){
        this.esercizio1 = esercizio;
    }

    public void setEsercizio2(Esercizi esercizio){
        this.esercizio2 = esercizio;
    }

    public int getPunteggio() {
        return this.punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }

    public int getPunteggioMax() {
        return this.punteggioMax;
    }

    public void setPunteggioMax(int punteggioMax) {
        this.punteggioMax = punteggioMax;
    }

    public int getVale() {
        return this.vale;
    }

    public void setVale(int vale) {
        this.vale = vale;
    }

    public void setEsame1punteggio(int punteggio){
        this.esercizio1.setPunteggio(punteggio);
    }

    public void setEsame2punteggio(int punteggio){
        this.esercizio2.setPunteggio(punteggio);
    }

    public int getEsame1punteggio(){
        return this.esercizio1.getPunteggio();
    }

    public int getEsame2punteggio(){
        return this.esercizio2.getPunteggio();
    }

    public Esame(int punteggio, int punteggioMax, int vale, Esercizi esercizio1, Esercizi esercizio2, int es1, int es2) {
        this.punteggio = punteggio;
        this.punteggioMax = punteggioMax;
        this.vale = vale;
        this.esercizio1 = esercizio1;
        this.esercizio2 = esercizio2;
        this.setEsame1punteggio(es1);
        this.setEsame2punteggio(es2);
    }


    public int valuta(){
        this.setPunteggio(this.getEsame1punteggio() + this.getEsame2punteggio());
        return (this.getPunteggio());
    }

    public int valutaPonderato(){
        double tot = 0;
        if (this.getVale() == 50){
            tot = (this.valuta() * (50.0/100.0));
        } else if (this.getVale() == 25){
            tot = (this.valuta());
            tot = tot *(25.0/100.0);
        }
        tot = (tot*100)/10;
        return ((int)tot);
        //tot:10 = punteggio: 100

    }

    public char valutaChar(int tot){
        if (tot >= 90) return 'A';
        if (tot >= 80 && tot <= 89) return 'B';
        if (tot >= 70 && tot <= 79) return 'C';
        if (tot >= 60 && tot <= 69) return 'C';
        else return 'F';
    }
    }

