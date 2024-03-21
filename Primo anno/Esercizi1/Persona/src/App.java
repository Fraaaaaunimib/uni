public class App {
    public static void main(String[] args) {
       Persona persona1 = new Persona("E", 20);
       Persona persona2 = new Persona("H", 40);
       System.out.println(persona1.equals(persona2));
       System.out.println(persona1.vecchia(persona2));
       System.out.println(persona1.giovane(persona2));
    }
}

class Persona{
    private String nome;
    private int eta;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEta() {
        return this.eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public Persona(){
        this.nome = "Nessun nome";
        this.eta = 0;
    }

    public Persona creaPersonaAdulta(){
        return new Persona("Un adulto", 21);
    }
    public Persona(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }


    public boolean equals(Persona altra){
        return (this.getNome() == altra.getNome() && this.getEta() == altra.getEta());
    }

    public boolean vecchia(Persona altra){
        if (this.getEta() > altra.getEta()) {
            System.out.println(this.getNome() + " è più vecchia di " + altra.getNome());
            return true;
        } else {
            System.out.println(altra.getNome() + " è più vecchia di " + this.getNome());
            return false;
        }
    }

    public boolean giovane(Persona altra){
        if (this.getEta() < altra.getEta()) {
            System.out.println(this.getNome() + " è più giovane di " + altra.getNome());
            return true;
        } else {
            System.out.println(altra.getNome() + " è più giovane di " + this.getNome());
            return false;
        }
    }

    
}