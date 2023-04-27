public class App2 {
    public static void main(String[] args) {
        
        Imposta imposte = new Imposta();
        System.out.println("Costo base: " + imposte.computaCostoBase(30.5));
        System.out.println("Costo lusso: " + imposte.computaCostoLusso(30.5));
        imposte.cambiaImpostaBase(50);
        imposte.cambiaImpostaLusso(60);
        System.out.println("Costo base: " + imposte.computaCostoBase(30.5));
        System.out.println("Costo lusso: " + imposte.computaCostoLusso(30.5));
        System.out.println("Costo base: " + imposte.arrotondaCentesimo(imposte.computaCostoBase(30)));
        System.out.println("Costo lusso: " + imposte.arrotondaCentesimo(imposte.computaCostoLusso(30)));
    }

}

class Imposta{
    private static int impostaBase = 4;
    private static int impostaLusso = 10;

    public static double computaCostoBase(double prezzo){

        //x:prezzo = 4:100 --> (prezzo*4)/100 

        return (((prezzo*impostaBase)/100) + prezzo);
    }

    public static double computaCostoLusso(double prezzo){
        return (((prezzo*impostaLusso)/100)+prezzo);
    }

    public static void cambiaImpostaBase(int nuovaImpostaBase){
        impostaBase = nuovaImpostaBase;
    }

    public static void cambiaImpostaLusso(int nuovaImpostaLusso){
        impostaLusso=nuovaImpostaLusso;
    }

    public static double arrotondaCentesimo(double prezzo){
        return (Math.ceil(prezzo));
    }

}
