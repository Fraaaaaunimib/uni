package prodotti.lettura;

public class Manga extends Libro{

    private String titoloOriginale;

    public Manga(double prezzo, double sconto, String titolo, String autore, String[] pagine, String titoloOriginale) {
        super(prezzo, sconto, titolo, autore, pagine);
        this.titoloOriginale = titoloOriginale;
    }

    @Override
    public String sfoglia(){
        String s = "";
        if (pagine != null) {
            for (int i = pagine.length - 1; i >= 0; i--) {
                if (pagine[i] != null) s += pagine[i];
            }
        }
        return s;
    }
 
    @Override
    public String toString(){
        String s = super.toString();
        s += ", titolo in lingua originale: " + titoloOriginale;
        return s;
    }
}
