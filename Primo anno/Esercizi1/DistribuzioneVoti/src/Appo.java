import java.util.Scanner;
public class Appo {
    public static void main(String[] args) {
        
        Studente studente1 = new Studente(5);
        studente1.setVoti();
        studente1.printVoti();
        
    }
}

class Voti{
    private int voto;


    public int getVoto() {
        return this.voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }


}

class Studente{
    private Voti[] voto;


    public Studente(int dimensione) {
        this.voto = new Voti[dimensione];
        for (int i = 0; i < this.voto.length; i++){
            this.voto[i] = new Voti();

        }
    }

    public void setVoti(){
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < this.getVoti(); i++){
            System.out.print("Inserisci un numero: ");
            this.voto[i].setVoto(sc.nextInt());
            
        }
        sc.close();
    }
    public int getVoti(){
        return this.voto.length;
    }
    public int totVoti(){
        int tot = 0;
        for (int i = 0; i < this.voto.length; i++){
            tot += this.voto[i].getVoto();
        }
        return tot;
    }

    public void printVoti(){
        for (int x = 0; x < 50; x++){
            System.out.print("*");
        }
        System.out.println();
        for (int i = 0; i < this.voto.length; i++){
            if (i == 0) System.out.print("A ");
            if (i == 1) System.out.print("B ");
            if (i == 2) System.out.print("C ");
            if (i == 3) System.out.print("D ");
            if (i == 4) System.out.print("F ");

            int a = (this.voto[i].getVoto()*100)/this.totVoti();
                int j = (int) (Math.ceil(a*50)/100);

           
         for (int x = 0; x < j; x++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}