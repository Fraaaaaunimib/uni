package prodotti.lettura;

import prodotti.Prodotto;

public class Libro extends Prodotto {

    public Libro(double prezzo, double sconto, String titolo, String autore, String[] pagine) {
        super(titolo, prezzo, sconto);
        this.autore = autore;
        this.pagine = pagine;
    }

    private String autore;
    protected String[] pagine;

    @Override
    public String toString() {
        return super.toString() + "{" +
                " autore='" + getAutore() + "'" +
                ", pagine='" + getPagine() + "'" +
                "}";
    }

    public String getAutore() {
        return this.autore;
    }

    public int getPagine() {
        if (pagine != null)
            return this.pagine.length;

        return -1;
    }

    public String sfoglia() {
        String s = "";
        if (pagine != null) {
            for (int i = 0; i < pagine.length; i++) {
                if (pagine[i] != null) s += pagine[i];
            }
        }
        return s;
    }
}
