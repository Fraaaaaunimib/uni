public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        imposte Imposta = new imposte();
        imposte.cambiaImpostaBase(5);
        imposte.cambiaImpostaDiLusso(6);
        
        System.out.println(imposte.computaCostoBase(5));
        System.out.println(imposte.computaCostoLusso(5));
        System.out.println(imposte.arrotondaACentesimoVicino(5.625));

        System.out.println("ore");
        Ora ore = new Ora();
        ore.setOra(5,6);
        System.out.println(ore.getOra() + ":" + ore.getMinuti());
        ore.setOra(15,45, true);
        System.out.println(ore.getOra() + ":" + ore.getMinuti());
        ore.setOra(11, 25, false);
        System.out.println(ore.getOra() + ":" + ore.getMinuti());
    }
}

class imposte{

    private static double impostaBase;
    private static double impostaLusso;

    public static double computaCostoBase(int prezzo){
        return Math.floor((prezzo+(prezzo*(impostaBase/100))));
    }

    public static double computaCostoLusso(int prezzo){
        return Math.floor((prezzo+(prezzo*(impostaLusso/100))));
    }

    public static void cambiaImpostaBase(double nuovaImpostaBase){
        impostaBase = nuovaImpostaBase;
    }

    public static void cambiaImpostaDiLusso(double nuovaImpostaLusso){
        impostaLusso = nuovaImpostaLusso;
    }

    public static double arrotondaACentesimoVicino(double prezzo){
        return Math.ceil(prezzo);
    }
}

class Ora{
    private int ora;
    private int minuti;

    public Ora(){
        this.ora = 0;
        this.minuti = 0;
    }

    private boolean valida(int ore, int minute){
        return (ore < 23 && ore >= 0 && minute < 59 && minute > 0);
    }

    public void setOra(int ore, int minuti){
        if (valida(ore, minuti)){
            this.ora = ore;
            this.minuti = minuti;
        }
    }

    public int getOra(){
        return this.ora;
    }

    public int getMinuti(){
        return this.minuti;
    }

    public void setOra(int ore, int minuti, boolean AM){
        if (valida(ore, minuti)){
            if (AM){
                if(ore > 12) ore -= 12;
            } else if (!AM){
                if(ore < 12) ore += 12;
            }
            this.ora = ore;
            this.minuti = minuti;
        }
    }
}