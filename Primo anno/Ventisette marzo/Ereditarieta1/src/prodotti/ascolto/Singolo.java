package prodotti.ascolto;

public class Singolo extends CDMusicale{

	public Singolo(Canzone c, int prezzo, int sconto, Canzone[] elenco) {
        super("Singolo: "+c.getTitolo(), prezzo, sconto, new Canzone[1]);
        elenco = new Canzone[1];
        elenco[0] = c;
        setCanzoni(elenco);
	}
    
}
