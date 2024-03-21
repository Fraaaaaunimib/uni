public class Appa {
    public static void main(String[] args)  {
    
        PromotoreConcerto amedeo = new PromotoreConcerto(50, 0, 7, 8, 0, "Daft Punk", false);
       amedeo.aggiungiBiglietti(70);
       amedeo.cambiaPosto();
        System.err.println(amedeo.toString());
    }
}

class PromotoreConcerto{
    private int capacita;
    private int bigliettiVenduti;
    private int prezzoTelefono;
    private int prezzoPosto;
    private int totale;
    private String nomeGruppo;
    private boolean posto;

    public void aggiungiBiglietti(int numero){
        if (numero > 0){
            bigliettiVenduti += numero;
            if (bigliettiVenduti > capacita) 
            bigliettiVenduti = capacita;
        }
    }

    public void cambiaPosto(){
        this.posto = true;
    }

public int getBigliettiVenduti(){
  return(this.bigliettiVenduti);  
}

public int getTotaleBig(){
    return(this.capacita);
}

public int totale(){
    if (this.posto) return (prezzoPosto*bigliettiVenduti);
    else return (prezzoTelefono*bigliettiVenduti);
}


    public PromotoreConcerto(int capacita, int bigliettiVenduti, int prezzoTelefono, int prezzoPosto, int totale, String nomeGruppo, boolean posto) {
        this.capacita = capacita;
        this.bigliettiVenduti = bigliettiVenduti;
        this.prezzoTelefono = prezzoTelefono;
        this.prezzoPosto = prezzoPosto;
        this.totale = totale;
        this.nomeGruppo = nomeGruppo;
        this.posto = posto;
    }


    public int getCapacita() {
        return this.capacita;
    }

    public void setCapacita(int capacita) {
        this.capacita = capacita;
    }
    public void setBigliettiVenduti(int bigliettiVenduti) {
        this.bigliettiVenduti = bigliettiVenduti;
    }

    public int getPrezzoTelefono() {
        return this.prezzoTelefono;
    }

    public void setPrezzoTelefono(int prezzoTelefono) {
        this.prezzoTelefono = prezzoTelefono;
    }

    public int getPrezzoPosto() {
        return this.prezzoPosto;
    }

    public void setPrezzoPosto(int prezzoPosto) {
        this.prezzoPosto = prezzoPosto;
    }

    public int getTotale() {
        return this.totale;
    }

    public void setTotale(int totale) {
        this.totale = totale;
    }

    public String getNomeGruppo() {
        return this.nomeGruppo;
    }

    public void setNomeGruppo(String nomeGruppo) {
        this.nomeGruppo = nomeGruppo;
    }

    public boolean isPosto() {
        return this.posto;
    }

    public boolean getPosto() {
        return this.posto;
    }

    public void setPosto(boolean posto) {
        this.posto = posto;
    }
    

    @Override
    public String toString() {
        return "{" +
            " capacita='" + getCapacita() + "'" +
            ", bigliettiVenduti='" + getBigliettiVenduti() + "'" +
            ", prezzoTelefono='" + getPrezzoTelefono() + "'" +
            ", prezzoPosto='" + getPrezzoPosto() + "'" +
            ", totale='" + totale() + "'" +
            ", nomeGruppo='" + getNomeGruppo() + "'" +
            ", posto='" + isPosto() + "'" +
            "}";
    }
    
}
