package Esercizi3;

public class Azienda {
	
	private Dipendente[] dipendenti;
	
	public Azienda(int maxDipendenti) throws AziendaException{
		if (maxDipendenti > 0) {
			dipendenti = new Dipendente[maxDipendenti];
		} else {
			throw new AziendaException();
		}
	}
	
	public void aggiungiDipendente(Dipendente d) {
		if (d != null) {
			for (int i = 0; i < dipendenti.length; i++) {
				if (dipendenti[i] == null) {
					dipendenti[i] = d;
					break;
				}
			}
		}
	}
	
	public double costoAnnuoDipendenti() {
		double costo = 0;
		for (int i = 0; i < dipendenti.length; i++) {
			if (dipendenti[i] != null) {
				costo += dipendenti[i].calcolaRal();
			}
		}
		return costo;
	}

}
