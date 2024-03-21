public class Prodotto {
	
	private String descrizione;
	private double prezzo;
	private double sconto;
	private int iva;
	
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
	
    @Override
    public boolean equals(Object obj){
        //controlli di base
        //caso base: se in memoria hanno lo stesso oggetto
        if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof Prodotto)) return false;
		if (this.getClass() != obj.getClass()) return false;
		Prodotto p = (Prodotto)obj;
		//if (iva != obj.iva) return false;
		//if (costoBase != p.costoBase) return false;
		if (descrizione == null) {
			return p.descrizione == null;
		} else {
			return descrizione.equalsIgnoreCase(p.descrizione);
		}
    }
}

class Confezione extends Prodotto{
	private int pezzi;

	public Confezione(String descrizione, double costoBase, double iva, int pezzi){
		super(descrizione, costoBase, iva);
		this.pezzi = pezzi;
	}

	@Override
	public double getPrezzo(){
		return super.getPrezzo() * pezzi;
	}

	@Override
	public String toString(){
		return super.toString() + ", numero pezzi = " + pezzi;
	}

	@Override
	public boolean equals(Object obj){
		if (this == obj) return true;
		if (!super.equals(obj)) return false;
		Confezione c = (Confezione) obj;
		if (pezzi != c.pezzi) return false;
		return true;
	}
}

class Regalo {
	private Object contenuto;

	public Regalo(Object contenuto){
		this.contenuto = contenuto;
	}

	public String scarta() {
		return contenuto.toString();
	}

	public double getPrezzo(){
		if (contenuto instanceof Prodotto){
			Prodotto p = (Prodotto) contenuto;
			return p.getPrezzo();
		} else {
			return 0.0;
		}
	}

	public boolean guess (Object g){
		return contenuto.equals(g);
	}
}