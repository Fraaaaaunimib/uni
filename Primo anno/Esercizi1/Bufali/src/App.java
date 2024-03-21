public class App {
    public static void main(String[] args) throws Exception {
        Klingon klingon = new Klingon(100, 15);
        Elefanti elefanti = new Elefanti(10, 35);
        int anni = 30;
       System.out.println(elefanti.anni(elefanti, klingon, anni));

    }
}

class Klingon{
    private double casi;
    private double crescita;

    public double getCasi() {
        return this.casi;
    }

    public void setCasi(double casi) {
        this.casi = casi;
    }

    public double getCrescita() {
        return this.crescita;
    }

    public void setCrescita(int crescita) {
        this.crescita = crescita;
    }


    public Klingon(int casi, int crescita) {
        this.casi = casi;
        this.crescita = crescita;
    }

}

class Elefanti{
    private double casi;
    private double crescita;

    public Elefanti(int casi, int crescita) {
        this.casi = casi;
        this.crescita = crescita;
    }

    public double getCasi() {
        return this.casi;
    }

    public void setCasi(double casi) {
        this.casi = casi;
    }

    public double getCrescita() {
        return this.crescita;
    }

    public void setCrescita(int crescita) {
        this.crescita = crescita;
    }

    public double anni(Elefanti elefanti, Klingon klingon, int anni){
        double totale = 0;
        for (int i = 0; i < anni; i++){
            elefanti.setCasi(elefanti.getCasi() + elefanti.getCasi() * (elefanti.getCrescita()/100));
            klingon.setCasi(klingon.getCasi() + klingon.getCasi() * (klingon.getCrescita()/100));
            if (elefanti.getCasi() > klingon.getCasi()) return totale;
        }
        return totale;
    }
}

