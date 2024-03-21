import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Stanza stanza1 = new Stanza();
        Stanza stanza2 = new Stanza();
        stanza1.setNome("cucina");
        stanza2.setNome("camera");
        stanza1.setLarghezza(4);
        stanza1.setLunghezza(5);
        stanza2.setLarghezza(3);
        stanza2.setLunghezza(8);

        Stanza stanza3 = new Stanza();
        stanza3.setNome("corridoio");
        stanza3.setLarghezza(2);

        System.out.println(stanza1.toString());
        System.out.println(stanza2.toString());
        System.out.println(stanza3.toString());
        
        stanza3.setLunghezza(stanza1.getLunghezza() + stanza2.getLunghezza());

        System.out.println(stanza1.toString());
        System.out.println(stanza2.toString());
        System.out.println(stanza3.toString());

        System.out.println("Area complessiva appartamento: " + stanza1.calcolaArea() + stanza2.calcolaArea() + stanza3.calcolaArea());


        //esercizio 2
        System.out.println ();
        Scanner sc = new Scanner(System.in);

        Casa casa1 = new Casa();
        Casa casa2 = new Casa();
        System.out.print("Prima superficie: ");
        casa1.setSuperficie(sc.nextFloat());
        System.out.print("Seconda superficie: ");
        casa2.setSuperficie(sc.nextFloat());
        System.out.print("Primo costo: ");
        casa1.setCosto(sc.nextFloat());
        System.out.print("Secondo costo: ");
        casa2.setCosto(sc.nextFloat());

        Casa casa3 = new Casa();
        casa3.setSuperficie(100);
        if (casa1.getCosto() > casa2.getCosto()){
            casa3.setCosto(casa1.getCosto());
        } else {
            casa3.setCosto(casa2.getCosto());
        }

        System.out.println(casa1.toString());
        System.out.println(casa2.toString());
        System.out.println(casa3.toString());
        sc.close();
    }

    
}

class Stanza{
    private String nome;
    private double lunghezza;
    private double larghezza;


    public String getNome(){
        return this.nome;
    }

    public double getLunghezza(){
        return this.lunghezza;
    }

    public double getLarghezza(){
        return this.larghezza;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setLarghezza(double larghezza){
        this.larghezza = larghezza;
    }

    public void setLunghezza(double lunghezza){
        this.lunghezza = lunghezza;
    }

    public double calcolaArea(){
        return this.larghezza*this.lunghezza;
    }

    public String toString(){
        return "Nome: " + this.getNome() + ", larghezza: " + this.getLarghezza() + ", lunghezza: " + this.getLunghezza() + ", area: " + this.calcolaArea();
    }
}

class Casa{
    private float costo;
    private float superficie;



    public float getCosto() {
        return this.costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public float getSuperficie() {
        return this.superficie;
    }

    public void setSuperficie(float superficie) {
        this.superficie = superficie;
    }


    @Override
    public String toString() {
        return "{" +
            " costo='" + getCosto() + "'" +
            ", superficie='" + getSuperficie() + "'" +
            "}";
    }

    public void aggiornaCosto(float costoMetro){
        if (this.getSuperficie()*costoMetro > this.getSuperficie()){
            this.setCosto(this.getSuperficie()*costoMetro);
        }
    }

    public float calcolaCostoMetro(){
        return costo/superficie;
    }
}