public class Occupazione {
    public static void main(String[] args) {
        OccupazioneStanza occu = new OccupazioneStanza();
        for (int i = 0; i < 7; i++){
            occu.aggiungiUnoAllaStanza();
        }

        System.out.println(occu.getnumeroStanza() + " " + occu.getnumeroTotale());
        
        for (int i = 0; i < 8; i++){
            occu.rimuoviUnoDallaStanza();
        }
        System.out.println(occu.getnumeroStanza() + " " + occu.getnumeroTotale());
    }
}

class OccupazioneStanza{
    private int numeroNellaStanza=0;
    private int numeroTotale=5;

    public void aggiungiUnoAllaStanza(){
        this.numeroNellaStanza++;
        this.numeroTotale++;
    }

    public void rimuoviUnoDallaStanza(){
        if (numeroNellaStanza - 1 > 0 && numeroTotale-1 > 0){
            numeroNellaStanza--;
            numeroTotale--;
        } 
    }

    public int getnumeroStanza(){
        return this.numeroNellaStanza;
    }

    public int getnumeroTotale(){
        return this.numeroTotale;
    }
}
