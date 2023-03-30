import java.util.Arrays;

public class App {
}

    class Azienda{
	public String nome;
	
	public Dipendente[] dipendenti;

	public Azienda(String nome, int numDip) {
		this.nome = nome;
		if (numDip <= 0)
			numDip = 1;
		dipendenti = new Dipendente[numDip];
		
	}
	
	public Azienda() {
		this("Azienda", 1);
	}
	
	public boolean assumi(String cognome, String nome, double costo, int matricola) {
		
//for (int i = 0; i < dipendenti.length; i++) {
//			if (dipendenti[i] == null) {
//				dipendenti[i] = new Dipendente(cognome, nome, matricola, costo);
//				return true;
//			}
//		}
//		return false;
		
		return assumi(new Dipendente(cognome, nome, matricola, costo));
	}
	
	public boolean assumi(Dipendente nuovoDip) {
		for (int i = 0; i < dipendenti.length; i++) {
			if (dipendenti[i] == null) {
				dipendenti[i] = nuovoDip;
				return true;
			}
		}
		return false;
	}

	public boolean setNumDip(int nuovoNumDip){
		//ritorna true se riesce a settare l'array di dipendenti a nuovoNumDip

		if (nuovoNumDip <= 0){
			return false;
		}
	Dipendente[] nuovoArrayDipendenti = new Dipendente[nuovoNumDip];
	int j = 0;
	int numeroDipendentiEffettivo = 0;
 
	for (Dipendente dipendente : dipendenti){
		if (dipendente != null){
			numeroDipendentiEffettivo++;
		}
	}

	if (numeroDipendentiEffettivo < nuovoNumDip){

		for (int i = 0; i < dipendenti.length; i++){
		if (dipendenti[i] != null){
			nuovoArrayDipendenti[i] = dipendenti[i];
			j++;
		}
	}	
	dipendenti = nuovoArrayDipendenti;
	return true;
} else{
	return false;
}

	
		}
	
	
	
	public double calcolaCosto() {
		double costoTotale = 0.0;
//		for (int i = 0; i < dipendenti.length; i++) {
//			if (dipendenti[i] != null) {
//				costoTotale += dipendenti[i].costo;
//			}
//		}
		
		for (Dipendente dipendente : dipendenti) {
			if (dipendente != null) {
				costoTotale += dipendente.getCosto();
			}
		}
		return costoTotale;
	}
	
        public Dipendente licenzia(int matricola) {
            for (int i = 0; i < dipendenti.length; i++) {
                if (dipendenti[i] != null && dipendenti[i].getMatricola() == matricola) {
                    Dipendente temp = dipendenti[i];
                    dipendenti[i] = null;
                    return temp;
                }
            }
            return null;
        }
        
        public Dipendente licenzia(Dipendente dip) {
            return dip == null ? null : licenzia(dip.getMatricola());
        }
	
	public boolean contains(int matricola) {
		for (Dipendente dipendente : dipendenti) {
			if (dipendente != null && dipendente.getMatricola() == matricola)
				return true;
		}
		
		return false;
	}
	
	public boolean contains (Dipendente dip) {
//return dip == null ? false : contains(dip.matricola);
		if (dip == null)
			return false;
		return contains(dip.getMatricola());
			
	}

	public int numDip(){
			return dipendenti.length;
	}

	private int getnewMatricola(){
		int matricolaMassima = 0;
		for (Dipendente dipendente : dipendenti){
			if (dipendente != null && dipendente.getMatricola() > matricolaMassima){
				matricolaMassima = dipendente.getMatricola();
			}
		}

		return matricolaMassima+1;
	}
	@Override
	public String toString() {
		return "Azienda [nome=" + nome + ", dipendenti=" + Arrays.toString(dipendenti) + ", calcolaCosto()="
				+ calcolaCosto() + "]";
	}
	
}

class Dipendente {
	
	private String nome, cognome;
	private int matricola;
	private double costo;
	
	public String getNome(){
        return nome;
    }

    public double getCosto(){
        return costo;
    }

    public int getMatricola(){
        return matricola;
    }
    public void setCosto(int costo){
        this.costo = costo;
    } 

    public void setMatricola(int matricola){
        this.matricola = matricola;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

	public Dipendente() {
		this("Innominato", "Innominato", 0);
	}
	
	public Dipendente(String cognome, String nome, int matricola) {
		this(cognome, nome, matricola, 1000.0);
	}
	
	public Dipendente(String cognome, String nome, int matricola, double costo) {
		this.cognome = cognome;
		this.nome = nome;
		this.matricola = matricola;
		if (costo > 0)
			this.costo = costo;
		else
			this.costo = 0;
	}

	public String toString() {
		return "Dipendente [nome=" + nome + ", cognome=" + cognome + ", matricola=" + matricola + ", costo=" + costo
				+ "]";
	}

	
	public boolean equals1(Dipendente dip) {
//		if (this == dip) {
//			return true;
//		}
//		if (dip != null && this.matricola == dip.matricola) {
//			return true;
//		}
//		
//		return false;
//		return this == dip;
		
		return (dip != null && this.matricola == dip.matricola);
	}
	
	
	
	
	
}

class Test {

	public static void main(String[] args) {
		Dipendente d1 = new Dipendente();
		
		Dipendente d2 = new Dipendente("Cognome", "Nome", 1, 1500.0);
//		Dipendente d2 = new Dipendente();
//		d2.cognome = "Cognome";
//		d2.nome = "Nome";
//		d2.matricola = 1;
//		d2.costo = 1500.0;
		Dipendente d3 = new Dipendente("Cognome", "Nome", 0, 1500.0);
		System.out.println(d2.toString());
		System.out.println(d1.equals(d1));
		System.out.println(d1.equals(d2));
		System.out.println(d1.equals(null));
		System.out.println(d1.equals(d3));
		
		Azienda azienda = new Azienda("ACME", 5);
		
		azienda.assumi("Cognome", "Nome", 2000.0, 3);
		azienda.assumi(d1);
		
		System.out.println(azienda.calcolaCosto());
		
		System.out.println(azienda);
	}
	
	
	
}