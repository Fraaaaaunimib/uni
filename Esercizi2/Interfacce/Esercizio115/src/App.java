public class App {
    public static void main(String[] args){
        Quadrato a = new Quadrato(5);
        a.stampa();
    }
}

abstract class FormaDisegnabile{
    private int x, y;
    private String color;


    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCenter(int x, int y){
        this.x += x;
        this.y += y;
    }

   
}

class Quadrato extends FormaDisegnabile{
    private int lato;

    public int getLato() {
        return this.lato;
    }

    public Quadrato(int lato) {
        this.lato = lato;
    }

    public void setLato(int lato) {
        this.lato = lato;
    }
    
    public int area(){
        return this.getLato()*this.getLato();
    }

    public int perimetro(){
        return (this.getLato()*4);
    }

    public void stampa(){
        for(int i = 0; i < lato; i++){
            System.out.print("*");
        }
        System.out.println();

        for (int i = 0; i < lato-2; i++){

            System.out.print("*");
            for (int  b = 0; b < lato - 2; b++){
                System.out.print(" ");
            }
            System.out.println("*");
        }
                for(int a = 0; a < lato; a++){
                    System.out.print("*");
                
        }
    }

   
    }

    abstract class Prodotto{
         private int numeroArticoli;
        private int prezzo;
        private int sconto;

    public int getPrezzo() {
        return this.prezzo;
    }
    public int getSconto(){
        return this.sconto;
    }

    public void setSconto(int percentuale){
        this.sconto = percentuale;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    }

    abstract class PoliticaSconto{
        Prodotto prodotto;
        public int calcolaSconto(int quantita){
            return((quantita*prodotto.getPrezzo())*(prodotto.getSconto()))/100;
        }


    }

    class scontoQuantita extends PoliticaSconto{
        private int minimo;
        private int percentuale;

    public scontoQuantita(int minimo, int percentuale) {
        prodotto.setSconto(percentuale);
        this.minimo = minimo;
        this.percentuale = percentuale;
    }

    @Override
    public int calcolaSconto(int quantita){
        if (quantita > minimo) return ((quantita*prodotto.getPrezzo())*(prodotto.getSconto()))/100;
        return -1;
        
    }

    }

    class CompraNArticoliPrendiUnoGratis extends PoliticaSconto{
        private int n;

    public CompraNArticoliPrendiUnoGratis(int n) {
        this.n = n;
    }

    @Override
    public int calcolaSconto(int quantita){
        for (int i = 1; i <= quantita; i++){
            if ((i+1)%3 == 0){
                return (i+1)/3*10;
            }
        }
        return -1;
    }
    }

    class ScontoCombinato extends PoliticaSconto{

    }

    interface CodificatoreMessaggio{
         String codifica(String testoInChiaro);
    }

    class CifrarioAScorrimento implements CodificatoreMessaggio{
        int chiave;


    public int getChiave() {
        return this.chiave;
    }

    public void setChiave(int chiave) {
        this.chiave = chiave;
    }
       
    @Override
    public String codifica(String testoInChiaro) {
            int a = 0;
            for (int i = 0; i < testoInChiaro.length(); i++){
               
                (int)(a) = testoInChiaro.charAt(i);
            }
        }

        
    }