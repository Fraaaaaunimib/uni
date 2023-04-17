public class Vino {
    private String nome;
    private int anno;
    private double prezzo;


    public String getNome() {
        return this.nome;
    }

    public int getAnno() {
        return this.anno;
    }

    public double getPrezzo() {
        return this.prezzo;
    }

    public void setPrezzo(double prezzo) {
        if (prezzo < 0){
            prezzo = 0;
        }
        this.prezzo = prezzo;
    }


    public Vino(String nome, int anno, double prezzo) {
        this.nome = nome;
        this.anno = anno;
        this.setPrezzo(prezzo);
    }

    public Vino(String nome, int anno){
        this.nome = nome;
        this.anno = anno;
        this.prezzo = 0;
    }

    public boolean equals(Vino vino){
        return(this.nome. equalsIgnoreCase(vino.nome)); //tipo boolean 
    }
}

class Cantina{
    private Vino[] vino;

    public Cantina(int dimensione){
        if (dimensione <= 0) dimensione = 10;
        this.vino = new Vino[dimensione];
    }

    public Cantina(){
        this.vino = new Vino[10];
    }

    public boolean aggiungi(Vino vinoi){
        if (vinoi == null) return false;

        for (int i = 0; i < this.vino.length;i++){
            if (vino[i] == null){
                vino[i] = vinoi;
                return true;
            }
        }
        return false;
    }

    public Vino[] preleva(Vino vinoi, int numeroBottiglie){
        for (int i = 0; i < this.vino.length; i++){
            if (vino[i].getPrezzo() > 0)
                vino[i] = null;
        }
        return vino;
    }
}