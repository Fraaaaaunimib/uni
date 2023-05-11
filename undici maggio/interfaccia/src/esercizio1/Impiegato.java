package esercizio1;

public class Impiegato extends Dipendente {
    public Impiegato (String nome, int matricola, double salarioMensile){
        super(nome, matricola, salarioMensile);
    }

    @Override
    public double calcolaRal(){
        return 13 * getSalarioMensile();
    }
}

class Azienda{
    private Dipendente[] dipendenti;

    public Azienda(int numDipendenti){
        if (numDipendenti <= 0) numDipendenti = 10;

        dipendenti = new Dipendente[numDipendenti];
    }

    public void aggiungiDipendente(Dipendente d){
        for (int i = 0; i < dipendenti.length; i++){
            if (dipendenti[i] == null) dipendenti[i] = d;
        }
    }

    public double costoAnnuoDipendenti(){
        double costoAnnuo = 0;
        for (int i = 0; i < dipendenti.length; i++){
            if (dipendenti[i] == null) costoAnnuo += dipendenti[i].calcolaRal();
        }
        return costoAnnuo;
    }
}
