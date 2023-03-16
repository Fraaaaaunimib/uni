import java.util.Scanner;
public class Studente {
    
    public int matricola;
    public String cognome;
    public String nome;

    //creazione dell'oggetto
    //all'interno di Studente perchè la freccia è da studente a libretto
    //nome dell'oggetto: ruolo
    public Libretto libretto;

    public void aggiungiEsame(int voto, String data, Insegnamento insegnamento){
        Esame nuovoEsame = new Esame();
        nuovoEsame.data = data;
        nuovoEsame.voto = voto;
        nuovoEsame.insegnamento = insegnamento;
        
        for (int i = 0; i < libretto.esami.length; i++){
            if (libretto.esami[i] == null){
                libretto.esami[i] = nuovoEsame;
                break;
            }
        }
    }

    public int contaCrediti(){
        int creditiTotali = 0;

            for (int i = 0; i < libretto.esami.length;i++){
                if (libretto.esami[i] != null && libretto.esami[i].insegnamento != null)
                creditiTotali += libretto.esami[i].insegnamento.cfu;

            }
        return creditiTotali;
    }
}

class Libretto { //you should put each class into its own file afterwards; for now, it's better like this

    //creazione di esami di esempio.
    public Esame[] esami;
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

