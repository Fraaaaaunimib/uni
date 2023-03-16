import java.util.Scanner;
public class Test1{

    public static void main (String[] args) {

        Studente studente = new Studente();
        studente.cognome = "Rossi";
        studente.nome = "Mario";

        studente.libretto = new Libretto();
        studente.libretto.esami = new Esame[5];
        for (int i = 0; i < studente.libretto.esami.length;i++){
            studente.libretto.esami[i] = new Esame();
            studente.libretto.esami[i].insegnamento = new Insegnamento();
        }

        Scanner sc = new Scanner(System.in);

        //metodo per farti inserire tutti i dati
        System.out.print("Vuoi aggiungere un esame al tuo libretto? ");
            String librettoChoice = sc.next();
            librettoChoice = librettoChoice.toLowerCase();
boolean continue1 = true;
            switch (librettoChoice) {
                case "yes":

                while (continue1 == true){
                    for (int i = 0; i < studente.libretto.esami.length;i++){
                        if (studente.libretto.esami[i].insegnamento.cfu == 0){
                System.out.print("Quanti CFU ha l'insegnamento del tuo esame? ");
                studente.libretto.esami[i].insegnamento.cfu = sc.nextInt();

                System.out.println("Come si chiama l'insegnamento? ");
                studente.libretto.esami[i].insegnamento.denominazione = sc.next();

                System.out.print("Qual'è l'ID dell'insegnamento? ");
                studente.libretto.esami[i].insegnamento.id = sc.next();

                System.out.print("Ok, quando hai svolto l'esame? ");
                studente.libretto.esami[i].data = sc.next();

                System.out.print("Che voto hai preso? ");
                studente.libretto.esami[i].voto = sc.nextInt();

                System.out.println("Hai aggiunto l'insegnamento " + studente.libretto.esami[i].insegnamento.denominazione + " con CFU " + studente.libretto.esami[i].insegnamento.cfu + " relativo all'esame che hai fatto il " + studente.libretto.esami[i].data + " con un voto di " + studente.libretto.esami[i].voto);

                System.out.print("Vuoi aggiungere un nuovo esame? ");
                String whileChoice = sc.next();
                whileChoice = whileChoice.toLowerCase();
                switch (whileChoice){
                    case "yes":
                    continue1 = true;
                    break;

                    case "no":
                    continue1 = false;
                    break;

                    default:
                    break;
                }
                }
                }
            }
                break;

                case "vedi":
            for (int i = 0; i < studente.libretto.esami.length; i++){
                if (studente.libretto.esami[i].insegnamento.cfu != 0){
                    System.out.println("Insegnamento " + studente.libretto.esami[i].insegnamento.denominazione + " con CFU " + studente.libretto.esami[i].insegnamento.cfu + " relativo all'esame che hai fatto il " + studente.libretto.esami[i].data + " con un voto di " + studente.libretto.esami[i].voto);

                }
            }
                break;
                sc.close();
                
        }
                    }
                }
                
            