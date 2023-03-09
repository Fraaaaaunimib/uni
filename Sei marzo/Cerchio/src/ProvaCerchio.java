public class ProvaCerchio {
    
    public static void main(String[] args) throws Exception {
        Punto p1 = new Punto(); //creare un nuovo oggetto Punto

        p1.x = 1;
        p1.y = 1;

        Cerchio c1 = new Cerchio();
        c1.raggio = 2;
        c1.centro = p1;
       // c1.centro.x = 20; //posso accedere alla variabiel x di centro perché ho assegnato p1 a c1.centro, che è quindi diventato un oggetto punto.
        //p1.x = 60;

        Cerchio c2 = new Cerchio();
        c2.centro = new Punto();
        c2.centro.x = 1;
        c2.centro.y = 2;

        //Punto p3 = c2.centro;

        //c2 = null;

        boolean esito = c1 == c2;
        System.out.println("C1 e C2 sono uguali? " + esito);
    }
}
