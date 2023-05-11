public class Canzone {

	private String titolo;
	private int durata;
	
	public Canzone(String titolo, int durata) {
		setTitolo(titolo);
		setDurata(durata);
	}
	
	public String getTitolo() {
		return titolo;
	}
	private void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public int getDurata() {
		return durata;
	}
	private void setDurata(int durata) {
		this.durata = durata;
	}

	@Override
	public String toString() {
		return "Canzone [titolo=" + titolo + ", durata=" + durata + "]";
	}

	public boolean equals(Canzone other) {
		if (this == other)
			return true;
		if (other == null)
			return false;
		if (durata != other.durata)
			return false;
		if (titolo == null) {
			if (other.titolo != null)
				return false;
		} else if (!titolo.equals(other.titolo))
			return false;
		return true;
	}

}
