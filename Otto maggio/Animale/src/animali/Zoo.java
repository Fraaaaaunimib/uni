package animali;

public class Zoo {
    private Animale animali[];

    public Zoo(int maxNumAnimali){
        animali = new Animale[maxNumAnimali];
    }

    public boolean aggiungiAnimale(Animale animale){
        for (int i = 0; i < animali.length; ++i){
            if (animali[i] == null){
                animali[i] = animale;
                return true;
            }
        }
        return false;
    }

    public int numeroAnimali(){
        int numAnimali = 0;
        for (int i = 0; i < animali.length; ++i){
            if(animali[i] != null){
                ++numAnimali;
            }
        }
        return numAnimali;
    }

    public int etaAnimalePiuVecchio(){
        int maxEta = 0;
        for (int i = 0; i < animali.length; ++i){
            if (animali[i] != null && animali[i].calcolaAnniUomo()>maxEta){
                maxEta = animali[i].calcolaAnniUomo();
            }
        }
        return maxEta;
    }

    public int contaPappagalliParlanti(){
        int numPappagalli = 0;
        for (int i = 0; i < animali.length; ++i){
            if(animali[i] != null && animali[i]  instanceOf Pappagallo && ((Pappagallo)animali[i]).getParlante()){
                return 0;
            }
        }
        return 1;
    }
}
