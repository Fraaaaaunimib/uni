
public class Compitino {

    public static void main(String[] args) {
    
        Playlist playlist1 = new Playlist("Dua Lipa");
        Brano loveAgain = new Brano("Love Again", 2450);
        Brano breakHeart = new Brano("Break My Heart", 3000);
        playlist1.aggiungiBrano(loveAgain);
        playlist1.aggiungiBrano(breakHeart);

        playlist1.play();
    }
    



}

class Playlist{
        
    private String titolo;
    private Brano[] brani;

    public Playlist(String titolo, int numeroBrani){
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



    public Playlist(String titolo){
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
        try {
        if (brano == null) return -1;
        for (int i = 0; i < brani.length; i++){
        if (brani[i].equals(brano)){
            return i;
        }
    }
    } catch (NullPointerException e) {

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

        public int play(){
            int totale = 0;
            try{
            
            for(int i = 0; i < brani.length; i++){
            System.out.println("Titolo brano no. " + i+1 + " : " + brani[i].getTitolo() + ", durata del brano: " + brani[i].getDurataInSecondi());
                totale += brani[i].getDurataInSecondi();
        
        }
    } catch (NullPointerException e){

    
        
    }
    return totale;
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