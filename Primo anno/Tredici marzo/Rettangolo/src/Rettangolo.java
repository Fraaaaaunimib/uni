public class Rettangolo{
    
    public int base;
    public int altezza;

    public int calcolaArea(){
        int area; //non posso vedere area da fuori.
        area = this.base * this.altezza; //this è implicito --> è implicito perché non ha "static"
        return area;
    }
    public boolean equals(int b, int a){
        if (this.base == base && this.altezza == altezza){
            return true;
        } else {
            return false;
        }
    }

    public String toString(){
        String stato;
        int area = this.calcolaArea();
        stato = "Rettangolo di i'm base " +
                base + ", altezza " +
                altezza + " e area " +
                area;
        return stato;
    }
}

class ProvaMetodi{
    public static void main(String[] args) {
        Rettangolo r1 = new Rettangolo();
        r1.base = 2;
        r1.altezza = 4;

        Rettangolo r2 = new Rettangolo();
        r2.base = 4;
        r2.altezza = 8;

        /* STACK
        in basso: 1000
        in basso: 800
         * HEAP
         * base 2 altezza 4 --> r1
         * base 4 altezza 2 --> r2
         */

         int a1 = r1.calcolaArea();
         int a2 = r2.calcolaArea();
        
         
         //metodi equals
         //sapere se un oggetto non è all'interno di una collezione - sapere se c'è già un oggetto uguale
         boolean esito = r1.equals(2, 4); //se 2. è la base, e 4 è l'altezza allora è vero.
         System.out.println(esito);

         esito = r1.equals(10, 24);
         System.out.println(esito);

         String stato = r1.toString();
         String stato2 = r2.toString();
         System.out.println(stato);
         System.out.println(stato2);

    }
}