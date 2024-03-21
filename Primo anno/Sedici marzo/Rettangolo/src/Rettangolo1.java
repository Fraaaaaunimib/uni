public class Rettangolo1 {

    public int base;
    public int altezza;

    public void uguali(Rettangolo1 altroRettangolo){
        if (base == altroRettangolo.base && altezza == altroRettangolo.altezza){
            System.out.println("Ho eseguito il metodo \"uguali\", questo vuol dire che i due rettangoli hanno le stesse proprietà.");
        } else {
            System.out.println("Lmfao");
        }
    }

    public void identici(Rettangolo1 altroRettangolo){
        if (this == altroRettangolo){
            System.out.println("Identici!");
        } else {
            System.out.println("Non identici.");
        }
    }
}

class Test{
    public static void main(String[] args) {
        Rettangolo1 rettangolo = new Rettangolo1();
        System.out.println(rettangolo);

        Rettangolo1 r1 = new Rettangolo1();
        System.out.println(r1);

        r1.base = 2;
        r1.altezza = 3;

        Rettangolo1 r2 = new Rettangolo1();
        r2.base = 4;
        r2.altezza = 5;

        boolean uguaglianza =  r1.base == r2.base && r1.altezza == r2.altezza; //creo una nuova variabile booleana

        if (uguaglianza){
            System.out.println("Sono uguali.");
        } else {
            System.out.println("Nah, sono diversi."); //controllo attributi
        }

        boolean identici = r1 == r2;
        if (identici) 
        System.out.println("Si riferiscono alla stessa area di memoria");
        else
        System.out.println("In realtà non sono lo stesso oggetto."); //controllo area di memoria

        r1.uguali(r2);
        r1.identici(r2);
        r2 = r1;
        r1.identici(r2);
    }
}
