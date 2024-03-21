package prodotti.ascolto;

import prodotti.Prodotto;

public class CDMusicale extends Prodotto{

    public CDMusicale(String descrizione, double prezzo, double sconto, Canzone[] playlist) {
        super(descrizione, prezzo, sconto);
        this.elencoCanzoni = elencoCanzoni;
    }

    private Canzone[] elencoCanzoni;

    @Override
    public String toString() {
         return super.toString() + elencoCanzoni.toString();
        }

    public String riproduci(){
        String s = "";
        if (elencoCanzoni != null){
            for (int i = 0; i < elencoCanzoni.length; i++){ 
                if(elencoCanzoni[i] != null){
                    s += ", " + elencoCanzoni[i].getTitolo();
                }
            }
        }
        return s;
    }

    protected void setCanzoni(Canzone[] canzoni){
        if(canzoni != null){
            if (elencoCanzoni == null){
                elencoCanzoni = new Canzone[canzoni.length];
            }
            for (int i = 0; i < elencoCanzoni.length && i < canzoni.length; i++){
                if (elencoCanzoni[i] == null){
                elencoCanzoni[i] = canzoni[i];
                }
            }
        }
    }
}
