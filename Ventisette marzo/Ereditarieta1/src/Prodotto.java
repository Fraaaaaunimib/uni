
public class Prodotto {
	
	private String descrizione;
	private double prezzo;
	private double sconto;
	
	public Prodotto(String descrizione, double prezzo, double sconto) {
		setDescrizione(descrizione);
		setPrezzo(prezzo);
		setSconto(sconto);
	}
	
	public String getNome() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public double getSconto() {
		return sconto;
	}
	public void setSconto(double sconto) {
		this.sconto = sconto;
	}

	@Override
	public String toString() {
		return "descrizione=" + descrizione + ", prezzo=" + prezzo + ", sconto=" + sconto;
	}
	
	public double calcolaCosto() {
		return prezzo - (prezzo * sconto ) / 100;
	}
	
}
