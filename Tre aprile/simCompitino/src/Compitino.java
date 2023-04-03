public class Compitino {

    
}

class Playlist{
        
    private String titolo;
    private Brano[] brani;

    private Playlist(String titolo, int numeroBrani){
        this.titolo = titolo;
        if (numeroBrani < 1){
            numeroBrani = 20; //capienza massima
        }
        brani = new Brano[numeroBrani];

    }

    public String getTitolo() {
        return this.titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }



    private Playlist(String titolo){
        this(titolo, 20); //richiamo il primo costruttore
    }

/*     public boolean contiene(Brano brano){
        if (brano == null){
        return false;
        }

        for (Brano b : brani){
            if (b != null && b.equals(brano)){
                return true;
            }
        }

        return false;
    }
    */

    public boolean contiene(Brano brano){
        int posizione = posizioneBrano(brano);
        if(posizione == -1) return false;
        else return true;

    }

    public boolean aggiungiBrano(Brano brano){
        if (brano == null)
        return false;

        if (contiene(brano))
        return false;

        for (int i = 0; i < brani.length; i++){
            if (brani[i] == null){
                brani[i] = brano;
                return true;
            }

        }

        return false; //array pieno

    }

    public boolean aggiungiBrano(String Titolo, int durataInSecondi){
        return aggiungiBrano(new Brano(titolo, durataInSecondi));
    }

    public int posizioneBrano(Brano brano){
        if (brano == null) return -1;
        for (int i = 0; i < brani.length; i++){
        if (brani[i].equals(brano)){
            return i;
        }
    }

        return -1;
    }

    public Brano rimuoviBrano(Brano brano){
        if(contiene(brano)){
            for(int i = 0; i< brani.length; i++){
                if(brani[i] != null && brani[i].equals(brano)){
                    Brano temp = brani[i];
                    brani[i] = null;
                    return temp;
                }
                    
                }
            }
            return null;
        }
    }



class Brano{
    private String titolo;
    private int durataInSecondi;

    public Brano(String titolo, int durataInSecondi){
        this.titolo = titolo;
        this.durataInSecondi = durataInSecondi;
    }

    /**
     * @return String return the titolo
     */
    public String getTitolo() {
        return titolo;
    }

    /**
     * @param titolo the titolo to set
     */
   // public void setTitolo(String titolo) {
    //    this.titolo = titolo;
    //}

    /**
     * @return int return the durataInSecondi
     */
    public int getDurataInSecondi() {
        return durataInSecondi;
    }

    /**
     * @param durataInSecondi the durataInSecondi to set
     */
    //public void setDurataInSecondi(int durataInSecondi) {
    //    this.durataInSecondi = durataInSecondi;
    //}


    @Override
    public String toString() {
        return "{" +
            " titolo='" + getTitolo() + "'" +
            ", durataInSecondi='" + getDurataInSecondi() + "'" +
            "}";
    }

    public boolean equals(Brano altroBrano){
        if (titolo.equals(altroBrano.getTitolo())){
        return true;
        }
        return false;

    }
}