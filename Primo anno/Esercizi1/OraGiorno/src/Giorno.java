public class Giorno {
    public static void main(String[] args) {
        
        Ora giorno = new Ora();
        giorno.setOra(23,12);
        System.out.println(giorno.getOra());
        giorno.setOra(25, 99);
        System.out.println(giorno.getOra());
        giorno.setOra(23, 12, true);
        System.out.println(giorno.getOra());
        giorno.setOra(23, 12, false);
        System.out.println(giorno.getOra());

    }
}

class Ora{
    private int ore;
    private int minuti;

    public Ora(int ore, int minuti){
        if (valid(ore, minuti)){
            this.ore = ore;
            this.minuti = minuti;
        }
    }

    public Ora(){
        this.ore = 0;
        this.minuti = 0;
    }

    public boolean valid(int ore, int minuti){
        return (ore >= 0 && ore <= 23 && minuti >= 0 && minuti <= 59);
    }

    public String getOra(){
        return (this.ore + ":" + this.minuti);
    }

    public void setOra(int ore, int minuti){
        if (valid(ore, minuti)){
            this.ore = ore;
            this.minuti = minuti;
        } else {
            System.out.println("Oopsie, non è valido!");
        }
    }

    public void setOra(int ore, int minuti, boolean AM){
        if (valid(ore, minuti)){
            if (AM){
                ore = ore - 12;
                this.ore = ore;
                this.minuti = minuti;
            } else {
                ore = ore - 12;
                this.ore = ore;
                this.minuti = minuti;
            }
        }
    }

}
