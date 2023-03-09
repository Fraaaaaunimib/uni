public class Studente {
    
    public int matricola;
    public String cognome;
    public String nome;

    //creazione dell'oggetto
    //all'interno di Studente perchè la freccia è da studente a libretto
    //nome dell'oggetto: ruolo
    public Libretto libretto;
}

class Libretto { //you should put each class into its own file afterwards; for now, it's better like this

    //creazione di esami di esempio.
    public Esame esame1, esame2, esame3;{
    esame1 = new Esame();
    esame2 = new Esame();
    esame3 = new Esame();
    }
}

class Esame {

    public String data;
    public int voto;

    //freccia
    public Insegnamento insegnamento; 

}

class Laureando{

    //freccia
    public Studente studente;
    public Docente relatore;
    public Docente correlatore;

}

class Tesi{

    public String argomento;
    //freccia
    public Laureando laureando;

}

class Docente{

    public String nome;
    public String cognome;

}

class Insegnamento{

    public String denominazione;
    public String id;
    public int cfu;
}

class Test{

    public static void main (String[] args) throws Exception {

        System.out.println("Hi!");
        
        //creazione di un nuovo studente
        Studente studente1 = new Studente(); //valore di default: null
        
        //accedere alle variabili all'interno di studente1
        studente1.cognome = "Rossi";
        studente1.nome = "Mario";
        studente1.matricola = 900124;
        
        //dati del libretto
        Libretto libretto1 = new Libretto();
        //dati dell'esame all'interno del libretto
        Insegnamento insegnamento1 = new Insegnamento();
        
        

        //assegnare gli oggetti
        //ricordarsi che non puoi creare così dal nulla oggetti, ma li devi assegnare ai rispettivi tipi di oggetto.
        studente1.libretto = libretto1;
        studente1.libretto.esame1 = new Esame();
        studente1.libretto.esame1.insegnamento = insegnamento1;
        
        libretto1.esame1.data = "01/02/23";
        //denominazione dell'insegnamento
            libretto1.esame1.insegnamento.cfu = 28;
            libretto1.esame1.insegnamento.denominazione = "Programmazione";
            libretto1.esame1.insegnamento.id = "Prog";
        libretto1.esame1.voto = 28;

        //mostra :3
        System.out.println("Il primo studente si chiama " + studente1.nome + " " + studente1.cognome + ", con matricola " + studente1.matricola);
        System.out.println("L'esame che è stato conseguito è stato " + libretto1.esame1.insegnamento.denominazione + ", con " + libretto1.esame1.insegnamento.cfu + " CFU e ID " + libretto1.esame1.insegnamento.id + ", conseguito in data " + libretto1.esame1.data + " con voto " + libretto1.esame1.voto + ". ");
    }
}