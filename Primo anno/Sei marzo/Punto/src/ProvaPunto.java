public class ProvaPunto{
    public static void main(String[] args){

        //creazione di un nuovo oggetto: new NomeClasse()
        new Punto();
        /* Punto è dall'altro file java all'interno del progetto, ovvero "Punto" 
         * Crea un nuovo oggetto "custom" dalla classe Punto
        */

        //dichiarazione variabile locale al metodo
        int x;
        int v = 3;
        int w = 3;

        Punto p1;
        p1 = new Punto(); //oggetto di tipo punto custom

        Punto p2;
        p2 = new Punto();

        System.out.println("E' stato eseguito tutto senza problemi.");

        /* le variabili locali vengono inserite all'interno dello stack. 
         * In questo caso della keyword, viene prima creato l'oggetto, e successivamente viene assegnato a "p1".
         * Con questo, si accede a un'altra area di memoria chiamata "heap", viene cercata la prima area di memoria contigua libera che possono
         * contenere l'oggetto "Punto".
         * 
         * heap 
         * \    \
         * \    \
         * \ 0  \
         * \ 0  \ --> oggetti sono in aree di memorie, indirizzi
         * \ 0  \
         * \ 0  \ --> variabili definite all'interno di Punto.java
         * ------
         * 
         * stack
         * \    \
         * \    \
         * \    \
         * \ 800 \ --> corrispondente al secondo oggetto
         * \ 3  \ --> v
         * \ 1000 \ --> corrispondente al primo oggetto
         * \ 3   \ --> le variabili "3" sono delle variabili di esempio con valore 3. questa è w.
         */


    //identità:
    boolean esito;
    esito = v == w;
    System.out.println("v e w: " + esito);
    // operatore == serve a verificare se due variabili sono uguali come identità. in questo caso, entrambi valgono tre, quindi è "true".

    esito = p1 == p2;
    System.out.println("p1 e p2: " + esito);
    // nel caso di tipi complessi, verifica se si tratta dello stesso oggetto o no.

    //step in: va all'interno del metodo che è eseguito; step out: va oltre.

    //stato: valore di x e y (valori all'interno dell'oggetto referenziato). in questo caso, p1 e p2 sono uguali se x1 = x2, e y1 = y2
    /* modo per accedere agli attributi:
     *  id.attributo <-- accede all'attributo dell'oggetto referenziato da id
     */

    esito = (p1.x == p2.x) && (p1.y == p2.y); //così sto accedendo singolarmente le proprietà degli oggetti, come in Visual Basic
    System.out.println("Accedere singolarmente alle proprietà. Sono uguali i due oggetti? " + esito);

    p1.x = 1;
     p1.y = 1;
     //si possono assegnare valori alle variabili come su visual basic.
     esito = (p1.x == p2.x) && (p1.y == p2.y); 
     System.out.println("Accedere singolarmente alle proprietà. Sono uguali i due oggetti? Adesso ho modificato le proprietà: " + esito);

     //assegnazione di un valore memorizzato in un'altra variabile., never be
     Punto p3 = p1; //vale come con prima - stessa area di memoria

     p2 = null;
     //assegnare il valore di default ai tipi complessi. il valore di default è "null", inizializzato ma non fa riferimetno a niente.

     p1 = new Punto();
     p2 = p1;
     p1 = new Punto();
    }

}